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

    @NonNull
    String name;

    @NonNull
    int size;

    @NonNull
    String location;

    @NonNull
    Date createdDate;

    @OneToMany(fetch = LAZY)
    @NonNull
    List<Employee> employee;
}