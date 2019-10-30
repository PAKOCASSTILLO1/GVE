package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.TipoOrganizacion;

@Repository
public interface TipoOrganizacionRepository extends JpaRepository<TipoOrganizacion, Integer>{

}
