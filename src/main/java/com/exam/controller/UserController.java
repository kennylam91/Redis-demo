package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.UserService;
import com.exam.dto.UserDto;
import com.exam.entity.UserEntity;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/get-all")
	public ResponseEntity<List<UserDto>> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	@PostMapping
	public ResponseEntity<UserDto> save(@RequestBody UserEntity entity) {
		return ResponseEntity.ok(userService.save(entity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}
}
