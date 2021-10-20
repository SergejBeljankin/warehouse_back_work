package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.dto.LanguageDto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StartScreenRepository {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.StartScreenDto("+

            "l.id, " +
            "l.startScreen" +
            ")"+
            "FROM  StartScreen  l")
    List<LanguageDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.StartScreenDto(" +
            "l.id, " +
            "l.startScreen" +
            ")"+
            "FROM  StartScreen  l WHERE l.id=:id")
    LanguageDto getById(@Param("id") Long id);

}
