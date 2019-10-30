package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.OrganizacionPolitica;

@Repository
public interface OrganizacionPoliticaRepository extends JpaRepository<OrganizacionPolitica, Integer>{

}
