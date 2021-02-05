package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum TypeOfInvoice {
    RECEIPT("Приход"),
    EXPENSE("Расход"),
    POSTING("Оприходование"),
    WRITE_OFF("Списание");

    @Getter
    private String typeOfInvoice;
}
