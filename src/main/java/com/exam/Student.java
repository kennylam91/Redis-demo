package com.exam;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@RedisHash("Student")
@Data
public class Student implements Serializable{

	public enum Gender{
		MALE, FEMALE, OTHER
	}
	
	private String id;
	private String name;
	private Gender gender;
	

}
