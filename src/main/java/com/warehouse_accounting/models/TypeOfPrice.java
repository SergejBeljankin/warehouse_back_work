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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TypesOfPrice")
public class TypeOfPrice {

    @Id
    @GeneratedValue()
    @Column(name = "Id", unique = true)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "SortNumber")    private String sortNumber;
}


