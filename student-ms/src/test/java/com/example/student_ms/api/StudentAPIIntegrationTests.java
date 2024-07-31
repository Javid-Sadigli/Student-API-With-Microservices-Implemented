package com.example.student_ms.api;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.student_ms.api.feignclient.StudentAPI;
import com.example.student_ms.api.models.StudentAPIModel;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@WireMockTest(httpPort = 8080)
@TestPropertySource(locations = "classpath:application-test.properties")
public class StudentAPIIntegrationTests 
{
    @Autowired
    private StudentAPI studentAPI; 

    @Test
    @DisplayName("Testing if StudentAPI can READ a student by id.")
    public void shouldGetStudentById(WireMockRuntimeInfo wireMockRuntimeInfo)
    {
        Long studentId = 1L; 
        String studentName = "Javid Sadigli", studentGender = "male", studentEmail = "cavid@gmail.com", studentPassword = "javid123";

        stubFor(get(urlEqualTo("/api/student/1")).willReturn(
            aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(
                String.format(
                    """
                        {
                            "id": %d,
                            "name": "%s",
                            "gender": "%s",
                            "email": "%s",
                            "password": "%s"
                        }     
                    """, 
                    studentId, studentName, studentGender, studentEmail, studentPassword
                )
            )
        ));

        StudentAPIModel checkStudentModel = this.studentAPI.getStudentById(studentId); 

        assertNotNull(checkStudentModel);
        assertEquals(studentId, checkStudentModel.getId());
        assertEquals(studentName, checkStudentModel.getName());
        assertEquals(studentGender, checkStudentModel.getGender());
        assertEquals(studentEmail, checkStudentModel.getEmail());
        assertEquals(studentPassword, checkStudentModel.getPassword());
    }
}
