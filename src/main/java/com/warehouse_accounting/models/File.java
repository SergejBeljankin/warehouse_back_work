package com.warehouse_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class File {


    @Id
    @GeneratedValue
    long id;

    @NonNull String name;
    @NonNull int size;
    @NonNull String location;
    @NonNull Date createdDate;

    @OneToMany(fetch = LAZY)
    @NonNull List<Employee> employee;




    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}