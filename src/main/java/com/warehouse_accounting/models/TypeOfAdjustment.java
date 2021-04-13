package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeOfAdjustment {

    ACCOUNTBALANCE("Остаток на счете"),
    CASHBALANCE("Остаток в кассе"),
    COUNTERPARTY("Баланс контрагента");

        @Getter
    private String TypeOfAdjustment;
}

