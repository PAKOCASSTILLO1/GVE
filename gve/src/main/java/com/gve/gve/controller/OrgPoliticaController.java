package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.OrganizacionPolitica;
import com.gve.gve.repository.CentroVotacionRepository;
import com.gve.gve.repository.OrganizacionPoliticaRepository;
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
@RequestMapping("/orgPolitica")
public class OrgPoliticaController {

    @Autowired
    OrganizacionPoliticaRepository organizacionPoliticaRepository;

    @Autowired
    CentroVotacionRepository centroVotacionRepository;

    // @PostMapping("/crear")
    // public ResponseEntity<ApiResponse> crear2(@RequestBody OrganizacionPolitica body){
    //     List<OrganizacionPolitica> data = new ArrayList<>();
    //     try {
    //         body.setCod_centro_votacion(centroVotacionRepository.findById(body.getCentroVotacion()).orElse(null));
    //         body = organizacionPoliticaRepository.save(body);
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

            List<OrganizacionPolitica> organizacionPoliticas =  organizacionPoliticaRepository.findAll();
            List<OrganizacionPolitica> data = new ArrayList<>();
            for (OrganizacionPolitica organizacionPolitica : organizacionPoliticas) {
                if (organizacionPolitica.getEstado()==1) {
                    organizacionPolitica.setCod_tipo_organizacion(null);
                    data.add(organizacionPolitica);
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
        List<OrganizacionPolitica> data = new ArrayList<>();
        try {
            OrganizacionPolitica body = organizacionPoliticaRepository.findById(id).orElse(null);
            body.setCod_tipo_organizacion(null);
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
    // public ResponseEntity<ApiResponse> editar2(@RequestBody OrganizacionPolitica body, @PathVariable int id){
    //     List<OrganizacionPolitica> data = new ArrayList<>();
    //     try {
    //         OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(id).orElse(null);
    //         CentroVotacion centroVotacion = centroVotacionRepository.findById(body.getCentroVotacion()).orElse(null);
    //         organizacionPolitica = organizacionPoliticaRepository.save(organizacionPolitica.modified(body, centroVotacion));
    //         organizacionPolitica.setCod_centro_votacion(null);
    //         data.add(organizacionPolitica);
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
            OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(id).orElse(null);
            organizacionPolitica.setEstado((byte) 0);
            organizacionPoliticaRepository.save(organizacionPolitica);
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