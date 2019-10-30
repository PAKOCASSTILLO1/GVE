package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.DistritoElectoralCems;
import com.gve.gve.model.Eleccion;
import com.gve.gve.model.Municipio;
import com.gve.gve.repository.DistritoElectoralCemsRepository;
import com.gve.gve.repository.EleccionRepository;
import com.gve.gve.repository.MunicipioRepository;
import com.gve.gve.util.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    DistritoElectoralCemsRepository distritoElectoralCemsRepository;

    @Autowired
    EleccionRepository eleccionRepository;

    @Autowired
    MunicipioRepository municipioRepository;

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> crear2(@RequestBody DistritoElectoralCems body){
        List<DistritoElectoralCems> data = new ArrayList<>();
        try {
            Eleccion eleccion = eleccionRepository.findById(body.getEleccion()).orElse(null);
            Municipio municipio = municipioRepository.findById(body.getMunicipio()).orElse(null);
            body.setCod_municipio(municipio);
            body.setCod_eleccion(eleccion);
            body = distritoElectoralCemsRepository.save(body);
            body.setCod_municipio(null);
            body.setCod_eleccion(null);
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
            List<DistritoElectoralCems> distritoElectoralCemss =  distritoElectoralCemsRepository.findAll();
            List<DistritoElectoralCems> data = new ArrayList<>();
            for (DistritoElectoralCems distritoElectoralCems : distritoElectoralCemss) {
                if (distritoElectoralCems.getEstado()==1) {
                    distritoElectoralCems.setCod_municipio(null);
                    distritoElectoralCems.setCod_eleccion(null);
                    data.add(distritoElectoralCems);
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
        List<DistritoElectoralCems> data = new ArrayList<>();
        try {
            DistritoElectoralCems body = distritoElectoralCemsRepository.findById(id).orElse(null);
            body.setCod_municipio(null);
            body.setCod_eleccion(null);
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

    @PutMapping("/editar/{id}")
    public ResponseEntity<ApiResponse> editar2(@RequestBody DistritoElectoralCems body, @PathVariable int id){
        List<DistritoElectoralCems> data = new ArrayList<>();
        try {
            DistritoElectoralCems distrito = distritoElectoralCemsRepository.findById(id).orElse(null);
            Municipio municipio = municipioRepository.findById(body.getMunicipio()).orElse(null);
            Eleccion eleccion = eleccionRepository.findById(body.getEleccion()).orElse(null);
            distritoElectoralCemsRepository.save(distrito.modified(body, municipio, eleccion));
            distrito.setCod_municipio(null);
            distrito.setCod_eleccion(null);
            data.add(distrito);
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

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<ApiResponse> editar(@PathVariable int id){
        try {
            DistritoElectoralCems distritoElectoralCems = distritoElectoralCemsRepository.findById(id).orElse(null);
            distritoElectoralCems.setEstado((byte) 0);
            distritoElectoralCemsRepository.save(distritoElectoralCems);
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