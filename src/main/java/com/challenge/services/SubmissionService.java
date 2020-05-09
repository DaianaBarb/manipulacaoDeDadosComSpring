package com.challenge.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.interfaces.SubmissionRepositoryInterface;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface {
	@Autowired
	private SubmissionRepositoryInterface repository;
	@Autowired
	private SubmissionRepositoryInterface repositorySubmission;

	@Override
	public Submission save(Submission object) {
		
		return repository.save(object);
		
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		
		// Buscar o maior score de um determinado desafio
		if(repositorySubmission.findHigherScoreByChallengeId(challengeId)==null) {
			return BigDecimal.ZERO;
		}
			
		return repositorySubmission.findHigherScoreByChallengeId(challengeId);
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		
		//buscar submissões de um determinado desafio de uma determinada aceleração
		
		return repositorySubmission.findByChallengeIdAndAccelerationId(challengeId, accelerationId) ;
	}

}
