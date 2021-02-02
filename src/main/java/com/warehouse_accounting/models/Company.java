package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String inn;

    @Column
    private String sortNumber;

    @Column
    private String phone;

    @Column
    private String fax;

    @Column
    private String email;

    @Column
    private Boolean payerVat;

    @Column
    private String address;

    @Column
    private String commentToAddress;

    @Column
    private String leader;

    @Column
    private String leaderManagerPosition;

    @Column
    private String leaderSignature;

    @Column
    private String chiefAccountant;

    @Column
    private String chiefAccountantSignature;

    @Column
    private String stamp;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "legal_detail_id")
//    private LegalDetail legalDetail;
//    (OneToOne, LAZY) дождаться залития в dev
}
