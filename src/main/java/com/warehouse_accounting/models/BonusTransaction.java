package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bonus_transactions")
public class BonusTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime created;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column
    private Long bonusValue;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @Column
    private LocalDateTime executionDate;
    @Column
    private String bonusProgram;//TODO create model/dto
    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor contragent;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee owner;


    public enum TransactionType {
        EARNING, SPENDING
    }

    public enum TransactionStatus {
        WAIT_PROCESSING, COMPLETED, CANCELED
    }

}
