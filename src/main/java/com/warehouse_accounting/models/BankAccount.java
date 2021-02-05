package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String rcbic;

    @Column
    private String bank;

    @Column
    private String address;

    @Column
    private String correspondentAccount;

    @Column
    private String account;

    @Column
    private Boolean mainAccount;

    @Column
    private String sortNumber;
}
