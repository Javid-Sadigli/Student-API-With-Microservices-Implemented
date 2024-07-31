package com.example.student_ms.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.student_ms.api.models.StudentAPIModel;
import com.example.student_ms.dto.StudentDTO;

public class StudentMapperTests 
{
    private StudentMapper studentMapper; 

    @BeforeEach
    public void setUp()
    {
        this.studentMapper = new StudentMapper();
    }

    @Test
    @DisplayName("Testing if studentMapper is converting studentEntity to studentDTO")
    public void shouldConvertStudentEntityToStudentDTO()
    {
        String studentName = "Javid Sadigli", studentGender = "male"; 
        Long studentId = 1L; 
        StudentAPIModel studentAPIModel = new StudentAPIModel(studentId, studentName, studentGender);

        StudentDTO studentDTO = this.studentMapper.toStudentDTO(studentAPIModel); 

        assertNotNull(studentDTO);
        assertEquals(studentName, studentDTO.getName());
        assertEquals(studentGender, studentDTO.getGender());
        assertEquals(studentId, studentDTO.getId());
    }

    @Test
    @DisplayName("Testing if studentMapper is converting studentDTO to studentEntity")
    public void shouldConvertStudentDTOToStudentEntity()
    {
        String studentName = "Javid Sadigli", studentGender = "male"; 
        Long studentId = 1L; 

        StudentDTO studentDTO = new StudentDTO(studentId, studentName, studentGender);
        
        StudentAPIModel studentAPIModel = this.studentMapper.toStudentAPIModel(studentDTO);

        assertNotNull(studentAPIModel);
        assertEquals(studentName, studentAPIModel.getName());
        assertEquals(studentGender, studentAPIModel.getGender());
        assertEquals(studentId, studentAPIModel.getId());
    }

    @Test
    @DisplayName("Testing if studentMapper is converting null studentEntity to null studentDTO")
    public void shouldConvertNullStudentEntityToNullStudentDTO()
    {
        StudentAPIModel studentAPIModel = null;
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(studentAPIModel);
        assertNull(studentDTO);
    }

    @Test
    @DisplayName("Testing if studentMapper is converting null studentDTO to null studentEntity")
    public void shouldConvertNullStudentDTOToNullStudentEntity()
    {
        StudentDTO studentDTO = null;
        StudentAPIModel studentAPIModel = this.studentMapper.toStudentAPIModel(studentDTO);
        assertNull(studentAPIModel);
    }
}
