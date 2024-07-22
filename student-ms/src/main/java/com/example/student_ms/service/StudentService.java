package com.example.student_ms.service;

import org.springframework.stereotype.Service;

import com.example.student_ms.api.entity.StudentAPIEntity;
import com.example.student_ms.api.feignclient.StudentAPI;
import com.example.student_ms.dto.StudentDTO;
import com.example.student_ms.mapper.StudentMapper;

@Service
public class StudentService 
{
    private final StudentAPI studentAPI;
    private final StudentMapper studentMapper; 
    
    public StudentService(StudentAPI studentAPI, StudentMapper studentMapper)
    {
        this.studentAPI = studentAPI;
        this.studentMapper = studentMapper;
    }

    public StudentDTO getStudentById(Long studentId)
    {
        StudentAPIEntity studentAPIEntity = this.studentAPI.getStudentById(studentId);
        return this.studentMapper.toStudentDTO(studentAPIEntity);
    }
    
    public StudentDTO saveStudent(StudentDTO student)
    {
        StudentAPIEntity studentAPIEntity = this.studentMapper.toStudentAPIEntity(student);
        StudentAPIEntity savedStudent = this.studentAPI.saveStudent(studentAPIEntity); 
        return this.studentMapper.toStudentDTO(savedStudent);
    }

    public StudentDTO saveStudent(StudentDTO student, Long id)
    {
        StudentAPIEntity studentAPIEntity = this.studentMapper.toStudentAPIEntity(student);
        StudentAPIEntity savedStudent = this.studentAPI.updateStudentById(id, studentAPIEntity); 
        return this.studentMapper.toStudentDTO(savedStudent);
    }

    public void deleteStudentById(Long studentId)
    {
        this.studentAPI.deleteStudentById(studentId);
    }

}
