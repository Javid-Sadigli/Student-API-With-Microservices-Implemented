package com.example.student_ms.mapper;

import org.springframework.stereotype.Service;

import com.example.student_ms.api.models.StudentAPIModel;
import com.example.student_ms.dto.StudentDTO;

@Service
public class StudentMapper 
{
    public StudentDTO toStudentDTO(StudentAPIModel studentAPIModel)
    {
        try
        {
            return new StudentDTO(
                studentAPIModel.getId(),
                studentAPIModel.getName(),
                studentAPIModel.getGender()
            );
        }
        catch(NullPointerException e)
        {
            return null;
        }
    }

    public StudentAPIModel toStudentAPIModel(StudentDTO studentDTO)
    {
        try
        {
            return new StudentAPIModel(
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
