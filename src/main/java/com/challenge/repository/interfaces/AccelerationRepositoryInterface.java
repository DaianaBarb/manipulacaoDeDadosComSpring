package com.challenge.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;


@Repository
public interface AccelerationRepositoryInterface extends JpaRepository<Acceleration,Long>{
	
}
