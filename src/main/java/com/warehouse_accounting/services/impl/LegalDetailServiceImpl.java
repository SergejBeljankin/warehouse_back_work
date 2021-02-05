package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.services.interfaces.LegalDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LegalDetailServiceImpl implements LegalDetailService {

    private final LegalDetailRepository legalDetailRepository;

    public LegalDetailServiceImpl(LegalDetailRepository legalDetailRepository) {
        this.legalDetailRepository = legalDetailRepository;
    }

    @Override
    public List<LegalDetailDto> getAll() {
        return legalDetailRepository.getAll();
    }

    @Override
    public LegalDetailDto getById(Long id) {
        return legalDetailRepository.getById(id);
    }

    @Override
    public void create(LegalDetailDto legalDetailDto) {
        legalDetailRepository.save(convertToModel(legalDetailDto));
    }

    @Override
    public void update(LegalDetailDto legalDetailDto) {
        legalDetailRepository.save(convertToModel(legalDetailDto));
    }

    @Override
    public void deleteById(Long id) {
        legalDetailRepository.deleteById(id);
    }

    private LegalDetail convertToModel (LegalDetailDto legalDetailDto){
        return LegalDetail.builder()
                .id(legalDetailDto.getId())
                .lastName(legalDetailDto.getLastName())
                .firstName(legalDetailDto.getFirstName())
                .middleName(legalDetailDto.getMiddleName())
                .address(legalDetailDto.getAddress())
                .commentToAddress(legalDetailDto.getCommentToAddress())
                .inn(legalDetailDto.getInn())
                .okpo(legalDetailDto.getOkpo())
                .ogrnip(legalDetailDto.getOgrnip())
                .numberOfTheCertificate(legalDetailDto.getNumberOfTheCertificate())
                .dateOfTheCertificate(legalDetailDto.getDateOfTheCertificate())
                .typeOfContractor(Util.convertToModel(legalDetailDto.getTypeOfContractorDto()))
                .build();
    }
    private LegalDetailDto convertToDto(LegalDetail legalDetail){
        return LegalDetailDto.builder()
                .id(legalDetail.getId())
                .lastName(legalDetail.getLastName())
                .firstName(legalDetail.getFirstName())
                .middleName(legalDetail.getMiddleName())
                .address(legalDetail.getAddress())
                .commentToAddress(legalDetail.getCommentToAddress())
                .inn(legalDetail.getInn())
                .okpo(legalDetail.getOkpo())
                .ogrnip(legalDetail.getOgrnip())
                .numberOfTheCertificate(legalDetail.getNumberOfTheCertificate())
                .dateOfTheCertificate(legalDetail.getDateOfTheCertificate())
                .typeOfContractorDto(Util.convertToDto(legalDetail.getTypeOfContractor()))
                .build();
    }
}
