package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationsDto {

    private Long id;

    // Заказы покупателей
    private SelectorDto buyerOrders;

    // Счета покупателей
    private SelectorDto buyersInvoices;

    // Остатки
    private SelectorDto remainder;

    // Розничная торговля
    private SelectorDto retail;

    // Задачи
    private SelectorDto tasks;

    // Обмен данными
    private SelectorDto dataExchange;

    // Сценарии
    private SelectorDto scripts;

    // Интернет-магазины
    private SelectorDto onlineStores;
}
