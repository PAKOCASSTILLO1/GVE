package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.ComiteEjecutivoNacional;

@Repository
public interface ComiteEjecutivoNacionalRepository extends JpaRepository<ComiteEjecutivoNacional, Integer>{

}
