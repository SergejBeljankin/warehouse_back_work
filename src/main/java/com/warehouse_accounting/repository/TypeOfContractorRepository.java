package com.warehouse_accounting.repository;

import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TypeOfContractorRepository {
    @Query("SELECT new com.warehouse_accounting.models.dto.TypeOfContractorDto(" +
            "tc.id," +
            "tc.name," +
            "tc.sortNumber" +
            ")" +
            "FROM TypeOfContractor tc")
    public List<TypeOfContractorDto> getAll();


    @Query("SELECT new com.warehouse_accounting.models.dto.TypeOfContractorDto(" +
            "tc.id," +
            "tc.name," +
            "tc.sortNumber" +
            ")" +
            "FROM TypeOfContractor tc where tc.id = :id")
    public TypeOfContractorDto getById(@Param("id") Long Id) ;
}


