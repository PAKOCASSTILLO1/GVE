package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.TipoCargo;

@Repository
public interface TipoCargoRepository extends JpaRepository<TipoCargo, Integer>{

}
