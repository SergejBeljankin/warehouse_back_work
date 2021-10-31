package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.StartScreen;
import com.warehouse_accounting.models.dto.StartScreenDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StartScreenRepository extends JpaRepository<StartScreen, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.StartScreenDto("+

            "l.id, " +
            "l.startScreen" +
            ")"+
            "FROM  StartScreen  l")
    List<StartScreenDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.StartScreenDto(" +
            "l.id, " +
            "l.startScreen" +
            ")"+
            "FROM  StartScreen  l WHERE l.id=:id")
    StartScreenDto getById(@Param("id") Long id);

}
