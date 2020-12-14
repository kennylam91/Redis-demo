package com.exam.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 30825810505040752L;

	private Long id;

	private String fullName;
}
