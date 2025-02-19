package com.example.ATMBackend.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name="transaction_id")
    private int id;

    @JsonProperty("transactionName")
    private String transactionName;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("description")
    private String description;

    @JsonProperty("dateOfTransaction")
    private Timestamp dateOfTransaction;
}
