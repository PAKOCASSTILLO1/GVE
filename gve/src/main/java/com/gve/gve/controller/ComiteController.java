package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.ComiteEjecutivoNacional;
import com.gve.gve.repository.CentroVotacionRepository;
import com.gve.gve.repository.ComiteEjecutivoNacionalRepository;
import com.gve.gve.util.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comite")
public class ComiteController {

    @Autowired
    ComiteEjecutivoNacionalRepository comiteEjecutivoNacionalRepository;

    @Autowired
    CentroVotacionRepository centroVotacionRepository;

    // @PostMapping("/crear")
    // public ResponseEntity<ApiResponse> crear2(@RequestBody ComiteEjecutivoNacional body){
    //     List<ComiteEjecutivoNacional> data = new ArrayList<>();
    //     try {
    //         body.setCod_centro_votacion(centroVotacionRepository.findById(body.getCentroVotacion()).orElse(null));
    //         body = comiteEjecutivoNacionalRepository.save(body);
    //         body.setCod_centro_votacion(null);
    //         data.add(body);
    //         ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
    //         return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    //     } catch (Exception e) {
    //         ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
    //         return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
    //     }
    // }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar2(){
        try {

            List<ComiteEjecutivoNacional> comiteEjecutivoNacionals =  comiteEjecutivoNacionalRepository.findAll();
            List<ComiteEjecutivoNacional> data = new ArrayList<>();
            for (ComiteEjecutivoNacional comiteEjecutivoNacional : comiteEjecutivoNacionals) {
                if (comiteEjecutivoNacional.getEstado()==1) {
                    comiteEjecutivoNacional.setCod_organizacion_politica(null);
                    comiteEjecutivoNacional.setCod_tipo_cargo(null);                    
                    comiteEjecutivoNacional.setCod_afiliado(null);
                    data.add(comiteEjecutivoNacional);
                }
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
        List<ComiteEjecutivoNacional> data = new ArrayList<>();
        try {
            ComiteEjecutivoNacional body = comiteEjecutivoNacionalRepository.findById(id).orElse(null);
            body.setCod_organizacion_politica(null);
            body.setCod_tipo_cargo(null);                    
            body.setCod_afiliado(null);
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
    // public ResponseEntity<ApiResponse> editar2(@RequestBody ComiteEjecutivoNacional body, @PathVariable int id){
    //     List<ComiteEjecutivoNacional> data = new ArrayList<>();
    //     try {
    //         ComiteEjecutivoNacional comiteEjecutivoNacional = comiteEjecutivoNacionalRepository.findById(id).orElse(null);
    //         CentroVotacion centroVotacion = centroVotacionRepository.findById(body.getCentroVotacion()).orElse(null);
    //         comiteEjecutivoNacional = comiteEjecutivoNacionalRepository.save(comiteEjecutivoNacional.modified(body, centroVotacion));
    //         comiteEjecutivoNacional.setCod_centro_votacion(null);
    //         data.add(comiteEjecutivoNacional);
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

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<ApiResponse> editar(@PathVariable int id){
        try {
            ComiteEjecutivoNacional comiteEjecutivoNacional = comiteEjecutivoNacionalRepository.findById(id).orElse(null);
            comiteEjecutivoNacional.setEstado((byte) 0);
            comiteEjecutivoNacionalRepository.save(comiteEjecutivoNacional);
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", null);
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
}