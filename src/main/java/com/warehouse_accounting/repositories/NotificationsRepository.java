package com.warehouse_accounting.repositories;


import com.warehouse_accounting.models.dto.NotificationsDto;
import com.warehouse_accounting.models.dto.SettingsDto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationsRepository {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.NotificationsDto(" +
            "n.id, " +
            "n.buyerOrders.id, " +
            "n.buyersInvoices.id, " +
            "n.remainder.id, " +
            "n.retail.id, " +
            "n.tasks.id, " +
            "n.dataExchange.id, " +
            "n.scripts.id, " +
            "n.onlineStores.id " +
            ")" +
            "FROM Notifications n")
    List<NotificationsDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.NotificationsDto(" +
            "n.id, " +
            "n.buyerOrders.id, " +
            "n.buyersInvoices.id, " +
            "n.remainder.id, " +
            "n.retail.id, " +
            "n.tasks.id, " +
            "n.dataExchange.id, " +
            "n.scripts.id, " +
            "n.onlineStores.id " +
            ")" +
            "FROM Notifications n WHERE n.id = :id")
    NotificationsDto getById(@Param("id") Long id);
}
