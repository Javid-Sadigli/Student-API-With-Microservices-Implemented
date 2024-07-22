package com.example.student_ms.mapper;

import org.springframework.stereotype.Service;

import com.example.student_ms.api.entity.StudentAPIEntity;
import com.example.student_ms.dto.StudentDTO;

@Service
public class StudentMapper 
{
    public StudentDTO toStudentDTO(StudentAPIEntity studentAPIEntity)
    {
        try
        {
            return new StudentDTO(
                studentAPIEntity.getId(),
                studentAPIEntity.getName(),
                studentAPIEntity.getGender()
            );
        }
        catch(NullPointerException e)
        {
            return null;
        }
    }

    public StudentAPIEntity toStudentAPIEntity(StudentDTO studentDTO)
    {
        try
        {
            return new StudentAPIEntity(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getGender()
            );
        }
        catch(NullPointerException e)
        {
            return null;
        }
    }
}
