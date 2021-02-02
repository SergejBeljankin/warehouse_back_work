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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "legal_details")
public class LegalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String address;

    @Column
    private String commentToAddress;

    @Column(unique = true)
    private String inn;

    @Column
    private String okpo;

    @Column
    private String ogrnip;

    @Column
    private String numberOfTheCertificate;

    @Column
    private LocalDate dateOfTheCertificate;

    @ManyToOne(fetch = FetchType.LAZY)
    private TypeOfContractor typeOfContractor;
}
