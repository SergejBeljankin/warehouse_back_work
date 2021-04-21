package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime date;

    @Column
    private BigDecimal amount;

    @Column
    private String purpose;

    @Column
    private BigDecimal tax;

    @Column
    private String comment;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfPayment typeOfPayment;

    @OneToMany(mappedBy = "payment",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> tasks;

    @ManyToMany(mappedBy = "payments")
    private List<Document> documents;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Expenditure expenditure;
}