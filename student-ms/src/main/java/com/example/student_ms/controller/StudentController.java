package com.example.student_ms.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_ms.dto.StudentDTO;
import com.example.student_ms.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController 
{
    private final StudentService studentService; 

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService; 
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id)
    {
        return this.studentService.getStudentById(id); 
    }

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO student)
    {
        return this.studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudentById(@PathVariable Long id, @RequestBody StudentDTO newStudent)
    {
        return this.studentService.saveStudent(newStudent, id); 
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) 
    {
        this.studentService.deleteStudentById(id);
    }
}
