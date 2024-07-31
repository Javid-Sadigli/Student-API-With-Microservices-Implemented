package com.example.student_ms.service;

import org.springframework.stereotype.Service;

import com.example.student_ms.api.feignclient.StudentAPI;
import com.example.student_ms.api.models.StudentAPIModel;
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
        if(studentId == null) return null; 
        StudentAPIModel studentAPIModel = this.studentAPI.getStudentById(studentId);
        return this.studentMapper.toStudentDTO(studentAPIModel);
    }
    
    public StudentDTO saveStudent(StudentDTO student)
    {
        StudentAPIModel studentAPIModel = this.studentMapper.toStudentAPIModel(student);
        StudentAPIModel savedStudent = this.studentAPI.saveStudent(studentAPIModel); 
        return this.studentMapper.toStudentDTO(savedStudent);
    }

    public StudentDTO saveStudent(StudentDTO student, Long id)
    {
        if(id == null || student == null) return null; 
        StudentAPIModel studentAPIModel = this.studentMapper.toStudentAPIModel(student);
        StudentAPIModel savedStudent = this.studentAPI.updateStudentById(id, studentAPIModel); 
        return this.studentMapper.toStudentDTO(savedStudent);
    }

    public void deleteStudentById(Long studentId)
    {
        if(studentId == null) return;
        this.studentAPI.deleteStudentById(studentId);
    }

}
