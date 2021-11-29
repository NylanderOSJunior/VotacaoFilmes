package br.edu.unirv.rankers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.unirv.rankers.entity.UserVoto;
import br.edu.unirv.rankers.repository.UserVotoRepository;

@Service
public class UserVotoService {
	
	@Autowired
	private UserVotoRepository userVotoRepository;
	
	public List<UserVoto> findAll() {
		return userVotoRepository.findAll();
	}

	public Optional<UserVoto> deleteUserVoto(@PathVariable(value = "id") Long id) {
		Optional<UserVoto> userVoto = userVotoRepository.findById(id);
		return userVoto;
		
	}
	
	public void save(UserVoto userVoto) {
		userVotoRepository.save(userVoto);
		
	}
	
	public void deleteById(Long id) {
		userVotoRepository.deleteById(id);;
		
	}

	public Optional<UserVoto> findById(Long id) {
		Optional<UserVoto> userVoto = userVotoRepository.findById(id);
		return userVoto;
	}

	public Optional<UserVoto> update(@PathVariable(value = "id") long id, @RequestBody UserVoto novoUserVoto) {
		Optional<UserVoto> antigoUserVoto = userVotoRepository.findById(id);
		return antigoUserVoto;
	}
}
