package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{

}
