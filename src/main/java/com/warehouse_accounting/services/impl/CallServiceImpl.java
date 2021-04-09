package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.repositories.CallRepository;
import com.warehouse_accounting.services.interfaces.CallService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CallServiceImpl implements CallService {

    private final CallRepository callRepository;

    @Autowired
    public CallServiceImpl(CallRepository callRepository) {
        this.callRepository = callRepository;
    }


    @Override
    public List<CallDto> getAll() {
        return callRepository.getAll();
    }

    @Override
    public CallDto getById(Long id) {
        return callRepository.getById(id);
    }

    @Override
    public void create(CallDto callDto) {
        callRepository.save(ConverterDto.convertToModel(callDto));
    }

    @Override
    public void update(CallDto callDto) {
        callRepository.save(ConverterDto.convertToModel(callDto));

    }

    @Override
    public void deleteById(Long id) {
        callRepository.deleteById(id);
    }
}
