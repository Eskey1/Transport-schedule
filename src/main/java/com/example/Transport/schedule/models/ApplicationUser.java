package com.example.Transport.schedule.models;

//import jakarta.persistence.*;
//
//@Entity // This tells Hibernate to make a table out of this class
//public class User {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;
//
//    private String name;
//
//    private String email;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationUser {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;


    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name ="role")
    private ApplicationUserRole role;

}