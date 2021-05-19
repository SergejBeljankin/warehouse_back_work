package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "memos")
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createDate;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeWhoCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeWhoEdited;


}