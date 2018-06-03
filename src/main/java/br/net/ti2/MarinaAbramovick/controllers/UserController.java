package br.net.ti2.MarinaAbramovick.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.net.ti2.MarinaAbramovick.models.User;
import br.net.ti2.MarinaAbramovick.repositories.UserRepository;

@Controller
@RequestMapping(path="/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	//@PostMapping(path = "admin/students")
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> save(@Valid @RequestBody User user) {
		return new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
	}
	

	@GetMapping
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
