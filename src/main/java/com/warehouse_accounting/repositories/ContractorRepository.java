package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Contractor;
import com.warehouse_accounting.models.dto.ContractorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractorDto(" +
            "c.id, " +
            "c.name, " +
            "c.inn, " +
            "c.sortNumber, " +
            "c.phone, " +
            "c.fax, " +
            "c.email, " +
            "c.address, " +
            "c.commentToAddress, " +
            "c.comment, " +
            "c.contractorGroup.id, " +
            "c.typeOfContractor.id, " +
            "c.typeOfPrice.id, " +
            "c.legalDetail.id" +
            ")" +
            "FROM Contractor c")
    List<ContractorDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractorDto(" +
            "c.id, " +
            "c.name, " +
            "c.inn, " +
            "c.sortNumber, " +
            "c.phone, " +
            "c.fax, " +
            "c.email, " +
            "c.address, " +
            "c.commentToAddress, " +
            "c.comment, " +
            "c.contractorGroup.id, " +
            "c.typeOfContractor.id, " +
            "c.typeOfPrice.id, " +
            "c.legalDetail.id" +
            ")" +
            "FROM Contractor c WHERE c.id = :id")
    ContractorDto getById(@Param("id") Long id);

}
