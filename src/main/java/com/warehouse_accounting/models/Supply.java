package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/*
Универсальная модель для приемки и отгрузки
 */
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    LocalDateTime dataTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products;

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
