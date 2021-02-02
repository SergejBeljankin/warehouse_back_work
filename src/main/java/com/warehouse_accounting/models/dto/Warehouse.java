package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "warehouses")
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "names")
    private String name;

    @Column(name = "sortNumbers")
    private String sortNumber;

    @Column(name = "addresss")
    private String address;

    @Column(name = "commentToAddresss")
    private String commentToAddress;

    @Column(name = "comments")
    private String comment;

    public Warehouse(String name, String sortNumber, String address, String commentToAddress, String comment) {
        this.name = name;
        this.sortNumber = sortNumber;
        this.address = address;
        this.commentToAddress = commentToAddress;
        this.comment = comment;
    }
}
