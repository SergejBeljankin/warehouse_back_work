package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

/*
Модель отгрузки доп поля
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "shipment")
@EqualsAndHashCode(callSuper = true)
public class Shipment extends Supply{

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor consignee;

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor carrier;

    @Column
    Boolean isPaid;

    @Column
    String deliveryAddress;

}
