package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.Mesa;
import com.gve.gve.model.Padron;
import com.gve.gve.model.PadronMesa;
import com.gve.gve.repository.MesaRepository;
import com.gve.gve.repository.PadronMesaRepository;
import com.gve.gve.repository.PadronRepository;
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
@RequestMapping("/padronMesa")
public class PadronMesaController {

    @Autowired
    PadronMesaRepository padronMesaRepository;

    @Autowired
    MesaRepository mesaRepository;

    @Autowired
    PadronRepository padronRepository;

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> crear2(@RequestBody PadronMesa body){
        List<PadronMesa> data = new ArrayList<>();
        try {
            Mesa mesa = mesaRepository.findById(body.getMesa()).orElse(null);
            Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
            body.setCod_mesa(mesa);
            body.setCod_padron(padron);
            data.add(padronMesaRepository.save(body));
            body.setCod_mesa(null);
            body.setCod_padron(null);
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
            List<PadronMesa> padronMesas =  padronMesaRepository.findAll();
            List<PadronMesa> data = new ArrayList<>();
            for (PadronMesa padronMesa : padronMesas) {
                if (padronMesa.getEstado()==1) {
                    padronMesa.setCod_mesa(null);
                    padronMesa.setCod_padron(null);
                    data.add(padronMesa);
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
        List<PadronMesa> data = new ArrayList<>();
        try {
            PadronMesa padronMesa = padronMesaRepository.findById(id).orElse(null);
            padronMesa.setCod_mesa(null);
            padronMesa.setCod_padron(null);
            data.add(padronMesa);
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
    public ResponseEntity<ApiResponse> editar2(@RequestBody PadronMesa body, @PathVariable int id){
        List<PadronMesa> data = new ArrayList<>();
        try {
            PadronMesa padronMesa = padronMesaRepository.findById(id).orElse(null);
            Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
            Mesa mesa = mesaRepository.findById(body.getMesa()).orElse(null);
            padronMesa = padronMesaRepository.save(padronMesa.modified(body, padron, mesa));
            padronMesa.setCod_mesa(null);
            padronMesa.setCod_padron(null);
            data.add(padronMesa);
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
            PadronMesa padronMesa = padronMesaRepository.findById(id).orElse(null);
            padronMesa.setEstado((byte) 0);
            padronMesaRepository.save(padronMesa);
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