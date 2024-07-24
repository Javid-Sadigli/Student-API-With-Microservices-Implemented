package com.example.student_ms.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.student_ms.api.entity.StudentAPIEntity;
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
        StudentAPIEntity studentEntity = new StudentAPIEntity(studentId, studentName, studentGender);

        StudentDTO studentDTO = this.studentMapper.toStudentDTO(studentEntity); 

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
        
        StudentAPIEntity studentEntity = this.studentMapper.toStudentAPIEntity(studentDTO);

        assertNotNull(studentEntity);
        assertEquals(studentName, studentEntity.getName());
        assertEquals(studentGender, studentEntity.getGender());
        assertEquals(studentId, studentEntity.getId());
    }

    @Test
    @DisplayName("Testing if studentMapper is converting null studentEntity to null studentDTO")
    public void shouldConvertNullStudentEntityToNullStudentDTO()
    {
        StudentAPIEntity studentEntity = null;
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(studentEntity);
        assertNull(studentDTO);
    }

    @Test
    @DisplayName("Testing if studentMapper is converting null studentDTO to null studentEntity")
    public void shouldConvertNullStudentDTOToNullStudentEntity()
    {
        StudentDTO studentDTO = null;
        StudentAPIEntity studentEntity = this.studentMapper.toStudentAPIEntity(studentDTO);
        assertNull(studentEntity);
    }
}
