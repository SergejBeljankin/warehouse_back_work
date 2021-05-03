package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.RecycleBin;
import com.warehouse_accounting.models.dto.RecycleBinDto;
import org.apache.regexp.RE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.UUID;

@Repository
public interface RecycleBinRepository extends JpaRepository<RecycleBin, UUID> {

//    RecycleBin getRecycleBinById(UUID id);
//    RecycleBin getShoppingCartBy(UUID id);
//    @Query("SELECT new com.warehouse_accounting.models.dto.RecycleBinDto(" +
//            "r.id," +
//            "r.name," +
//            "r.createdDate," +
//            "r.document" +
//            ")" +
//            "FROM RecycleBin r")
//    List<RecycleBinDto> getAll();
//
//    @Query("SELECT new com.warehouse_accounting.models.dto.RecycleBinDto(" +
//            "r.id," +
//            "r.name," +
//            "r.createdDate," +
//            "r.document" +
//            ")" +
//            "FROM RecycleBin r WHERE r.id=:id")
//    RecycleBinDto getById(@Param("id") UUID id);
//
//
//    @Query("SELECT rb FROM RecycleBin rb WHERE rb.id = :id")
//    RecycleBin findAllByUserIdOrderByCreatedDateDesc(@Param("id") UUID id);
}
