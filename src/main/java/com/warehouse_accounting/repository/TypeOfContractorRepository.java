package com.warehouse_accounting.repository;

import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TypeOfContractorRepository extends JpaRepository<TypeOfContractor,Long> {
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


