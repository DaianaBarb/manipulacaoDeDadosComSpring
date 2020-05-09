package com.challenge.repository.interfaces;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import com.challenge.entity.User;
@Transactional
@Repository
public interface SubmissionRepositoryInterface extends JpaRepository<Submission,SubmissionId> {
	
	 @Query("SELECT DISTINCT MAX(s.score) FROM Submission s WHERE s.id.challenge.id = :challengeId")
	    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
	 
	 @Query("SELECT s FROM Submission s JOIN FETCH s.id.challenge c JOIN FETCH c.accelerations a WHERE a.id = :accelerationId AND c.id = :challengeId " )
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,@Param("accelerationId") Long accelerationId);
	 
	@Query("SELECT c.id.acceleration.challenge FROM Candidate c WHERE c.id.acceleration.id = :accelerationId AND c.id.user.id =:userId")
	    List<Challenge>RetornarChalengeUsuAndAcce(@Param("accelerationId") Long accelerationId,@Param("userId") Long userId);
}
