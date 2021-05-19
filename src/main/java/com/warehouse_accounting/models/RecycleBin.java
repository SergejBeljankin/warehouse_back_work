package com.warehouse_accounting.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class RecycleBin {
    @Id
    @GeneratedValue
    Long id;

    @NonNull private String name;

    @NonNull private Date createdDate;

    @OneToMany(fetch = LAZY, mappedBy = "recycleBin", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NonNull private List<Document> document;
}