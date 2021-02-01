package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
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

    public Warehouse(String name, String sortNumber, String address, String commentToAddress, String comment) {
        this.name = name;
        this.sortNumber = sortNumber;
        this.address = address;
        this.commentToAddress = commentToAddress;
        this.comment = comment;
    }
}
