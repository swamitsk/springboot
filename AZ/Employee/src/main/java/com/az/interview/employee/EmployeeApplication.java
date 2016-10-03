package com.az.interview.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.az.interview.employee.domain.Employee;
import com.az.interview.employee.domain.EmployeeRepository;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}
}
