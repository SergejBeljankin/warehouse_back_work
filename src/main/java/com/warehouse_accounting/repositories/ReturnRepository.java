//package com.warehouse_accounting.repositories;
//
//import com.warehouse_accounting.models.Return;
//import com.warehouse_accounting.models.dto.ReturnDto;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.warehouse_accounting.models.Product;
//
//import java.util.List;
//
//@Repository
//public interface ReturnRepository extends JpaRepository<Return, Long>{
//    @Query("SELECT NEW com.warehouse_accounting.models.dto.ReturnDto(" +
//            "r.id," +
//            "r.dataTime," +
//            "r.warehouse.id," +
//            "r.contract.id," +
//            "r.contractor.id," +
//            "r.company.id," +
//            "r.sum," +
//            "r.isSent," +
//            "r.isPrinted," +
//            "r.comment)" +
//            " FROM Return r")
//    List<ReturnDto> getAll();

//    @Query("SELECT NEW com.warehouse_accounting.models.dto.ReturnDto(" +
//            "r.id," +
//            "r.dataTime," +
//            "r.warehouse.id," +
//            "r.contract.id," +
//            "r.contractor.id," +
//            "r.company.id," +
//            "r.sum," +
//            "r.isSent," +
//            "r.isPrinted," +
//            "r.comment)" +
//            " FROM Return r WHERE r.id = :id")
//    ReturnDto getById(@Param("id") Long id);
//}
