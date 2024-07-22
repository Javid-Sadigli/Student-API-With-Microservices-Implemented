package com.example.student_api.service;

import org.springframework.stereotype.Service;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;
import com.example.student_api.mapper.StudentMapper;
import com.example.student_api.repository.StudentRepository;

@Service
public class StudentService 
{
    private final StudentRepository studentRepository; 
    private final StudentMapper studentMapper; 

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) 
    {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDTO findStudentById(Long id)
    {
        if (id == null) return null;     
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        return this.studentMapper.toStudentDTO(studentEntity);
    }

    public StudentDTO saveStudent(StudentDTO studentDTO)
    {
        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO);
        StudentEntity saved = studentRepository.save(studentEntity);
        return this.studentMapper.toStudentDTO(saved);
    }
    
    public StudentDTO saveStudent(StudentDTO studentDTO, Long studentId)
    {
        if (studentId == null) return null;
        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO, studentId);
        StudentEntity saved = studentRepository.save(studentEntity);
        return this.studentMapper.toStudentDTO(saved);
    }

    public void deleteStudentById(Long id)
    {
        studentRepository.deleteById(id);
    }
}
