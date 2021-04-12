package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adjustments")
public class Adjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @Column
    private LocalDateTime invoiceDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company counterparty;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfAdjustment type;

    @Column
    private String score;

    @Column
    private String cashbox;

    @Column
    private Double adjustmentAmount;

    @Column
    private String comment;

    @Column
    private LocalDateTime whenСhanged;

    @Column
    private String whenChanged;
}
