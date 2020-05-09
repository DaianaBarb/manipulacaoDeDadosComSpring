package com.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.entity.Company;
import com.challenge.repository.interfaces.AccelerationRepositoryInterface;
import com.challenge.repository.interfaces.CandidateRepositoryInterface;
import com.challenge.repository.interfaces.CompanyRepositoryInterface;
import com.challenge.repository.interfaces.UserRepositoryInterface;
import com.challenge.service.interfaces.CandidateServiceInterface;
@Service
public class CandidateService implements CandidateServiceInterface {
	
	@Autowired
	private CandidateRepositoryInterface repository;
	@Autowired
	private AccelerationRepositoryInterface repositoryAceleration;
	@Autowired
	private CompanyRepositoryInterface repositoryCompany;
	@Autowired
	private CandidateRepositoryInterface repositoryCandidates;
	

	@Override
	public Candidate save(Candidate object) {
		return repository.saveAndFlush(object);
	
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		
        Optional<Candidate> optional = repository.findById(id);
		return optional;
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		
		//com a id do usuario achar o candidato
		Optional<Candidate> optional= repositoryCandidates.RetornaCandidato(userId, companyId, accelerationId);
	    return optional;
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		
		return repositoryCandidates.RetornarCanditatesCompany(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		
		//buscar candidatos de uma aceleração
		
		return repositoryCandidates.RetornarCanditatesAccelerations(accelerationId);
	}

}
