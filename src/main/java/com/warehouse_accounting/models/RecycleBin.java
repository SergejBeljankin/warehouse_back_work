package com.warehouse_accounting.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class RecycleBin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    @NonNull private String name;

    @NonNull private Date createdDate;

    @OneToMany(fetch = LAZY, mappedBy = "recycleBin", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NonNull private List<Document> document;
}