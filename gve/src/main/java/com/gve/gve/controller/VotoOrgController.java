package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.OrganizacionPolitica;
import com.gve.gve.model.Voto;
import com.gve.gve.model.VotoOrganizacion;
import com.gve.gve.repository.OrganizacionPoliticaRepository;
import com.gve.gve.repository.VotoOrganizacionRepository;
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
@RequestMapping("/votoOrg")
public class VotoOrgController {

    @Autowired
    VotoOrganizacionRepository votoOrganizacionRepository;

    @Autowired
    OrganizacionPoliticaRepository organizacionPoliticaRepository;

    @Autowired
    VotoRepository votoRepository;

    // Organizacion Politica
    // Voto

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> crear2(@RequestBody VotoOrganizacion body){
        List<VotoOrganizacion> data = new ArrayList<>();
        try {
            OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
            Voto voto = votoRepository.findById(body.getVoto()).orElse(null);
            body.setCod_voto(voto);
            body.setCod_organizacion_politica(organizacionPolitica);
            body = votoOrganizacionRepository.save(body);
            body.setCod_voto(null);
            body.setCod_organizacion_politica(null);
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
            List<VotoOrganizacion> votoOrganizacions =  votoOrganizacionRepository.findAll();
            List<VotoOrganizacion> data = new ArrayList<>();
            for (VotoOrganizacion votoOrganizacion : votoOrganizacions) {
                votoOrganizacion.setCod_voto(null);
                votoOrganizacion.setCod_organizacion_politica(null);
                data.add(votoOrganizacion);
            }
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/listarVotosOrg/{id}")
    public ResponseEntity<ApiResponse> listarVotos(@PathVariable int id){
        try {
            List<VotoOrganizacion> votoOrganizacions =  votoOrganizacionRepository.findByOrganizacionPolitica(id);
            List<VotoOrganizacion> data = new ArrayList<>();
            for (VotoOrganizacion votoOrganizacion : votoOrganizacions) {
                Voto voto = votoOrganizacion.getCod_voto();
                voto.setCod_mesa(null);
                voto.setCod_tipo_votacion(null);
                votoOrganizacion.setCod_voto(null);
                votoOrganizacion.setCod_organizacion_politica(null);
                data.add(votoOrganizacion);
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
        List<VotoOrganizacion> data = new ArrayList<>();
        try {
            VotoOrganizacion body = votoOrganizacionRepository.findById(id).orElse(null);
            body.setCod_voto(null);
            body.setCod_organizacion_politica(null);
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
    // public ResponseEntity<ApiResponse> editar2(@RequestBody VotoOrganizacion body, @PathVariable int id){
    //     List<VotoOrganizacion> data = new ArrayList<>();
    //     try {
    //         VotoOrganizacion votoOrganizacion = votoOrganizacionRepository.findById(id).orElse(null);
    //         Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
    //         OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
    //         votoOrganizacionRepository.save(votoOrganizacion.modified(body, padron, organizacionPolitica));
    //         votoOrganizacion.setCod_padron(null);
    //         votoOrganizacion.setCod_organizacion_politica(null);
    //         data.add(votoOrganizacion);
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
    //         VotoOrganizacion votoOrganizacion = votoOrganizacionRepository.findById(id).orElse(null);
    //         votoOrganizacionRepository.delete(votoOrganizacion);
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