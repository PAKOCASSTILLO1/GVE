package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
