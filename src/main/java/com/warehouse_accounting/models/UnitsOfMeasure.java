package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measures")
public class UnitsOfMeasure {
    //класс еденицы измерений

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String type;
    @Column
    private String name;
    @Column
    private  String fullName;
    @Column
    private Long code;
}