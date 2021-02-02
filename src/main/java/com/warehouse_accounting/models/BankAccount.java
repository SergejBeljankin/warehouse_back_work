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

    @Column(name = "correspondentAccounts")
    private String correspondentAccount;

    @Column(name = "accounts")
    private String account;

    @Column(name = "mainAccounts")
    private Boolean mainAccount;

    @Column(name = "sortNumbers")
    private String sortNumber;

    public BankAccount(String rcbic, String bank, String address, String correspondentAccount, String account, Boolean mainAccount, String sortNumber) {
        this.rcbic = rcbic;
        this.bank = bank;
        this.address = address;
        this.correspondentAccount = correspondentAccount;
        this.account = account;
        this.mainAccount = mainAccount;
        this.sortNumber = sortNumber;
    }
}
