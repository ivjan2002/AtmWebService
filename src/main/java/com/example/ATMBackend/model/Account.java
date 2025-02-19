package com.example.ATMBackend.model;

import com.example.ATMBackend.ENUM.AccountType;
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
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="account_id")
    @JsonProperty("id")
    private int id;

    @JsonProperty("balance")
    private double balance;

    @JsonProperty("accountOpeningDate")
    private Date accountOpeningDate;

    @Enumerated(EnumType.STRING)
    @JsonProperty("accountType")
    private AccountType accountType;

}
