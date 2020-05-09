
package com.challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.repository.interfaces.AccelerationRepositoryInterface;
import com.challenge.repository.interfaces.CompanyRepositoryInterface;
import com.challenge.repository.interfaces.UserRepositoryInterface;
import com.challenge.service.interfaces.CompanyServiceInterface;
@Service
public class CompanyService implements CompanyServiceInterface {
	
	@Autowired
	private CompanyRepositoryInterface repository;
	@Autowired
	private UserRepositoryInterface repositoryUsu;
	@Autowired
	private AccelerationRepositoryInterface repositoryAcceleration;
	@Override
	public Company save(Company object) {
		
		return repository.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		
		Optional<Company> optional= repository.findById(id);
		return optional;
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		
	//buscar empresas de uma aceleração
		
		return repository.RetornarCompanyAcceleration(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		
		return repository.RetornarCompanyUser(userId);
	}

}
