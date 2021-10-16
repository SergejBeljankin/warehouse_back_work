package com.warehouse_accounting.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;
    @Column
    int size;
    @Column
    String location;
    @Column
    Date createdDate;

    @OneToMany(fetch = LAZY)
    List<Employee> employee;
}