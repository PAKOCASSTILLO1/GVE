package com.gve.gve.repository;

import com.gve.gve.model.Voto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * VotoRepository
 */
@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer>{

    
}