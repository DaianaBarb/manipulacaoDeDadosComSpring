package com.challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Company;
import com.challenge.repository.interfaces.AccelerationRepositoryInterface;
import com.challenge.repository.interfaces.CandidateRepositoryInterface;
import com.challenge.repository.interfaces.CompanyRepositoryInterface;
import com.challenge.service.interfaces.AccelerationServiceInterface;
@Service
public class AccelerationService implements AccelerationServiceInterface {
	
	@Autowired
	private AccelerationRepositoryInterface repository;
	
	@Autowired
	private CandidateRepositoryInterface repositoryCanditate;

	@Override
	public Acceleration save(Acceleration object) {
		return repository.save(object);
		
		}

	@Override
	public Optional<Acceleration> findById(Long id) {
	    Optional<Acceleration> optional = repository.findById(id);
		return optional;
	}

	@Override
	public List<Acceleration> findByCompanyId(Long companyId) {
		//buscar acelerações vinculadas a uma empresa
		return repositoryCanditate.RetornarAccelerationsCompany(companyId);
	}

}
