package com.example.student_ms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.student_ms.api.feignclient.StudentAPI;
import com.example.student_ms.api.models.StudentAPIModel;
import com.example.student_ms.dto.StudentDTO;
import com.example.student_ms.mapper.StudentMapper;

public class StudentServiceTests 
{
    @Mock
    private StudentMapper studentMapper;   
    
    @Mock 
    private StudentAPI studentAPI; 

    @InjectMocks 
    private StudentService studentService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testing if studentService is finding student by id.")
    public void shouldFindStudentById()
    {
        Long studentId = 1L; 
        String studentName = "Javid Sadigli", studentGender = "male"; 

        StudentAPIModel studentAPIModel = new StudentAPIModel(studentId, studentName, studentGender);
        StudentDTO studentDTO = new StudentDTO(studentId, studentName, studentGender);

        when(this.studentAPI.getStudentById(studentId)).thenReturn(studentAPIModel); 
        when(this.studentMapper.toStudentDTO(studentAPIModel)).thenReturn(studentDTO); 

        StudentDTO checkFoundStudentDTO = this.studentService.getStudentById(studentId); 
        
        assertNotNull(checkFoundStudentDTO);
        assertEquals(studentId, checkFoundStudentDTO.getId());
        assertEquals(studentName, checkFoundStudentDTO.getName());
        assertEquals(studentGender, checkFoundStudentDTO.getGender());
    }

    @Test
    @DisplayName("Testing if studentService is saving student.")
    public void shouldSaveStudent()
    {
        Long studentId = 1L; 
        String studentName = "Javid Sadigli", studentGender = "male"; 

        StudentAPIModel studentAPIModel = new StudentAPIModel(studentName, studentGender);
        StudentAPIModel savedstudentAPIModel = new StudentAPIModel(studentId, studentName, studentGender);
        StudentDTO studentDTO = new StudentDTO(studentName, studentGender);
        StudentDTO savedStudentDTO = new StudentDTO(studentId, studentName, studentGender);

        when(this.studentMapper.toStudentAPIModel(studentDTO)).thenReturn(studentAPIModel); 
        when(this.studentAPI.saveStudent(studentAPIModel)).thenReturn(savedstudentAPIModel);
        when(this.studentMapper.toStudentDTO(savedstudentAPIModel)).thenReturn(savedStudentDTO);

        StudentDTO checkStudentDTO = this.studentService.saveStudent(studentDTO);
        
        assertNotNull(checkStudentDTO);
        assertEquals(studentId, checkStudentDTO.getId());
        assertEquals(studentName, checkStudentDTO.getName());
        assertEquals(studentGender, checkStudentDTO.getGender());
    }

    @Test
    @DisplayName("Testing id studentService is updating student by id.")
    public void shouldUpdateStudentById()
    {
        Long studentId = 1L; 
        String studentName = "Javid Sadigli", studentGender = "male"; 

        StudentDTO studentDTO = new StudentDTO(studentName, studentGender);
        StudentAPIModel studentAPIModel = new StudentAPIModel(studentName, studentGender);
        StudentAPIModel savedstudentAPIModel = new StudentAPIModel(studentId, studentName, studentGender);
        StudentDTO savedStudentDTO = new StudentDTO(studentId, studentName, studentGender); 

        when(this.studentMapper.toStudentAPIModel(studentDTO)).thenReturn(studentAPIModel); 
        when(this.studentAPI.updateStudentById(studentId, studentAPIModel)).thenReturn(savedstudentAPIModel); 
        when(this.studentMapper.toStudentDTO(savedstudentAPIModel)).thenReturn(savedStudentDTO); 

        StudentDTO checkStudentDTO = this.studentService.saveStudent(studentDTO, studentId); 

        assertNotNull(checkStudentDTO);
        assertEquals(studentId, checkStudentDTO.getId());
        assertEquals(studentName, checkStudentDTO.getName());
        assertEquals(studentGender, checkStudentDTO.getGender());
    }

    @Test 
    @DisplayName("Testing if studentService is finding student by null id.")
    public void shouldReturnNullWhenStudentIdIsNull()
    {
        Long studentId = null; 
        StudentDTO checkStudentDTO = this.studentService.getStudentById(studentId); 
        assertNull(checkStudentDTO);
    }

    @Test
    @DisplayName("Testing if studentService is updating student by null id.")
    public void shouldReturnNull_WhenStudentIdIsNull()
    {
        Long studentId = null; 
        StudentDTO studentDTO = new StudentDTO(); 
        StudentDTO checkStudentDTO = this.studentService.saveStudent(studentDTO, studentId); 
        assertNull(checkStudentDTO);
    }

    @Test
    @DisplayName("Testing if studentService is updating student with null StudentDTO")
    public void shouldReturnNullWhenStudentDTOIsNull()
    {
        Long studentId = 1L; 
        StudentDTO studentDTO = null; 
        StudentDTO checkStudentDTO = this.studentService.saveStudent(studentDTO, studentId); 
        assertNull(checkStudentDTO);
    }
}
