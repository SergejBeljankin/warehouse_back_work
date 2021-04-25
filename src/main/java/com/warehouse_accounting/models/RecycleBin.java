package com.warehouse_accounting.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, doNotUseGetters = true)
@ToString(doNotUseGetters = true)
public class RecycleBin {
    @Id
    @EqualsAndHashCode.Include
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    UUID id;

    @NonNull String name;

    @NonNull Date createdDate;

    @OneToMany(fetch = LAZY, mappedBy = "recycleBin")
    @NonNull List<Document> document;
}