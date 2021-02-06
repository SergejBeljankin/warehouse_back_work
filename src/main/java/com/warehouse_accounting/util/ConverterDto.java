package com.warehouse_accounting.util;

import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;

public class ConverterDto {

    private ConverterDto() {
    }

    public static Company convertToModel(CompanyDto dto) {
        return Company.builder()
                .address(dto.getAddress())
                .chiefAccountant(dto.getChiefAccountant())
                .chiefAccountantSignature(dto.getChiefAccountantSignature())
                .commentToAddress(dto.getCommentToAddress())
                .email(dto.getEmail())
                .fax(dto.getFax())
                .id(dto.getId())
                .inn(dto.getInn())
                .leader(dto.getLeader())
                .leaderManagerPosition(dto.getLeaderManagerPosition())
                .leaderSignature(dto.getLeaderSignature())
                .legalDetail(convertToModel(dto.getLegalDetailDto()))
                .name(dto.getName())
                .payerVat(dto.getPayerVat())
                .phone(dto.getPhone())
                .sortNumber(dto.getSortNumber())
                .stamp(dto.getStamp())
                .build();
    }

    public static CompanyDto convertToDto(Company company) {
        return CompanyDto.builder()
                .address(company.getAddress())
                .chiefAccountant(company.getChiefAccountant())
                .chiefAccountantSignature(company.getChiefAccountantSignature())
                .commentToAddress(company.getCommentToAddress())
                .email(company.getEmail())
                .fax(company.getFax())
                .id(company.getId())
                .inn(company.getInn())
                .leader(company.getLeader())
                .leaderManagerPosition(company.getLeaderManagerPosition())
                .leaderSignature(company.getLeaderSignature())
                .legalDetailDto(convertToDto(company.getLegalDetail()))
                .name(company.getName())
                .payerVat(company.getPayerVat())
                .phone(company.getPhone())
                .sortNumber(company.getSortNumber())
                .stamp(company.getStamp())
                .build();
    }

    public static LegalDetailDto convertToDto(LegalDetail legalDetail) {
        return LegalDetailDto.builder()
                .address(legalDetail.getAddress())
                .commentToAddress(legalDetail.getCommentToAddress())
                .dateOfTheCertificate(legalDetail.getDateOfTheCertificate())
                .firstName(legalDetail.getFirstName())
                .id(legalDetail.getId())
                .inn(legalDetail.getInn())
                .lastName(legalDetail.getLastName())
                .middleName(legalDetail.getMiddleName())
                .numberOfTheCertificate(legalDetail.getNumberOfTheCertificate())
                .ogrnip(legalDetail.getOgrnip())
                .okpo(legalDetail.getOkpo())
                .typeOfContractorDto(convertToDto(legalDetail.getTypeOfContractor()))
                .build();
    }

    public static LegalDetail convertToModel(LegalDetailDto legalDetailDto) {
        return LegalDetail.builder()
                .address(legalDetailDto.getAddress())
                .commentToAddress(legalDetailDto.getCommentToAddress())
                .dateOfTheCertificate(legalDetailDto.getDateOfTheCertificate())
                .firstName(legalDetailDto.getFirstName())
                .id(legalDetailDto.getId())
                .inn(legalDetailDto.getInn())
                .lastName(legalDetailDto.getLastName())
                .middleName(legalDetailDto.getMiddleName())
                .numberOfTheCertificate(legalDetailDto.getNumberOfTheCertificate())
                .ogrnip(legalDetailDto.getOgrnip())
                .okpo(legalDetailDto.getOkpo())
                .typeOfContractor(convertToModel(legalDetailDto.getTypeOfContractorDto()))
                .build();
    }

    public static TypeOfContractorDto convertToDto(TypeOfContractor typeOfContractor) {
        return TypeOfContractorDto.builder()
                .id(typeOfContractor.getId())
                .name(typeOfContractor.getName())
                .sortNumber(typeOfContractor.getSortNumber())
                .build();
    }

    public static TypeOfContractor convertToModel(TypeOfContractorDto typeOfContractorDto) {
        return TypeOfContractor.builder()
                .id(typeOfContractorDto.getId())
                .name(typeOfContractorDto.getName())
                .sortNumber(typeOfContractorDto.getSortNumber())
                .build();
    }

    public static RoleDto convertToDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .sortNumber(role.getSortNumber())
                .build();
    }

    public static Role convertToModel(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .sortNumber(roleDto.getSortNumber())
                .build();
    }
}
