package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.gve.gve.model.VotoOrganizacion;

@Repository
public interface VotoOrganizacionRepository extends JpaRepository<VotoOrganizacion, Integer>{

    List<VotoOrganizacion> findByOrganizacionPolitica(int id);
}
