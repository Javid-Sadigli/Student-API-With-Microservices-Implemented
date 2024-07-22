package com.example.student_api.mapper;

import org.springframework.stereotype.Service;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;

@Service
public class StudentMapper 
{
    public StudentDTO toStudentDTO(StudentEntity studentEntity)
    {
        try
        {
            return new StudentDTO(
                studentEntity.getId(),
                studentEntity.getName(),
                studentEntity.getGender(),
                studentEntity.getEmail(),
                studentEntity.getPassword()
            );
        }
        catch (NullPointerException e)
        {
            return null; 
        }
    }

    public StudentEntity toStudentEntity(StudentDTO studentDTO)
    {
        try
        {
            return new StudentEntity(
                studentDTO.getName(),
                studentDTO.getGender(),
                studentDTO.getEmail(),
                studentDTO.getPassword()
            );
        }
        catch (NullPointerException e)
        {
            return null;
        }
    }
    public StudentEntity toStudentEntity(StudentDTO studentDTO, Long studentId)
    {
        if(studentId == null)
        {
            return null; 
        }
        
        try
        {
            return new StudentEntity(
                studentId,
                studentDTO.getName(), 
                studentDTO.getGender(), 
                studentDTO.getEmail(), 
                studentDTO.getPassword()
            );
        }
        catch (NullPointerException e)
        {
            return null; 
        }
    }
}
