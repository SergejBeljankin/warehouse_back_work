package com.warehouse_accounting.services;

public interface ExportSpreadsheetService {

    <T> Object getWorkbook(Class<T> targetClass);
}
