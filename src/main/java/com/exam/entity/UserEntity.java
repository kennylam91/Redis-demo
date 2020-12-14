package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.exam.dto.UserDto;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fullName;

	public UserDto mapperToDto() {
		return new UserDto(id, fullName);
	}
}
