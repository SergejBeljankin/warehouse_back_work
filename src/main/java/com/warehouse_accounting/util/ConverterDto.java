package com.warehouse_accounting.util;


import com.warehouse_accounting.models.Currency;
import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.models.BankAccount;
import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.TaxSystem;
import com.warehouse_accounting.models.Unit;
import com.warehouse_accounting.models.Warehouse;
import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.models.dto.WarehouseDto;


public class ConverterDto {

    private ConverterDto() {
    }

    public static Currency convertToModel(CurrencyDto currencyDto) {
        return Currency.builder()
                .id(currencyDto.getId())
                .fullName(currencyDto.getFullName())
                .shortName(currencyDto.getShortName())
                .sortNumber(currencyDto.getSortNumber())
                .digitalCode(currencyDto.getDigitalCode())
                .letterCode(currencyDto.getLetterCode())
                .build();
    }

    public static CurrencyDto convertToDto(Currency currency) {
        return CurrencyDto.builder()
                .id(currency.getId())
                .fullName(currency.getFullName())
                .shortName(currency.getShortName())
                .sortNumber(currency.getSortNumber())
                .digitalCode(currency.getDigitalCode())
                .letterCode(currency.getLetterCode())
                .build();
    }


    public static Role convertToModel(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .sortNumber(roleDto.getSortNumber())
                .build();
    }

    public static RoleDto convertToDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .sortNumber(role.getSortNumber())
                .build();
    }

    public static BankAccount convertToModel(BankAccountDto bankAccountDto) {
        return BankAccount.builder()
                .id(bankAccountDto.getId())
                .rcbic(bankAccountDto.getRcbic())
                .bank(bankAccountDto.getBank())
                .address(bankAccountDto.getAddress())
                .correspondentAccount(bankAccountDto.getCorrespondentAccount())
                .account(bankAccountDto.getAccount())
                .mainAccount(bankAccountDto.getMainAccount())
                .sortNumber(bankAccountDto.getSortNumber())
                .build();
    }

    public static BankAccountDto convertToDto(BankAccount bankAccount) {
        return BankAccountDto.builder()
                .id(bankAccount.getId())
                .rcbic(bankAccount.getRcbic())
                .bank(bankAccount.getBank())
                .address(bankAccount.getAddress())
                .correspondentAccount(bankAccount.getCorrespondentAccount())
                .account(bankAccount.getAccount())
                .mainAccount(bankAccount.getMainAccount())
                .sortNumber(bankAccount.getSortNumber())
                .build();
    }

    public static Unit convertToModel(UnitDto unitDto) {
        return Unit.builder()
                .id(unitDto.getId())
                .shortName(unitDto.getShortName())
                .fullName(unitDto.getFullName())
                .sortNumber(unitDto.getSortNumber())
                .build();
    }

    public static UnitDto convertToDto(Unit unit) {
        return UnitDto.builder()
                .id(unit.getId())
                .shortName(unit.getShortName())
                .fullName(unit.getFullName())
                .sortNumber(unit.getSortNumber())
                .build();
    }

    public static Warehouse convertToModel(WarehouseDto warehouseDto) {
        return Warehouse.builder()
                .id(warehouseDto.getId())
                .name(warehouseDto.getName())
                .sortNumber(warehouseDto.getSortNumber())
                .address(warehouseDto.getAddress())
                .commentToAddress(warehouseDto.getCommentToAddress())
                .comment(warehouseDto.getComment())
                .build();
    }

    public static WarehouseDto convertToDto(Warehouse warehouse) {
        return WarehouseDto.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .sortNumber(warehouse.getSortNumber())
                .address(warehouse.getAddress())
                .commentToAddress(warehouse.getCommentToAddress())
                .comment(warehouse.getComment())
                .build();
    }

    public static TaxSystem convertToModel(TaxSystemDto taxSystemDto) {
        return TaxSystem.builder()
                .id(taxSystemDto.getId())
                .name(taxSystemDto.getName())
                .sortNumber(taxSystemDto.getSortNumber())
                .build();
    }
    public static TaxSystemDto convertToDto(TaxSystem taxSystem) {
        return TaxSystemDto.builder()
                .id(taxSystem.getId())
                .name(taxSystem.getName())
                .sortNumber(taxSystem.getSortNumber())
                .build();
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
}
