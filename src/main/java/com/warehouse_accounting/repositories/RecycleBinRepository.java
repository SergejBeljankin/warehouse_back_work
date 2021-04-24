package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.RecycleBin;
import org.apache.regexp.RE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleBinRepository extends JpaRepository<RecycleBin, Long> {

    RecycleBin getRecycleBinById(Long id);
//    ShoppingCart getShoppingCartBy(Long id);
//    @Query("SELECT new com.warehouse_accounting.models.dto.ShoppingCartDto(" +
//            "r.id," +
//            "r.userId," +
//            "r.quantity," +
//            "r.product" +
//            ")" +
//            "FROM ShoppingCart r")
//    List<ShoppingCartDto> getAll();
//
//    @Query("SELECT new com.warehouse_accounting.models.dto.ShoppingCartDto(" +
//            "r.id," +
//            "r.userId," +
//            "r.quantity," +
//            "r.product" +
//            ")" +
//            "FROM ShoppingCart r WHERE r.userId=:id")
//    ShoppingCartDto getById(@Param("id") Long id);
//
//
//    @Query("select em.cart from Product em where em.id = :id")
//    Set<ShoppingCart> findAllByUserIdOrderByCreatedDateDesc(@Param("id") Long id);
}
