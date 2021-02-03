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

    @Column(name = "rcbic")
    private String rcbic;

    @Column(name = "bank")
    private String bank;

    @Column(name = "address")
    private String address;

    @Column(name = "correspondent_account")
    private String correspondentAccount;

    @Column(name = "account")
    private String account;

    @Column(name = "main_account")
    private Boolean mainAccount;

    @Column(name = "sort_number")
    private String sortNumber;
}
