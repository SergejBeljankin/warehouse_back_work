package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Application;
import com.warehouse_accounting.models.dto.ApplicationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ApplicationDto(" +
        "app.id," +
        "app.name," +
        "app.description," +
        "app.developer," +
        "app.devSite," +
        "app.devMail," +
        "app.isFree," +
        "app.logoId" +
        ")" +
        " FROM Application app")
    List<ApplicationDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ApplicationDto(" +
            "app.id," +
            "app.name," +
            "app.description," +
            "app.developer," +
            "app.devSite," +
            "app.devMail," +
            "app.isFree," +
            "app.logoId" +
            ")" +
            " FROM Application app WHERE app.id=:id")
    ApplicationDto getById(@Param("id") Long id);
}
