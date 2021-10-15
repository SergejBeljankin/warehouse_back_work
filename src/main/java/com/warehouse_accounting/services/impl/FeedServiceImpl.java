package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.FeedDto;
import com.warehouse_accounting.repositories.FeedRepository;
import com.warehouse_accounting.services.interfaces.FeedService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;

    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public List<FeedDto> getAll() {
        return feedRepository.getAll();
    }

    @Override
    public FeedDto getById(Long id) {
        return feedRepository.getById(id);
    }

    @Override
    public void create(FeedDto feedDto) {
        feedRepository.save(ConverterDto.convertToModel(feedDto));
    }

    @Override
    public void update(FeedDto feedDto) {
        feedRepository.save(ConverterDto.convertToModel(feedDto));
    }

    @Override
    public void deleteById(Long id) {
        feedRepository.deleteById(id);
    }
}
