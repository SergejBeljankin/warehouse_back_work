package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalDetailRepository extends JpaRepository<LegalDetail, Long>, JpaSpecificationExecutor<LegalDetail> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.LegalDetailDto(" +
            "ld.id," +
            "ld.fullName," +
            "ld.address," +
            "ld.commentToAddress," +
            "ld.inn," +
            "ld.kpp," +
            "ld.okpo," +
            "ld.ogrn," +
            "ld.typeOfContractor.id," +
            "ld.typeOfContractor.name" +
            ")" +
            "FROM LegalDetail ld left join TypeOfContractor tc on (ld.typeOfContractor.id = tc.id)")
    List<LegalDetailDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.LegalDetailDto(" +
            "ld.id," +
            "ld.fullName," +
            "ld.address," +
            "ld.commentToAddress," +
            "ld.inn," +
            "ld.kpp," +
            "ld.okpo," +
            "ld.ogrn," +
            "ld.typeOfContractor.id," +
            "ld.typeOfContractor.name" +
            ")" +
            "FROM LegalDetail ld left join TypeOfContractor tc on (ld.typeOfContractor.id = tc.id) WHERE ld.id = :id")
    LegalDetailDto getById(@Param("id") Long id);
}
