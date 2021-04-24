package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "documents")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column
    private LocalDateTime date;

    @OneToMany(mappedBy = "document", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name="recycle_bin_id")
    private RecycleBin recycleBin;
}
