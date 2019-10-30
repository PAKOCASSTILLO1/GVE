package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.Eleccion;

@Repository
public interface EleccionRepository extends JpaRepository<Eleccion, Integer>{

}
