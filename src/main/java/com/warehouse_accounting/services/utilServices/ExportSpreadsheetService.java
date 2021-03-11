package com.warehouse_accounting.services.utilServices;

public interface ExportSpreadsheetService {

    <T> Object getWorkbook(Class<T> targetClass);
}
