package com.challenge.services;

import java.time.LocalDateTime;
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
import com.challenge.repository.interfaces.CandidateRepositoryInterface;
import com.challenge.repository.interfaces.CompanyRepositoryInterface;
import com.challenge.repository.interfaces.UserRepositoryInterface;
import com.challenge.service.interfaces.UserServiceInterface;
@Service
public class UserService implements UserServiceInterface {
	@Autowired
	private UserRepositoryInterface repository;
	@Autowired
	private AccelerationRepositoryInterface repositoryAceleration;
	@Autowired
	private UserRepositoryInterface repositoryUser;
	@Autowired
	private CandidateRepositoryInterface repositoryCandidate;

	@Override
	public User save(User object) {
		
		object.setCreatedAt(LocalDateTime.now());
		return repository.save(object);
		
	}

	@Override
	public Optional<User> findById(Long userId) {
	
	  Optional<User> optional= repository.findById(userId);
	  return optional;
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		
		return repositoryCandidate.RetornaUsuariosAccelerations(name);
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		
		//buscar usuários relacionados com uma empresa.

		return repositoryCandidate.RetornarUsuariosCompany(companyId);
	}
	

}
