package com.example.student_ms.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@WireMockTest(httpPort = 8080)
public class StudentAPIIntegrationTests 
{
    @Test
    @DisplayName("Testing if StudentAPI can GET a student by id.")
    public void shouldGetStudentById(WireMockRuntimeInfo wireMockRuntimeInfo)
    {

    }

}
