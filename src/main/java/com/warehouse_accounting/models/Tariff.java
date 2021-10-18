package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tariff")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tariffName;

    @Column
    private Integer usersCount;

    @Column
    private Integer dataSpace;

    @Column
    private Integer salePointCount;

    @Column
    private Integer onlineStoreCount;

    @Column
    private Integer paidApplicationOptionCount;

    @Column
    private Boolean isCRM;

    @Column
    private Boolean isScripts;

    @Column
    private Boolean extendedBonusProgram;

    @Column
    private Integer paymentPeriod;

    @Column
    private Integer totalPrice;

    @Column
    private Date dateStartSubscription;

    @Column
    private Date dateEndSubscription;

}
