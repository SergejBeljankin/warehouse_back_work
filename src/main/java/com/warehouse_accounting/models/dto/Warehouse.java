package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "sortNumber")
    private String sortNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "commentToAddress")
    private String commentToAddress;
    @Column(name = "comment")
    private String comment;
}
