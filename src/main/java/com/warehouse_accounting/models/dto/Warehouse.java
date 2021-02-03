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

    @Column(name = "sort_numbers")
    private String sortNumber;

    @Column(name = "addresss")
    private String address;

    @Column(name = "comment_to_addresss")
    private String commentToAddress;

    @Column(name = "comments")
    private String comment;


}
