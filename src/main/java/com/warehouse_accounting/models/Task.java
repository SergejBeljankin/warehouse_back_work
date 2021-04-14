package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
/**
 * Задачи помогают организовать работу.
 * Их можно ставить себе или другим сотрудникам, выполнение отслеживается по уведомлениям.
 * Задачу можно создать из любого документа.
 * Также можно настроить автоматическое создание задач в рамках сценариев.
 * Например, если покупатель в течение недели не оплачивает счет,
 * можно поставить менеджеру задачу связаться с ним.
 */
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

    @Column
    private LocalDateTime dateOfCreation;

    @ManyToOne
    private Employee executor;

    @Column
    private Boolean isDone = false;

    @ManyToOne
    private Contractor contractor;

    @ManyToOne
    private Document document;
}
