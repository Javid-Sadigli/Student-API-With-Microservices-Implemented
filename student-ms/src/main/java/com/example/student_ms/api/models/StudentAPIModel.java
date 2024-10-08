package com.example.student_ms.api.models;

public class StudentAPIModel 
{
    private Long id;
    private String name;
    private String gender; 
    private String email; 
    private String password; 


    public StudentAPIModel() {}

    public StudentAPIModel(Long id, String name, String gender, String email, String password) 
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public StudentAPIModel(String name, String gender, String email, String password) 
    {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public StudentAPIModel(Long id, String name, String gender) 
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public StudentAPIModel(String name, String gender) 
    {
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", gender='" + getGender() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    
}
