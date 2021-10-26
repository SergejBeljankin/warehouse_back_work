package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.util.List;

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
@Table(name = "shipments")
public class Shipment extends MovingFields{


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Warehouse warehouse;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor consignee;

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor carrier;

    @Column
    Boolean isPaid;

    @Column
    String deliveryAddress;

}
