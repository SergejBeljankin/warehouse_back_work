package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfInvoice type;

    @ManyToOne
    private Contractor contractor;

    @ManyToOne
    private Company company;

    @Column
    private LocalDateTime period;

    @Column
    private Long sum;

    @Column
    private Boolean fromWarehouse;

    @Column
    private String currency;

    @Column
    private String status;

}
