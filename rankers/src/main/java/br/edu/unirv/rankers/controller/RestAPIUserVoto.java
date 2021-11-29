package br.edu.unirv.rankers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unirv.rankers.entity.UserVoto;
import br.edu.unirv.rankers.service.UserVotoService;

@RestController
@RequestMapping("/api") 
public class RestAPIUserVoto {
	@Autowired
	private UserVotoService userVotoService;
	
	//Mostra todos os UserVoto
		@GetMapping("/uservoto")
		public List<UserVoto> getAll() {
			return userVotoService.findAll();
		}
		
		// Adcionar o UserVoto
		@PostMapping("/uservoto")
		public void addUserVoto(@RequestBody UserVoto novoUserVoto) {
			userVotoService.save(novoUserVoto);
		}
		
		// Deletar UserVoto
		@DeleteMapping("/uservoto/{id}")
		public ResponseEntity<Object> deleteUserVoto(@PathVariable(value = "id") Long id) {
			Optional<UserVoto> userVoto = userVotoService.findById(id);
			if (userVoto.isPresent()) {
				userVotoService.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		}
		// Mostrar o UserVoto
			@GetMapping("/uservoto/{id}")
			public ResponseEntity<UserVoto> getUserVoto(@PathVariable(value = "id") Long id) {
				Optional<UserVoto> userVoto = userVotoService.findById(id);
				if (userVoto.isPresent()) {
					return new ResponseEntity<UserVoto>(userVoto.get(), HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
		
		// atualizar UserVoto
			@PutMapping("/uservoto")
			public UserVoto update(@RequestBody UserVoto novoUserVoto) {
				return novoUserVoto;
			}
}
