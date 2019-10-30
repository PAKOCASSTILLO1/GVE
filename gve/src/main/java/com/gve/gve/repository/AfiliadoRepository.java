package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.Afiliado;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer>{

}
