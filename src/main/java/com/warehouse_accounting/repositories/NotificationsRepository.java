package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Notifications;
import com.warehouse_accounting.models.dto.NotificationsDto;
import com.warehouse_accounting.models.dto.SettingsDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
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
