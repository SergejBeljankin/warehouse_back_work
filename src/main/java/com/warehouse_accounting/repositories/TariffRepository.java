package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.Tariff;
import com.warehouse_accounting.models.Task;
import com.warehouse_accounting.models.dto.TariffDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TariffDto(" +
            "tariff.id, " +
            "tariff.tariffName, " +
            "tariff.usersCount, " +
            "tariff.dataSpace, " +
            "tariff.salePointCount, " +
            "tariff.onlineStoreCount, " +
            "tariff.paidApplicationOptionCount, " +
            "tariff.isCRM, " +
            "tariff.isScripts, " +
            "tariff.extendedBonusProgram, " +
            "tariff.paymentPeriod, " +
            "tariff.totalPrice," +
            "tariff.dateStartSubscription, " +
            "tariff.dateEndSubscription)" +
            "FROM Tariff tariff")
    List<TariffDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TariffDto(" +
            "tariff.id, " +
            "tariff.tariffName, " +
            "tariff.usersCount, " +
            "tariff.dataSpace, " +
            "tariff.salePointCount, " +
            "tariff.onlineStoreCount, " +
            "tariff.paidApplicationOptionCount, " +
            "tariff.isCRM, " +
            "tariff.isScripts, " +
            "tariff.extendedBonusProgram, " +
            "tariff.paymentPeriod, " +
            "tariff.totalPrice," +
            "tariff.dateStartSubscription, " +
            "tariff.dateEndSubscription) " +
            "FROM Tariff tariff WHERE tariff.id=:id")
    TariffDto getById(@Param("id") Long id);

    //for Employee
    @Query("SELECT tariff FROM Tariff tariff WHERE tariff.id = :id")
    Set<Tariff> getAllTariffById(@Param("id") Long id);


    @Query("select em.tariff from Employee em where em.id = :id")
    Set<Tariff> getTariffsByEmployeeId(@Param("id") Long id);

}
