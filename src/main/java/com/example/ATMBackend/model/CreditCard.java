package com.example.ATMBackend.model;


import com.example.ATMBackend.ENUM.Status;
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
public class CreditCard {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="creditcard_id")
    @JsonProperty("id")
    private int id;

    @JsonProperty("pin")
    private String pin;

    @JsonProperty("expirationDate")
    private Date expirationDate;

    @JsonProperty("creditLimit")
    private Double creditLimit;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="account_id",nullable=false)
    private Account account;
}
