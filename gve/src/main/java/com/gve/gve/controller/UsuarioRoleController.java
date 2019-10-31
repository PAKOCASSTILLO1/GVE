package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.UsuarioRole;
import com.gve.gve.repository.UsuarioRoleRepository;
import com.gve.gve.repository.OrganizacionPoliticaRepository;
import com.gve.gve.repository.PadronRepository;
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
@RequestMapping("/usuarioRole")
public class UsuarioRoleController {

    @Autowired
    UsuarioRoleRepository usuarioRoleRepository;

    @Autowired
    OrganizacionPoliticaRepository organizacionPoliticaRepository;

    @Autowired
    PadronRepository padronRepository;

    // @PostMapping("/crear")
    // public ResponseEntity<ApiResponse> crear2(@RequestBody UsuarioRole body){
    //     List<UsuarioRole> data = new ArrayList<>();
    //     try {
    //         OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
    //         Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
    //         body.setCod_padron(padron);
    //         body.setCod_organizacion_politica(organizacionPolitica);
    //         body = usuarioRoleRepository.save(body);
    //         body.setCod_padron(null);
    //         body.setCod_organizacion_politica(null);
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
            List<UsuarioRole> usuarioRoles =  usuarioRoleRepository.findAll();
            List<UsuarioRole> data = new ArrayList<>();
            for (UsuarioRole usuarioRole : usuarioRoles) {
                if (usuarioRole.getEstado()==1) {
                    usuarioRole.setCod_usuario(null);
                    usuarioRole.setCod_role(null);
                    data.add(usuarioRole);
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
        List<UsuarioRole> data = new ArrayList<>();
        try {
            UsuarioRole body = usuarioRoleRepository.findById(id).orElse(null);
            body.setCod_usuario(null);
            body.setCod_role(null);
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
    // public ResponseEntity<ApiResponse> editar2(@RequestBody UsuarioRole body, @PathVariable int id){
    //     List<UsuarioRole> data = new ArrayList<>();
    //     try {
    //         UsuarioRole usuarioRole = usuarioRoleRepository.findById(id).orElse(null);
    //         Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
    //         OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
    //         usuarioRoleRepository.save(usuarioRole.modified(body, padron, organizacionPolitica));
    //         usuarioRole.setCod_padron(null);
    //         usuarioRole.setCod_organizacion_politica(null);
    //         data.add(usuarioRole);
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
            UsuarioRole usuarioRole = usuarioRoleRepository.findById(id).orElse(null);
            usuarioRole.setEstado((byte) 0);
            usuarioRoleRepository.save(usuarioRole);
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