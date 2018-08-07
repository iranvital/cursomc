package com.iranvital.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iranvital.cursomc.domain.Cliente;
import com.iranvital.cursomc.repositories.ClienteRepository;
import com.iranvital.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto nao encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
