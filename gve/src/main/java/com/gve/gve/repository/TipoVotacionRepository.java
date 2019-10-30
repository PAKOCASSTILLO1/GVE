package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.TipoVotacion;

@Repository
public interface TipoVotacionRepository extends JpaRepository<TipoVotacion, Integer>{

}
