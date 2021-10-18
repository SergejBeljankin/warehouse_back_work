package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

/*
Универсальная модель для приемки и отгрузки
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = PRIVATE)
@Embeddable
public class MovingFields {

    @Column
    Integer documentNumber;

    @Column
    LocalDateTime dateOfCreation = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    @Column
    BigDecimal sum;

    @Column
    BigDecimal paid;

    @Column
    Boolean isSent;

    @Column
    Boolean isPrinted;

    @Column
    String comment;

}
