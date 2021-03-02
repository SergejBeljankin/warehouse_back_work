package com.warehouse_accounting.models.TransferModel;

import com.warehouse_accounting.models.Employee;
import com.warehouse_accounting.models.Warehouse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfer {

    private LocalDateTime dateTime;

    private Employee employee;

    private String comment;

    private boolean transferred;

    private Warehouse warehouseFrom;

    private Warehouse warehouseTo;

    private BigDecimal sum;
}
