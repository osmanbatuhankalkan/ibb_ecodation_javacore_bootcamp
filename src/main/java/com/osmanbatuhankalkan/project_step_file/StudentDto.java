package com.osmanbatuhankalkan.project_step_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


// LOMBOK
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class StudentDto implements Serializable {
    private static final long serialVersionUID = 1110983899026254924L;

    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Date createdDate;
    private Double grade;//Başarı puanı

    //Static Nesenemiz boyunca 1 kere oluşturulur.
    static{

    }
    //Parametresşz Constructor
    public StudentDto() {

    }
    public StudentDto(Integer id, String name, String surname, LocalDate birthDate, Double grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.grade = grade;
    }
    //metotlar

    //getter-setter
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
    public Date getCreatedDate(){
        return createdDate;
    }
    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }
    public Double getGrade(){
        return grade;
    }
    public void setGrade(Double grade){
        this.grade = grade;
    }

}
