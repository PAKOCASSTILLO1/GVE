package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.Junta;

@Repository
public interface JuntaRepository extends JpaRepository<Junta, Integer>{

}
