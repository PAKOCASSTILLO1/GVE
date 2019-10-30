package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.TipoFiscal;

@Repository
public interface TipoFiscalRepository extends JpaRepository<TipoFiscal, Integer>{

}
