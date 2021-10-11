package com.warehouse_accounting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Пользователь
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    //  Настройки по умолчанию
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor producer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    // Настройки
    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    private PrintingDocuments printingDocuments;

    @Column
    private int numberOfAdditionalFieldsPerLine;

    @ManyToOne(fetch = FetchType.LAZY)
    private StartScreen startScreen;

    @Column
    private boolean RefreshReportsAuto;

    @Column
    private boolean SignatureInLetters;

    // Уведомления
    @OneToOne(fetch = FetchType.LAZY)
    private Notifications notifications;

}
