package com.warehouse_accounting.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Заказы покупателей
    @OneToOne(fetch = FetchType.LAZY)
    private Selector buyerOrders;

    // Счета покупателей
    @OneToOne(fetch = FetchType.LAZY)
    private Selector buyersInvoices;

    // Остатки
    @OneToOne(fetch = FetchType.LAZY)
    private Selector remainder;

    // Розничная торговля
    @OneToOne(fetch = FetchType.LAZY)
    private Selector retail;

    // Задачи
    @OneToOne(fetch = FetchType.LAZY)
    private Selector tasks;

    // Обмен данными
    @OneToOne(fetch = FetchType.LAZY)
    private Selector dataExchange;

    // Сценарии
    @OneToOne(fetch = FetchType.LAZY)
    private Selector scripts;

    // Интернет-магазины
    @OneToOne(fetch = FetchType.LAZY)
    private Selector onlineStores;
}
