package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalDetailRepository extends JpaRepository<LegalDetail, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.LegalDetailDto(" +
            "ld.id," +
            "ld.lastName," +
            "ld.firstName," +
            "ld.middleName," +
            "ld.address," +
            "ld.commentToAddress," +
            "ld.inn," +
            "ld.okpo," +
            "ld.ogrnip," +
            "ld.numberOfTheCertificate," +
            "ld.dateOfTheCertificate," +
            ")" +
            "FROM LegalDetail ld")
    List<LegalDetailDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.LegalDetailDto(" +
            "ld.id," +
            "ld.lastName," +
            "ld.firstName," +
            "ld.middleName," +
            "ld.address," +
            "ld.commentToAddress," +
            "ld.inn," +
            "ld.okpo," +
            "ld.ogrnip," +
            "ld.numberOfTheCertificate," +
            "ld.dateOfTheCertificate," +
            ")" +
            "FROM LegalDetail ld WHERE ld.id = :id")
    LegalDetailDto getById(@Param("id") Long id);

    @Query("SELECT ld.typeOfContractor FROM LegalDetail ld WHERE ld.id = :id")
    TypeOfContractor getTypeOfContractorById(@Param("id") Long id);
}
