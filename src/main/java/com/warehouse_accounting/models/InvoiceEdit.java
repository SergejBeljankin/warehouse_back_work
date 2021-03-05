package com.warehouse_accounting.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


// Cущность "Правка, вносимая в накладную (Invoice)


@Entity
@Table(name = "invoice_edits")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceEdit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee editAuthor;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String field;

    @Column
    private String before;

    @Column
    private String after;
}
