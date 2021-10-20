package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

/*
Одинаковые поля для приемки и отгрузки
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Embeddable
public class MovingFields {

    @Column
    LocalDateTime dateOfCreation = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Contract contract;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
