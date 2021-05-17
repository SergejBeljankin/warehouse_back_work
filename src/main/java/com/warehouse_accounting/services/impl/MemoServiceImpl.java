package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.MemoDto;
import com.warehouse_accounting.repositories.MemoRepository;
import com.warehouse_accounting.services.interfaces.MemoService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    @Autowired
    public MemoServiceImpl(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    @Override
    public List<MemoDto> getAll() {
        return memoRepository.getAll();
    }

    @Override
    public MemoDto getById(Long id) {
        return memoRepository.getById(id);
    }

    @Override
    public void create(MemoDto memoDto) {
        memoRepository.save(ConverterDto.convertToModel(memoDto));
    }

    @Override
    public void update(MemoDto memoDto) {
        memoRepository.save(ConverterDto.convertToModel(memoDto));
    }

    @Override
    public void deleteById(Long id) {
        memoRepository.deleteById(id);
    }
}