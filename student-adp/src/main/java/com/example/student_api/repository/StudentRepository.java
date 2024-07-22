package com.example.student_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_api.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository <StudentEntity, Long> {}
