package com.warehouse_accounting.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recycle_bin")
public class RecycleBin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date createdDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recycleBin")
    private List<Document> document;
}