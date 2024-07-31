package com.example.student_ms.api.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.student_ms.api.models.StudentAPIModel;

@FeignClient(name = "adp-student-client", url = "${feign.client.url}")
public interface StudentAPI 
{
    @GetMapping("/{id}") public StudentAPIModel getStudentById(@PathVariable("id") Long id); 
    @PostMapping("/") public StudentAPIModel saveStudent(@RequestBody StudentAPIModel student); 
    @PutMapping("/{id}") public StudentAPIModel updateStudentById(@PathVariable("id") Long id, @RequestBody StudentAPIModel newStudent);
    @DeleteMapping("/{id}") public void deleteStudentById(@PathVariable("id") Long id);
}
