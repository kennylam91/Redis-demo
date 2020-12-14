package com.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.exam.dto.UserDto;
import com.exam.entity.UserEntity;
import com.exam.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);


	@CacheEvict(cacheNames = "user-getAll", allEntries = true)
	public UserDto save(UserEntity userEntity) {
		UserEntity saved = userRepository.save(userEntity);
		return saved.mapperToDto();
	}

	@Cacheable(cacheNames = "user-getAll")
	public List<UserDto> getAll() {
		List<UserEntity> entityList = (List<UserEntity>) userRepository.findAll();
		logger.info("get-all users");
		return entityList.stream().map(i -> i.mapperToDto())
				.collect(Collectors.toList());
	}

	@CacheEvict(cacheNames = "user-getAll", allEntries = true)
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
