package com.example.student_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.student_ms.api.feignclient")
public class StudentMsApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(StudentMsApplication.class, args);
	}
}