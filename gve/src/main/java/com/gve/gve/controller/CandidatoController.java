package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.Candidato;
import com.gve.gve.repository.CandidatoRepository;
import com.gve.gve.util.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    CandidatoRepository candidatoRepository;

    // @Autowired
    // EleccionRepository eleccionRepository;

    // @Autowired
    // MunicipioRepository municipioRepository;

    // @PostMapping("/crear")
    // public ResponseEntity<ApiResponse> crear2(@RequestBody Candidato body){
    //     List<Candidato> data = new ArrayList<>();
    //     try {
    //         Eleccion eleccion = eleccionRepository.findById(body.getEleccion()).orElse(null);
    //         Municipio municipio = municipioRepository.findById(body.getMunicipio()).orElse(null);
    //         body.setCod_municipio(municipio);
    //         body.setCod_eleccion(eleccion);
    //         body = candidatoElectoralCemsRepository.save(body);
    //         body.setCod_municipio(null);
    //         body.setCod_eleccion(null);
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
            List<Candidato> candidatos =  candidatoRepository.findAll();
            List<Candidato> data = new ArrayList<>();
            for (Candidato candidato : candidatos) {
                if (candidato.getEstado()==1) {
                    candidato.setCod_afiliado(null);
                    candidato.setCod_organizacion_politica(null);
                    candidato.setCod_tipo_cargo(null);
                    candidato.setCod_tipo_votacion(null);
                    data.add(candidato);
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
        List<Candidato> data = new ArrayList<>();
        try {
            Candidato body = candidatoRepository.findById(id).orElse(null);
            body.setCod_afiliado(null);
            body.setCod_organizacion_politica(null);
            body.setCod_tipo_cargo(null);
            body.setCod_tipo_votacion(null);
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
    // public ResponseEntity<ApiResponse> editar2(@RequestBody Candidato body, @PathVariable int id){
    //     List<Candidato> data = new ArrayList<>();
    //     try {
    //         Candidato distrito = candidatoRepository.findById(id).orElse(null);
    //         Municipio municipio = municipioRepository.findById(body.getMunicipio()).orElse(null);
    //         Eleccion eleccion = eleccionRepository.findById(body.getEleccion()).orElse(null);
    //         candidatoRepository.save(distrito.modified(body, municipio, eleccion));
    //         distrito.setCod_municipio(null);
    //         distrito.setCod_eleccion(null);
    //         data.add(distrito);
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
            Candidato candidato = candidatoRepository.findById(id).orElse(null);
            candidato.setEstado((byte) 0);
            candidatoRepository.save(candidato);
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