package com.challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.entity.User;
import com.challenge.repository.interfaces.AccelerationRepositoryInterface;
import com.challenge.repository.interfaces.CandidateRepositoryInterface;
import com.challenge.repository.interfaces.ChallengeRepositoryInterface;
import com.challenge.repository.interfaces.SubmissionRepositoryInterface;
import com.challenge.repository.interfaces.UserRepositoryInterface;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@Service
public class ChallengeService implements ChallengeServiceInterface {
	@Autowired
	private ChallengeRepositoryInterface repository;

	@Autowired
	private SubmissionRepositoryInterface repositorySubmission;

	@Override
	public Challenge save(Challenge object) {
		
		return repository.saveAndFlush(object);
		
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		
		//buscar desafios feitos por um usuario em determinada aceleração
	 	return repositorySubmission.RetornarChalengeUsuAndAcce(accelerationId, userId);
	}
	

}
