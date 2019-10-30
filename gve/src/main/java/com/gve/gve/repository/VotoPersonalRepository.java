package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.VotoPersonal;

@Repository
public interface VotoPersonalRepository extends JpaRepository<VotoPersonal, Integer>{

}
