package com.warehouse_accounting.util;

import com.warehouse_accounting.models.AttributeOfCalculationObject;
import com.warehouse_accounting.models.BankAccount;
import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.Contract;
import com.warehouse_accounting.models.ContractorGroup;
import com.warehouse_accounting.models.Currency;
import com.warehouse_accounting.models.Department;
import com.warehouse_accounting.models.Employee;
import com.warehouse_accounting.models.Image;
import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.Position;
import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.TaxSystem;
import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.Unit;
import com.warehouse_accounting.models.Warehouse;
import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.models.dto.ContractorGroupDto;
import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.models.dto.DepartmentDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.dto.ImageDto;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.models.dto.WarehouseDto;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static AttributeOfCalculationObjectDto convertToDto (AttributeOfCalculationObject model) {
        return AttributeOfCalculationObjectDto.builder()
                .id(model.getId())
                .name(model.getName())
                .sortNumber(model.getSortNumber())
                .isService(model.getIsService())
                .build();
    }

    public static AttributeOfCalculationObject convertToModel (AttributeOfCalculationObjectDto dto) {
        return AttributeOfCalculationObject.builder()
                .id(dto.getId())
                .name(dto.getName())
                .sortNumber(dto.getSortNumber())
                .isService(dto.getIsService())
                .build();
    }

    public static Department convertToModel(DepartmentDto departmentDto) {
        return Department.builder()
                .id(departmentDto.getId())
                .name(departmentDto.getName())
                .sortNumber(departmentDto.getSortNumber())
                .build();
    }

    public static DepartmentDto convertToDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .sortNumber(department.getSortNumber())
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

    public static ContractorGroup convertToModel(ContractorGroupDto contractorGroupDto) {
        return ContractorGroup.builder()
                .id(contractorGroupDto.getId())
                .name(contractorGroupDto.getName())
                .sortNumber(contractorGroupDto.getSortNumber())
                .build();
    }

    public static ContractorGroupDto convertToDto(ContractorGroup contractorGroup) {
        return ContractorGroupDto.builder()
                .id(contractorGroup.getId())
                .name(contractorGroup.getName())
                .sortNumber(contractorGroup.getSortNumber())
                .build();
    }

    public static Position convertToModel(PositionDto positionDto) {
        return Position.builder()
                .id(positionDto.getId())
                .name(positionDto.getName())
                .sortNumber(positionDto.getSortNumber())
                .build();
    }

    public static PositionDto convertToDto(Position position) {
        return PositionDto.builder()
                .id(position.getId())
                .name(position.getName())
                .sortNumber(position.getSortNumber())
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

    public static LegalDetailDto convertToDto(LegalDetail legalDetail) {
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
                .typeOfContractorDto(convertToDto(legalDetail.getTypeOfContractor()))
                .build();
    }

    public static LegalDetail convertToModel(LegalDetailDto legalDetailDto) {
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
                .typeOfContractor(convertToModel(legalDetailDto.getTypeOfContractorDto()))
                .build();
    }

    public static ContractDto convertToDto(Contract contract) {
        return ContractDto.builder()
                .id(contract.getId())
                .number(contract.getNumber())
                .contractDate(contract.getContractDate())
                .companyDto(convertToDto(contract.getCompany()))
                .bankAccountDto(convertToDto(contract.getBankAccount()))
                .contractorDto(convertToDto(contract.getContractor()))
                .amount(contract.getAmount())
                .archive(contract.getArchive())
                .comment(contract.getComment())
                .legalDetailDto(convertToDto(contract.getLegalDetail()))
                .build();
    }

    public static Contract convertToModel(ContractDto contractDto) {
        return Contract.builder()
                .id(contractDto.getId())
                .number(contractDto.getNumber())
                .contractDate(contractDto.getContractDate())
                .company(convertToModel(contractDto.getCompanyDto()))
                .bankAccount(convertToModel(contractDto.getBankAccountDto()))
                .contractor(convertToModel(contractDto.getContractorDto()))
                .amount(contractDto.getAmount())
                .archive(contractDto.getArchive())
                .comment(contractDto.getComment())
                .legalDetail(convertToModel(contractDto.getLegalDetailDto()))
                .build();
    }

    public static Image convertToModel(ImageDto imageDto) {
        return Image.builder()
                .id(imageDto.getId())
                .imageUrl(imageDto.getImageUrl())
                .sortNumber(imageDto.getSortNumber())
                .build();
    }

    public static ImageDto convertToDto(Image image) {
        return ImageDto.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .sortNumber(image.getSortNumber())
                .build();
    }

    public static Employee convertToModel(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.getId())
                .lastName(employeeDto.getLastName())
                .firstName(employeeDto.getFirstName())
                .middleName(employeeDto.getMiddleName())
                .sortNumber(employeeDto.getSortNumber())
                .phone(employeeDto.getPhone())
                .inn(employeeDto.getInn())
                .description(employeeDto.getDescription())
                .email(employeeDto.getEmail())
                .password(employeeDto.getPassword())
                .department(convertToModel(employeeDto.getDepartment()))
                .position(convertToModel(employeeDto.getPosition()))
                .roles(from(employeeDto.getRoles()))
                .image(convertToModel(employeeDto.getImage())).build();
    }

    public static Set<Role> from(Set<RoleDto> model){
        return model.stream().map(e-> Role.builder()
                .id(e.getId())
                .name(e.getName())
                .sortNumber(e.getSortNumber()).build()).collect(Collectors.toSet());
    }

//    public static Set<Role> from(Set<RoleDto> model){
//        return model.stream().map(e->{
//            return Role.builder()
//                    .id(e.getId())
//                    .name(e.getName())
//                    .sortNumber(e.getSortNumber()).build();
//        }).collect(Collectors.toSet());
//    }

}
