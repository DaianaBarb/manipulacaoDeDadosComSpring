package com.challenge.repository.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;
import com.challenge.entity.Challenge;
import com.challenge.entity.Company;
import com.challenge.entity.Submission;
@Transactional
@Repository
public interface  CompanyRepositoryInterface extends JpaRepository<Company,Long> {
	
	 @Query("SELECT DISTINCT c.id.company FROM Candidate c  WHERE c.id.acceleration.id =:accelerationId " )
	    List<Company> RetornarCompanyAcceleration(@Param("accelerationId") Long accelerationId);
	 
	 @Query("SELECT DISTINCT c.id.company FROM Candidate c  WHERE c.id.user.id = :userId" )
	    List<Company> RetornarCompanyUser(@Param("userId") Long userId);
	 
	 
	 

}
