package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeOfPayment {
    RECEIPT_ORDER("Приходный ордер"),
    INCOMING_PAYMENT("Входящий платеж"),
    WITHDRAWAL_ORDER("Расходный ордер"),
    OUTGOING_PAYMENT("Исходящий платеж");

    @Getter
    private String typeOfPayment;
}
