package com.gve.gve.controller;

// FUNCIONANDO
import java.util.ArrayList;
import java.util.List;

import com.gve.gve.model.FiscalOrganizacion;
import com.gve.gve.repository.CentroVotacionRepository;
import com.gve.gve.repository.FiscalOrganizacionRepository;
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
@RequestMapping("/fiscalOrg")
public class FiscalOrgController {

    @Autowired
    FiscalOrganizacionRepository fiscalOrganizacionRepository;

    @Autowired
    CentroVotacionRepository centroVotacionRepository;

    // @PostMapping("/crear")
    // public ResponseEntity<ApiResponse> crear2(@RequestBody FiscalOrganizacion body){
    //     List<FiscalOrganizacion> data = new ArrayList<>();
    //     try {
    //         body.setCod_centro_votacion(centroVotacionRepository.findById(body.getCentroVotacion()).orElse(null));
    //         body = fiscalOrganizacionRepository.save(body);
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

            List<FiscalOrganizacion> fiscalOrganizacions =  fiscalOrganizacionRepository.findAll();
            List<FiscalOrganizacion> data = new ArrayList<>();
            for (FiscalOrganizacion fiscalOrganizacion : fiscalOrganizacions) {
                if (fiscalOrganizacion.getEstado()==1) {
                    fiscalOrganizacion.setCod_organizacion_politica(null);
                    fiscalOrganizacion.setCod_tipo_fiscal(null);                    
                    fiscalOrganizacion.setCod_afiliado(null);
                    data.add(fiscalOrganizacion);
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
        List<FiscalOrganizacion> data = new ArrayList<>();
        try {
            FiscalOrganizacion body = fiscalOrganizacionRepository.findById(id).orElse(null);
            body.setCod_organizacion_politica(null);
            body.setCod_tipo_fiscal(null);                    
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
    // public ResponseEntity<ApiResponse> editar2(@RequestBody FiscalOrganizacion body, @PathVariable int id){
    //     List<FiscalOrganizacion> data = new ArrayList<>();
    //     try {
    //         FiscalOrganizacion fiscalOrganizacion = fiscalOrganizacionRepository.findById(id).orElse(null);
    //         CentroVotacion centroVotacion = centroVotacionRepository.findById(body.getCentroVotacion()).orElse(null);
    //         fiscalOrganizacion = fiscalOrganizacionRepository.save(fiscalOrganizacion.modified(body, centroVotacion));
    //         fiscalOrganizacion.setCod_centro_votacion(null);
    //         data.add(fiscalOrganizacion);
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
            FiscalOrganizacion fiscalOrganizacion = fiscalOrganizacionRepository.findById(id).orElse(null);
            fiscalOrganizacion.setEstado((byte) 0);
            fiscalOrganizacionRepository.save(fiscalOrganizacion);
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