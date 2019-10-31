package com.gve.gve.controller;

import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.Rol;
import com.gve.gve.repository.RolRepository;
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
@RequestMapping("/rol")
public class RolController {

    @Autowired
    RolRepository rolRepository;

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar(){
        try {
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", rolRepository.findAll());
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<ApiResponse> ver(@PathVariable int id){
        try {
            List<Rol> data = new ArrayList<>();
            data.add(rolRepository.findById(id).orElse(null));
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
    public ResponseEntity<ApiResponse> ver(@RequestBody Rol rol){
        try {
            List<Rol> data = new ArrayList<>();
            data.add(rolRepository.save(rol));
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);  
        }
    }

    // @PutMapping("/editar/{id}") // NOMBRE, USUARIO, STATE
    // public ResponseEntity<ApiResponse> editar(@PathVariable int id, @RequestBody Rol body){
    //     try {
    //         List<Rol> data = new ArrayList<>();
    //         Rol rol = rolRepository.findById(id).orElse(null);            
    //         data.add(rolRepository.save(rol.modified(body)));
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
            Rol rol = rolRepository.findById(id).orElse(null);
            rolRepository.delete(rol);
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