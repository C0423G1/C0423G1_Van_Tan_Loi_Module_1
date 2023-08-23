package com.example.validateform.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.validation.Errors;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = " Họ không được để trống")
    @Pattern(regexp = "^[A-Z][A-Za-z]{1,40}$",message = "Họ không hợp lệ ")
    private String firstname;
    @NotEmpty(message = " Tên đệm và tên không được để trống")
    @Pattern(regexp = "^[A-Z][A-Za-z]{1,40}$",message = "Tên đệm và tên không hợp lệ ")
    private String lastname ;
    @NotEmpty(message = " Số điện thoại không được để trống")
    @Pattern(regexp = "^(07[2-9]|07[06-9]|08[1-9]|09[0-9]|01[2-9])[0-9]{7}$",message = "Số điện thoại không hợp lệ ")
    private String numberPhone;

    @Min(value = 18,message = "Không được dưới 18 tuổi")
    private int age ;
    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email Không Hợp Lệ")
    private String email;

    public User(int id, String firstname, String lastname, String numberPhone, int age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
