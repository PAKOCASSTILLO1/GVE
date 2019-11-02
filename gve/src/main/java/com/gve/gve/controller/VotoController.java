package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.Mesa;
import com.gve.gve.model.TipoVotacion;
import com.gve.gve.model.Voto;
import com.gve.gve.repository.MesaRepository;
import com.gve.gve.repository.TipoVotacionRepository;
import com.gve.gve.repository.VotoRepository;
import com.gve.gve.util.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    VotoRepository votoRepository;
    @Autowired
    TipoVotacionRepository tipoVotacionRepository;

    @Autowired
    MesaRepository mesaRepository;

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> crear2(@RequestBody Voto body){
        List<Voto> data = new ArrayList<>();
        try {
            TipoVotacion tipoVotacion = tipoVotacionRepository.findById(body.getTipoVotacion()).orElse(null);
            Mesa mesa = mesaRepository.findById(body.getMesa()).orElse(null);
            body.setCod_mesa(mesa);
            body.setCod_tipo_votacion(tipoVotacion);
            body = votoRepository.save(body);
            body.setCod_mesa(null);
            body.setCod_tipo_votacion(null);
            data.add(body);
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar2(){
        try {
            List<Voto> votos =  votoRepository.findAll();
            List<Voto> data = new ArrayList<>();
            for (Voto voto : votos) {
                voto.setCod_tipo_votacion(null);
                voto.setCod_mesa(null);
                data.add(voto);
            }
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<ApiResponse> ver(@PathVariable int id){
        List<Voto> data = new ArrayList<>();
        try {
            Voto body = votoRepository.findById(id).orElse(null);
            body.setCod_tipo_votacion(null);
            body.setCod_mesa(null);
            data.add(body);
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    // @PutMapping("/editar/{id}")
    // public ResponseEntity<ApiResponse> editar2(@RequestBody Voto body, @PathVariable int id){
    //     List<Voto> data = new ArrayList<>();
    //     try {
    //         Voto voto = votoRepository.findById(id).orElse(null);
    //         Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
    //         OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
    //         votoRepository.save(voto.modified(body, padron, organizacionPolitica));
    //         voto.setCod_padron(null);
    //         voto.setCod_organizacion_politica(null);
    //         data.add(voto);
    //         ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
    //         return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    //     } catch (Exception e) {
    //         if (e.toString().equals("java.lang.NullPointerException")) {
    //             ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
    //             return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    //         } else {
    //             ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
    //             return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    //         }
    //     }
    // }

    // @DeleteMapping("/borrar/{id}")
    // public ResponseEntity<ApiResponse> editar(@PathVariable int id){
    //     try {
    //         Voto voto = votoRepository.findById(id).orElse(null);
    //         votoRepository.delete(voto);
    //         ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", null);
    //         return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    //     } catch (Exception e) {
    //         if (e.toString().equals("java.lang.NullPointerException")) {
    //             ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
    //             return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    //         } else {
    //             ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
    //             return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    //         }
    //     }
    // }
}