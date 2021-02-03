package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "bank_accounts")
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rcbics")
    private String rcbic;

    @Column(name = "banks")
    private String bank;

    @Column(name = "addresses")
    private String address;

    @Column(name = "correspondent_accounts")
    private String correspondentAccount;

    @Column(name = "accounts")
    private String account;

    @Column(name = "main_accounts")
    private Boolean mainAccount;

    @Column(name = "sort_numbers")
    private String sortNumber;
}
