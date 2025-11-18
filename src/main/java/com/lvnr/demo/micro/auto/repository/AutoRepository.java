package com.lvnr.demo.micro.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvnr.demo.micro.auto.entity.AutoEntity;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Integer> {

	AutoEntity findByMatricula(String matricula);

	boolean existsByMatricula(String matricula);
	
	AutoEntity deleteByMatricula(String matricula);	

}
