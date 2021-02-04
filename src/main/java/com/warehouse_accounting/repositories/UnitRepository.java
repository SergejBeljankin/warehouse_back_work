package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Unit;
import com.warehouse_accounting.models.dto.UnitDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.UnitDto(" +
            "u.id," +
            "u.shortName," +
            "u.fullName," +
            "u.sortNumber)" +
            "FROM Unit u")
    List<UnitDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.UnitDto(" +
            "u.id," +
            "u.shortName," +
            "u.fullName," +
            "u.sortNumber)" +
            "FROM Unit u where u.id = :id")
    UnitDto getById(@Param("id") Long id);


    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO Units (short_name,full_name,sort_number) VALUES (" +
            ":#{#unitDto.shortName}," +
            ":#{#unitDto.fullName}," +
            ":#{#unitDto.sortNumber})"
            ,nativeQuery = true)
    void create(@Param("unitDto") UnitDto unitDto);



    @Modifying(clearAutomatically = true)
    @Query("UPDATE Unit u SET " +
            "u.shortName =:#{#unitDto.shortName}," +
            "u.fullName=:#{#unitDto.fullName}," +
            "u.sortNumber=:#{#unitDto.sortNumber} " +
            "WHERE u.id = :#{#unitDto.id}")
    void update(@Param("unitDto") UnitDto unitDto);


    @Modifying(clearAutomatically = true)
    @Query("DELETE Unit u WHERE u.id = :id")
    void deleteById(@Param("id") Long id);

}
