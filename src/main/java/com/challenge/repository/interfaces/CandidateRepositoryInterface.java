package com.challenge.repository.interfaces;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;
import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
@Transactional
@Repository
public interface CandidateRepositoryInterface extends JpaRepository<Candidate,CandidateId>{
	
	
	@Query("SELECT DISTINCT c.id.user FROM Candidate c WHERE c.id.acceleration.name  =:nome")
	   List<User> RetornaUsuariosAccelerations( @Param("nome")String nome);
	@Query("SELECT DISTINCT  c.id.user FROM Candidate c WHERE c.id.company.id =:companyId")
	List<User>RetornarUsuariosCompany(@Param("companyId")Long id);
	
	@Query("SELECT DISTINCT  c.id.company FROM Candidate c WHERE c.id.acceleration.id  =:acceleration")
	List<User>RetornarCompany(@Param("acceleration")Long id);
	
	@Query("SELECT DISTINCT c FROM Candidate c WHERE c.id.user.id =:userId AND c.id.company=:companyId AND c.id.acceleration =:accelerationId")
    Optional<Candidate> RetornaCandidato( @Param("userId")Long userId, @Param("companyId")Long companyId, @Param("accelerationId")Long accelerationId);

	@Query("SELECT DISTINCT  c FROM Candidate c WHERE c.id.company.id =:companyId")
	List<Candidate>RetornarCanditatesCompany(@Param("companyId")Long id);
	
	@Query("SELECT DISTINCT  c FROM Candidate c WHERE c.id.acceleration.id =:accelerationId")
	List<Candidate>RetornarCanditatesAccelerations(@Param("accelerationId")Long id);
	
	@Query("SELECT   c.id.acceleration FROM Candidate c WHERE c.id.company.id =:companyId")
	List<Acceleration>RetornarAccelerationsCompany(@Param("companyId")Long id);
}

