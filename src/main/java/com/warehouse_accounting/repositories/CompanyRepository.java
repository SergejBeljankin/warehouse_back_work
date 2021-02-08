package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.dto.CompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CompanyDto(" +
            "c.id," +
            "c.name," +
            "c.inn," +
            "c.sortNumber," +
            "c.phone," +
            "c.fax," +
            "c.email," +
            "c.payerVat," +
            "c.address," +
            "c.commentToAddress," +
            "c.leader," +
            "c.leaderManagerPosition," +
            "c.leaderSignature," +
            "c.chiefAccountant," +
            "c.chiefAccountantSignature," +
            "c.stamp" +
            ")" +
            " FROM Company c")
    List<CompanyDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CompanyDto(" +
            "c.id," +
            "c.name," +
            "c.inn," +
            "c.sortNumber," +
            "c.phone," +
            "c.fax," +
            "c.email," +
            "c.payerVat," +
            "c.address," +
            "c.commentToAddress," +
            "c.leader," +
            "c.leaderManagerPosition," +
            "c.leaderSignature," +
            "c.chiefAccountant," +
            "c.chiefAccountantSignature," +
            "c.stamp" +
            ")" +
            " FROM Company c WHERE c.id=:id")
    CompanyDto getById(@Param("id") Long id);

    //Т.к. legalDetail не хранит в себе id Company, нужно брать отсюда legalDetail или его id чтобы потом запрашивать
    // его через LegalDetailRepository. Чтобы не делать несколько запросов беру тут сразу legalDetail.
    @Query("SELECT c.legalDetail FROM Company c WHERE c.id = :id")
    LegalDetail getByCompanyId(@Param("id") Long id);

}
