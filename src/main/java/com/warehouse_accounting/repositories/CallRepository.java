package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Call;
import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ContractorGetALLDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<Call,Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CallDto(" +
            "c.id, " +
            "c.callTime, " +
            "c.type, " +
            "c.number, " +
            "c.callDuration, " +
            "c.comment, " +
            "c.callRecord, " +
            "c.whenChanged, " +
            "co.name, " +
            "co.id, " +
            "em.firstName, " +
            "em.id, " +
            "emp.firstName, " +
            "emp.id " +
            ")" +
            "FROM Call c left join Contractor co on (c.contractor.id = co.id)" +
            "left join Employee em on (c.employeeWhoCalled.id = em.id)" +
            "left join Employee emp on (c.employeeWhoChanged.id = emp.id)")
    List<CallDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CallDto(" +
            "c.id, " +
            "c.callTime, " +
            "c.type, " +
            "c.number, " +
            "c.callDuration, " +
            "c.comment, " +
            "c.callRecord, " +
            "c.whenChanged, " +
            "co.name, " +
            "co.id, " +
            "em.firstName, " +
            "em.id, " +
            "emp.firstName, " +
            "emp.id " +
            ")" +
            "FROM Call c left join Contractor co on (c.contractor.id = co.id)" +
            "left join Employee em on (c.employeeWhoCalled.id = em.id)" +
            "left join Employee emp on (c.employeeWhoChanged.id = emp.id)"
            + " WHERE c.id = :id")
    CallDto getById(@Param("id") Long id);


}
