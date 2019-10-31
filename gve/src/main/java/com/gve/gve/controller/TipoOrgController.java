package com.gve.gve.controller;

import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.TipoFiscal;
import com.gve.gve.repository.TipoFiscalRepository;
import com.gve.gve.util.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tipoOrg")
public class TipoOrgController {

    @Autowired
    TipoFiscalRepository tipoFiscalRepository;

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar(){
        try {
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", tipoFiscalRepository.findAll());
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<ApiResponse> ver(@PathVariable int id){
        try {
            List<TipoFiscal> data = new ArrayList<>();
            data.add(tipoFiscalRepository.findById(id).orElse(null));
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

    
    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> ver(@RequestBody TipoFiscal tipoFiscal){
        try {
            List<TipoFiscal> data = new ArrayList<>();
            data.add(tipoFiscalRepository.save(tipoFiscal));
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);  
        }
    }

    // @PutMapping("/editar/{id}") // NOMBRE, USUARIO, STATE
    // public ResponseEntity<ApiResponse> editar(@PathVariable int id, @RequestBody TipoFiscal body){
    //     try {
    //         List<TipoFiscal> data = new ArrayList<>();
    //         TipoFiscal tipoFiscal = tipoFiscalRepository.findById(id).orElse(null);            
    //         data.add(tipoFiscalRepository.save(tipoFiscal.modified(body)));
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
    public ResponseEntity<ApiResponse> borrar(@PathVariable int id){
        try {
            TipoFiscal tipoFiscal = tipoFiscalRepository.findById(id).orElse(null);
            tipoFiscalRepository.delete(tipoFiscal);
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