package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/*
Заказы покупателей
 */
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Product> products;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<File> files;

    @Column
    BigDecimal sum;

    @Column
    String comment;

    @Column
    Boolean isPaid;
}
