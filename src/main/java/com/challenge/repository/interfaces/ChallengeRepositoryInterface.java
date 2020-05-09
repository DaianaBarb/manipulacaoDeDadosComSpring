package com.challenge.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;
@Repository
public interface ChallengeRepositoryInterface extends JpaRepository<Challenge,Long>{
	
	
	
}
