package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Memo;
import com.warehouse_accounting.models.dto.MemoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.MemoDto(" +
            "m.id, " +
            "m.createDate, " +
            "m.content, " +
            "c.name, " +
            "c.id, " +
            "em.firstName, " +
            "em.id, " +
            "emp.firstName, " +
            "emp.id " +
            ")" +
            "FROM Memo m " +
            "LEFT JOIN Contractor c on (m.contractor.id = c.id)" +
            "LEFT JOIN Employee em on (m.employeeWhoCreated.id = em.id)" +
            "LEFT JOIN Employee emp on (m.employeeWhoEdited.id = emp.id)")
    List<MemoDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.MemoDto(" +
            "m.id, " +
            "m.createDate, " +
            "m.content, " +
            "c.name, " +
            "c.id, " +
            "em.firstName, " +
            "em.id, " +
            "emp.firstName, " +
            "emp.id " +
            ")" +
            "FROM Memo m " +
            "LEFT JOIN Contractor c on (m.contractor.id = c.id)" +
            "LEFT JOIN Employee em on (m.employeeWhoCreated.id = em.id)" +
            "LEFT JOIN Employee emp on (m.employeeWhoEdited.id = emp.id) " +
            "WHERE m.id = :id")
    MemoDto getById(@Param("id") Long id);

}