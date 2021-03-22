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

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractorDto (" +
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
            "cg.id, " +
            "cg.name, " +
            "tc.id, " +
            "tc.name, " +
            "tp.id, " +
            "tp.name, " +
            "c.legalDetail.id" +
            ")" +
            "FROM Contractor c left join ContractorGroup cg on (c.contractorGroup.id = cg.id)" +
            "left join TypeOfContractor tc on (c.typeOfContractor.id = tc.id)" +
            "left join TypeOfPrice tp on (c.typeOfPrice.id = tp.id)")
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
            "cg.id, " +
            "cg.name, " +
            "tc.id, " +
            "tc.name, " +
            "tp.id, " +
            "tp.name, " +
            "c.legalDetail.id" +
            ")" +
            "FROM Contractor c left join ContractorGroup cg on (c.contractorGroup.id = cg.id) " +
            "left join TypeOfContractor tc on (c.typeOfContractor.id = tc.id)" +
            "left join TypeOfPrice tp on (c.typeOfPrice.id = tp.id) WHERE c.id = :id")
    ContractorDto getById(@Param("id") Long id);

}
