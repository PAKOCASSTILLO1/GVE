package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.PadronMesa;

@Repository
public interface PadronMesaRepository extends JpaRepository<PadronMesa, Integer>{

}
