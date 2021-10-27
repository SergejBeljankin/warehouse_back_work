package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Language;
import com.warehouse_accounting.models.dto.ImageDto;
import com.warehouse_accounting.models.dto.LanguageDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.LanguageDto("+

            "l.id, " +
            "l.language" +
            ")"+
    "FROM  Language  l")
    List<LanguageDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.LanguageDto(" +
            "l.id, " +
            "l.language" +
            ")"+
            "FROM  Language  l WHERE l.id=:id")
    LanguageDto getById(@Param("id") Long id);

}
