package com.warehouse_accounting.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recycleBin")
public class RecycleBin {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String documentType;

    @Column
    private String number;  // номер документа

    @Column
    private LocalDate date; // дата создания документа

    @Column
    private BigDecimal sum; // сумма с документа

    @Column
    private String warehouseTo; // со склада  склад

    @Column
    private String warehouseFrom;  //  на склад склад

    @Column
    private String companyName; // организация  имя

    @Column
    private String contractorName; // Контрагент имя

    @Column
    private String status; // статус ?

    @Column
    private String shipped;  // отправлено ?

    @Column
    private String printed; // напечатано ?

    @Column
    private String comment; // коментарий ?


}