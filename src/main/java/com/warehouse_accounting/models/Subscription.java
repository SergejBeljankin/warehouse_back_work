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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date subscriptionExpirationDate;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Tariff> tariffs;

    @ManyToOne(fetch = FetchType.LAZY)
    private Requisites requisites;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

//    @Column
//    private OperationHistory operationHistory; TODO <make a model with history an operation>
}
