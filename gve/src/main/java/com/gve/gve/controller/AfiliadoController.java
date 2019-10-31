package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.Afiliado;
import com.gve.gve.model.OrganizacionPolitica;
import com.gve.gve.model.Padron;
import com.gve.gve.repository.AfiliadoRepository;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/afiliado")
public class AfiliadoController {

    @Autowired
    AfiliadoRepository afiliadoRepository;

    @Autowired
    OrganizacionPoliticaRepository organizacionPoliticaRepository;

    @Autowired
    PadronRepository padronRepository;

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> crear2(@RequestBody Afiliado body){
        List<Afiliado> data = new ArrayList<>();
        try {
            OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
            Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
            body.setCod_padron(padron);
            body.setCod_organizacion_politica(organizacionPolitica);
            body = afiliadoRepository.save(body);
            body.setCod_padron(null);
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
            List<Afiliado> afiliados =  afiliadoRepository.findAll();
            List<Afiliado> data = new ArrayList<>();
            for (Afiliado afiliado : afiliados) {
                if (afiliado.getEstado()==1) {
                    afiliado.setCod_padron(null);
                    afiliado.setCod_organizacion_politica(null);
                    data.add(afiliado);
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
        List<Afiliado> data = new ArrayList<>();
        try {
            Afiliado body = afiliadoRepository.findById(id).orElse(null);
            body.setCod_padron(null);
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

    @PutMapping("/editar/{id}")
    public ResponseEntity<ApiResponse> editar2(@RequestBody Afiliado body, @PathVariable int id){
        List<Afiliado> data = new ArrayList<>();
        try {
            Afiliado afiliado = afiliadoRepository.findById(id).orElse(null);
            Padron padron = padronRepository.findById(body.getPadron()).orElse(null);
            OrganizacionPolitica organizacionPolitica = organizacionPoliticaRepository.findById(body.getOrganizacionPolitica()).orElse(null);
            afiliadoRepository.save(afiliado.modified(body, padron, organizacionPolitica));
            afiliado.setCod_padron(null);
            afiliado.setCod_organizacion_politica(null);
            data.add(afiliado);
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
            Afiliado afiliado = afiliadoRepository.findById(id).orElse(null);
            afiliado.setEstado((byte) 0);
            afiliadoRepository.save(afiliado);
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