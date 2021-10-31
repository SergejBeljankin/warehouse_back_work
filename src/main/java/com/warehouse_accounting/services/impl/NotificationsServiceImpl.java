package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.NotificationsDto;
import com.warehouse_accounting.repositories.NotificationsRepository;
import com.warehouse_accounting.repositories.SelectorRepository;
import com.warehouse_accounting.services.interfaces.NotificationsService;
import com.warehouse_accounting.util.ConverterDto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NotificationsServiceImpl implements NotificationsService {
    private final NotificationsRepository notificationsRepository;
    private final SelectorRepository selectorRepository;

    public NotificationsServiceImpl(NotificationsRepository notificationsRepository, SelectorRepository selectorRepository) {
        this.notificationsRepository = notificationsRepository;
        this.selectorRepository = selectorRepository;
    }

    @Override
    public List<NotificationsDto> getAll() {
        List<NotificationsDto> notificationsDtos = notificationsRepository.getAll();
        for (NotificationsDto notificationsDto: notificationsDtos) {
            notificationsDto.setBuyerOrders(selectorRepository.getById(notificationsDto.getBuyerOrders().getId()));
            notificationsDto.setBuyersInvoices(selectorRepository.getById(notificationsDto.getBuyersInvoices().getId()));
            notificationsDto.setDataExchange(selectorRepository.getById(notificationsDto.getDataExchange().getId()));
            notificationsDto.setRemainder(selectorRepository.getById(notificationsDto.getRemainder().getId()));
            notificationsDto.setOnlineStores(selectorRepository.getById(notificationsDto.getOnlineStores().getId()));
            notificationsDto.setRetail(selectorRepository.getById(notificationsDto.getRetail().getId()));
            notificationsDto.setScripts(selectorRepository.getById(notificationsDto.getScripts().getId()));
            notificationsDto.setTasks(selectorRepository.getById(notificationsDto.getTasks().getId()));
        }
        return notificationsDtos;


    }

    @Override
    public NotificationsDto getById(Long id) {
        NotificationsDto notificationsDto = notificationsRepository.getById(id);
            notificationsDto.setBuyerOrders(selectorRepository.getById(notificationsDto.getBuyerOrders().getId()));
            notificationsDto.setBuyersInvoices(selectorRepository.getById(notificationsDto.getBuyersInvoices().getId()));
            notificationsDto.setDataExchange(selectorRepository.getById(notificationsDto.getDataExchange().getId()));
            notificationsDto.setRemainder(selectorRepository.getById(notificationsDto.getRemainder().getId()));
            notificationsDto.setOnlineStores(selectorRepository.getById(notificationsDto.getOnlineStores().getId()));
            notificationsDto.setRetail(selectorRepository.getById(notificationsDto.getRetail().getId()));
            notificationsDto.setScripts(selectorRepository.getById(notificationsDto.getScripts().getId()));
            notificationsDto.setTasks(selectorRepository.getById(notificationsDto.getTasks().getId()));
        return notificationsDto;
    }

    @Override
    public void create(NotificationsDto notificationsDto) {
        notificationsRepository.save(ConverterDto.convertToModel(notificationsDto));

    }

    @Override
    public void update(NotificationsDto notificationsDto) {
        notificationsRepository.save(ConverterDto.convertToModel(notificationsDto));

    }

    @Override
    public void deleteById(Long id) {
        notificationsRepository.deleteById(id);
    }
}
