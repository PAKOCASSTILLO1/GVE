package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.Padron;

@Repository
public interface PadronRepository extends JpaRepository<Padron, Integer>{

}
