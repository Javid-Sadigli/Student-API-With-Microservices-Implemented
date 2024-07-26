package com.example.student_ms.api.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.student_ms.api.entity.StudentAPIEntity;

@FeignClient(name = "adp-student-client", url = "${feign.client.url}")
public interface StudentAPI 
{
    @GetMapping("/{id}") public StudentAPIEntity getStudentById(@PathVariable("id") Long id); 
    @PostMapping("/") public StudentAPIEntity saveStudent(@RequestBody StudentAPIEntity student); 
    @PutMapping("/{id}") public StudentAPIEntity updateStudentById(@PathVariable("id") Long id, @RequestBody StudentAPIEntity newStudent);
    @DeleteMapping("/{id}") public void deleteStudentById(@PathVariable("id") Long id);
}
