package com.example.student_ms.dto;

public class StudentDTO 
{
    private Long id;
    private String name;
    private String gender; 


    public StudentDTO() {}

    public StudentDTO(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public StudentDTO(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", gender='" + getGender() + "'" +
            "}";
    }

}
