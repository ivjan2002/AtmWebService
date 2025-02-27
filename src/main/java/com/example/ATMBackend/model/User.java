package com.example.ATMBackend.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    @JsonProperty("id")
    private int id;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("adress")
    private String adress;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
