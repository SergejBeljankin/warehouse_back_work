package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Subscription;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.SubscriptionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.SubscriptionDto(" +
            "s.id," +
            "s.subscriptionExpirationDate," +
            "s.requisites.id," +
            "s.employee.id" +
            ")" +
            "FROM Subscription s")
    List<SubscriptionDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.SubscriptionDto(" +
            "s.id," +
            "s.subscriptionExpirationDate," +
            "s.requisites.id," +
            "s.employee.id" +
            ")" +
            "FROM Subscription s where s.id=:id")
    SubscriptionDto getById(@Param("id") Long id);
}
