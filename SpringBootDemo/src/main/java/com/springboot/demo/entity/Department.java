package com.springboot.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptId;
	@NotBlank(message="Please add department Name")
	private String deptName;	
	private String deptAddress;
	private String deptCode;
	
	
	
}
