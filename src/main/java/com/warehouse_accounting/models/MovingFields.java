package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

/*
Повторяющиеся поля в блоках Закупки, Продажи
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = PRIVATE)
@MappedSuperclass
public class MovingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //время
    @Column
    LocalDateTime dateOfCreation = LocalDateTime.now();

    //Договор
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Contract contract;

    //Контрагент
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Contractor contractor;

    //Организация
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Company company;

    //проект
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Project project;

    //Сумма
    @Column
    BigDecimal sum;

    //оплачено
    @Column
    BigDecimal paid;

    //отправлено
    @Column
    Boolean isSent;

    //напечатано
    @Column
    Boolean isPrinted;

    //комментарий
    @Column
    String comment;

}
