package com.warehouse_accounting.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector buyerOrders;

    // Счета покупателей
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector buyersInvoices;

    // Остатки
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector remainder;

    // Розничная торговля
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector retail;

    // Задачи
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector tasks;

    // Обмен данными
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector dataExchange;

    // Сценарии
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector scripts;

    // Интернет-магазины
    @ManyToOne(fetch = FetchType.LAZY)
    private Selector onlineStores;
}
