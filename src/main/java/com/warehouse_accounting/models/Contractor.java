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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contractors")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String sortNumber;

    @Column
    private String phone;

    @Column
    private String fax;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String commentToAddress;

    @Column
    private String comment;

    @Column
    private String numberDiscountCard;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContractorGroup contractorGroup;

    @OneToOne(fetch = FetchType.LAZY)
    private TypeOfPrice typeOfPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private List<BankAccount> bankAccounts;

    @OneToOne(fetch = FetchType.LAZY)
    private LegalDetail legalDetail;
}
