package com.gve.gve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gve.gve.model.DistritoElectoralCems;

@Repository
public interface DistritoElectoralCemsRepository extends JpaRepository<DistritoElectoralCems, Integer>{

}
