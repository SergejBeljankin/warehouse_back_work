package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private LocalDateTime deadline;

    @Column LocalDateTime dateOfCreation;

    @ManyToOne
    private Employee executor;

    @Column
    private Boolean isDone;

    @ManyToOne
    private Contractor contractor;

    @Column
    private TypeOfInvoice document;
}
