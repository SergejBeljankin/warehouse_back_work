package com.warehouse_accounting.util;

import com.warehouse_accounting.models.*;
import com.warehouse_accounting.models.dto.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;


public class ConverterDto {

    private ConverterDto() {
    }

    public static Application convertToModel(ApplicationDto application) {
        return Application.builder()
                .id(application.getId())
                .name(application.getName())
                .description(application.getDescription())
                .developer(application.getDeveloper())
                .devMail(application.getDevMail())
                .devSite(application.getDevSite())
                .isFree(application.getIsFree())
                .logoId(application.getLogoId())
                .build();
    }

    public static ApplicationDto convertToDto(Application application) {
        return ApplicationDto.builder()
                .id(application.getId())
                .name(application.getName())
                .description(application.getDescription())
                .developer(application.getDeveloper())
                .devMail(application.getDevMail())
                .devSite(application.getDevSite())
                .isFree(application.getIsFree())
                .logoId(application.getLogoId())
                .build();
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


    public static BonusTransaction convertToModel(BonusTransactionDto bonusTransactionDto) {
        return BonusTransaction.builder()
                .id(bonusTransactionDto.getId())
                .created(bonusTransactionDto.getCreated())
                .transactionType(bonusTransactionDto.getTransactionType())
                .bonusValue(bonusTransactionDto.getBonusValue())
                .transactionStatus(bonusTransactionDto.getTransactionStatus())
                .executionDate(bonusTransactionDto.getExecutionDate())
                .bonusProgram(bonusTransactionDto.getBonusProgram())
                .comment(bonusTransactionDto.getComment())
                .contragent(convertToModel(bonusTransactionDto.getContragent()))
                .owner(convertToModel(bonusTransactionDto.getOwner()))
                .build();
    }

    public static BonusTransactionDto convertToDto(BonusTransaction bonusTransaction) {
        return BonusTransactionDto.builder()
                .id(bonusTransaction.getId())
                .created(bonusTransaction.getCreated())
                .transactionType(bonusTransaction.getTransactionType())
                .bonusValue(bonusTransaction.getBonusValue())
                .transactionStatus(bonusTransaction.getTransactionStatus())
                .executionDate(bonusTransaction.getExecutionDate())
                .bonusProgram(bonusTransaction.getBonusProgram())
                .comment(bonusTransaction.getComment())
                .contragent(convertToDto(bonusTransaction.getContragent()))
                .owner(convertToDto(bonusTransaction.getOwner()))
                .build();
    }

    public static Role convertToModel(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .sortNumber(roleDto.getSortNumber())
                .build();
    }

    public static AdjustmentDto convertToDto(Adjustment adjustment) {
        return AdjustmentDto.builder()
                .id(adjustment.getId())
                .number(adjustment.getNumber())
                .dateTimeAdjustment(adjustment.getDateTimeAdjustment())
                .companyId(adjustment.getCompany() != null ? adjustment.getCompany().getId() : null)
                .companyName(adjustment.getCompany() != null ? adjustment.getCompany().getName() : null)
                .contractorId(adjustment.getContractor() != null ? adjustment.getContractor().getId() : null)
                .contractorName(adjustment.getContractor() != null ? adjustment.getContractor().getName() : null)
                .type(adjustment.getType())
                .currentBalance(adjustment.getCurrentBalance())
                .totalBalance(adjustment.getTotalBalance())
                .adjustmentAmount(adjustment.getAdjustmentAmount())
                .comment(adjustment.getComment())
                .whenСhanged(adjustment.getWhenСhanged())
                .build();
    }

    public static Adjustment convertToModel(AdjustmentDto dto) {
        Company company = new Company();
        company.setId(dto.getCompanyId());
        Contractor contractor = new Contractor();
        contractor.setId(dto.getContractorId());
        return Adjustment.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .company(company)
                .contractor(contractor)
                .type(dto.getType())
                .currentBalance(dto.getCurrentBalance())
                .totalBalance(dto.getTotalBalance())
                .adjustmentAmount(dto.getAdjustmentAmount())
                .comment(dto.getComment())
                .whenСhanged(dto.getWhenСhanged())
                .build();
    }

    public static AttributeOfCalculationObjectDto convertToDto(AttributeOfCalculationObject model) {
        if (model == null) {
            return null;
        }
        return AttributeOfCalculationObjectDto.builder()
                .id(model.getId())
                .name(model.getName())
                .sortNumber(model.getSortNumber())
                .isService(model.getIsService())
                .build();
    }

    public static AttributeOfCalculationObject convertToModel(AttributeOfCalculationObjectDto dto) {
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
        if (unit == null) {
            return null;
        }
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
        if (taxSystem == null) {
            return null;
        }
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
                .legalDetail(dto.getLegalDetailDto() != null ? convertToModel(dto.getLegalDetailDto()) : null)
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
                .legalDetailDto(company.getLegalDetail() != null ? convertToDto(company.getLegalDetail()) : null)
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
        return typeOfContractor != null ?
                TypeOfContractorDto.builder()
                        .id(typeOfContractor.getId())
                        .name(typeOfContractor.getName())
                        .sortNumber(typeOfContractor.getSortNumber())
                        .build()
                : null;
    }

    public static TypeOfContractor convertToModel(TypeOfContractorDto typeOfContractorDto) {
        return typeOfContractorDto != null ?
                TypeOfContractor.builder()
                        .id(typeOfContractorDto.getId())
                        .name(typeOfContractorDto.getName())
                        .sortNumber(typeOfContractorDto.getSortNumber())
                        .build()
                : null;
    }

    public static LegalDetail convertToModel(LegalDetailDto legalDetailDto) {
        TypeOfContractor typeOfContractor = new TypeOfContractor();
        typeOfContractor.setId(legalDetailDto.getTypeOfContractorId());
        return LegalDetail.builder()
                .id(legalDetailDto.getId())
                .fullName(legalDetailDto.getFullName())
                .address(legalDetailDto.getAddress())
                .commentToAddress(legalDetailDto.getCommentToAddress())
                .inn(legalDetailDto.getInn())
                .kpp(legalDetailDto.getKpp())
                .okpo(legalDetailDto.getOkpo())
                .ogrn(legalDetailDto.getOgrn())
                .typeOfContractor(typeOfContractor)
                .build();
    }

    public static LegalDetailDto convertToDto(LegalDetail legalDetail) {
        return LegalDetailDto.builder()
                .id(legalDetail.getId())
                .fullName(legalDetail.getFullName())
                .address(legalDetail.getAddress())
                .commentToAddress(legalDetail.getCommentToAddress())
                .inn(legalDetail.getInn())
                .kpp(legalDetail.getKpp())
                .okpo(legalDetail.getOkpo())
                .ogrn(legalDetail.getOgrn())
                .typeOfContractorId(legalDetail.getTypeOfContractor() != null
                        ? legalDetail.getTypeOfContractor().getId() : null)
                .typeOfContractorName(legalDetail.getTypeOfContractor() != null
                        ? legalDetail.getTypeOfContractor().getName() : null)
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
        if (image == null) {
            return null;
        }
        return ImageDto.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .sortNumber(image.getSortNumber())
                .build();
    }

    public static ProductGroupDto convertToDto(ProductGroup productGroup) {
        if (productGroup == null) {
            return null;
        }
        return ProductGroupDto.builder()
                .id(productGroup.getId())
                .name(productGroup.getName())
                .sortNumber(productGroup.getSortNumber())
                .parentId(productGroup.getParentId())
                .build();
    }

    public static ProductGroup convertToModel(ProductGroupDto productGroupDto) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(productGroupDto.getParentId());
        return ProductGroup.builder()
                .id(productGroupDto.getId())
                .name(productGroupDto.getName())
                .sortNumber(productGroupDto.getSortNumber())
                .parentId(productGroupDto.getParentId())
                .build();
    }

    public static TypeOfPriceDto convertToDto(TypeOfPrice typeOfPrice) {
        return TypeOfPriceDto.builder()
                .id(typeOfPrice.getId())
                .name(typeOfPrice.getName())
                .sortNumber(typeOfPrice.getSortNumber())
                .build();
    }

    public static TypeOfPrice convertToModel(TypeOfPriceDto typeOfPriceDto) {
        return TypeOfPrice.builder()
                .id(typeOfPriceDto.getId())
                .name(typeOfPriceDto.getName())
                .sortNumber(typeOfPriceDto.getSortNumber())
                .build();
    }

    public static CallDto convertToDto(Call call) {
        return CallDto.builder()
                .id(call.getId())
                .callTime(call.getCallTime())
                .type(call.getType())
                .number(call.getNumber())
                .callDuration(call.getCallDuration())
                .comment(call.getComment())
                .callRecord(call.getCallRecord())
                .whenChanged(call.getWhenChanged())
                .contractorId(call.getContractor() != null
                        ? call.getContractor().getId() : null)
                .contractorName(call.getContractor() != null
                        ? call.getContractor().getName() : null)
                .employeeWhoCalledId(call.getEmployeeWhoCalled() != null
                        ? call.getEmployeeWhoCalled().getId() : null)
                .employeeWhoCalledName(call.getEmployeeWhoCalled() != null
                        ? call.getEmployeeWhoCalled().getFirstName() : null)
                .employeeWhoChangedId(call.getEmployeeWhoChanged() != null
                        ? call.getEmployeeWhoChanged().getId() : null)
                .employeeWhoChangedName(call.getEmployeeWhoChanged() != null
                        ? call.getEmployeeWhoChanged().getFirstName() : null)
                .build();
    }

    public static Call convertToModel(CallDto callDto) {
        Contractor contractor = new Contractor();
        contractor.setId(callDto.getContractorId());
        Employee employeeWhoCalled = new Employee();
        employeeWhoCalled.setId(callDto.getEmployeeWhoCalledId());
        Employee employeeWhoChanged = new Employee();
        employeeWhoChanged.setId(callDto.getEmployeeWhoChangedId());

        return Call.builder()
                .id(callDto.getId())
                .callTime(callDto.getCallTime())
                .type(callDto.getType())
                .number(callDto.getNumber())
                .callDuration(callDto.getCallDuration())
                .comment(callDto.getComment())
                .callRecord(callDto.getCallRecord())
                .whenChanged(callDto.getWhenChanged())
                .contractor(contractor)
                .employeeWhoChanged(employeeWhoChanged)
                .employeeWhoCalled(employeeWhoCalled)
                .build();
    }

    public static ContractorDto convertToDto(Contractor contractor) {
        if (contractor == null) {
            return null;
        }
        return ContractorDto.builder()
                .id(contractor.getId())
                .name(contractor.getName())
                .sortNumber(contractor.getSortNumber())
                .phone(contractor.getPhone())
                .fax(contractor.getFax())
                .email(contractor.getEmail())
                .address(contractor.getAddress())
                .commentToAddress(contractor.getCommentToAddress())
                .comment(contractor.getComment())
                .numberDiscountCard(contractor.getNumberDiscountCard())
                .contractorGroupId(contractor.getContractorGroup() != null
                        ? contractor.getContractorGroup().getId() : null)
                .contractorGroupName(contractor.getContractorGroup() != null
                        ? contractor.getContractorGroup().getName() : null)
                .typeOfPriceId(contractor.getTypeOfPrice() != null
                        ? contractor.getTypeOfPrice().getId() : null)
                .typeOfPriceName(contractor.getTypeOfPrice() != null
                        ? contractor.getTypeOfPrice().getName() : null)
                .bankAccountDtos(contractor.getBankAccounts().stream()
                        .map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .legalDetailDto(convertToDto(contractor.getLegalDetail()))
                .build();
    }

    public static Contractor convertToModel(ContractorDto contractorDto) {
        ContractorGroup contractorGroup = new ContractorGroup();
        contractorGroup.setId(contractorDto.getContractorGroupId());
        TypeOfPrice typeOfPrice = new TypeOfPrice();
        typeOfPrice.setId(contractorDto.getTypeOfPriceId());
        return Contractor.builder()
                .id(contractorDto.getId())
                .name(contractorDto.getName())
                .sortNumber(contractorDto.getSortNumber())
                .phone(contractorDto.getPhone())
                .fax(contractorDto.getFax())
                .email(contractorDto.getEmail())
                .address(contractorDto.getAddress())
                .commentToAddress(contractorDto.getCommentToAddress())
                .comment(contractorDto.getComment())
                .numberDiscountCard(contractorDto.getNumberDiscountCard())
                .contractorGroup(contractorGroup)
                .typeOfPrice(typeOfPrice)
                .bankAccounts(contractorDto.getBankAccountDtos() != null ?
                        contractorDto.getBankAccountDtos().stream()
                                .map(ConverterDto::convertToModel).collect(Collectors.toList()) : null)
                .legalDetail(contractorDto.getLegalDetailDto() != null ?
                        convertToModel(contractorDto.getLegalDetailDto()) : null)
                .tasks(contractorDto.getTaskDtos() != null ?
                        contractorDto.getTaskDtos().stream()
                                .map(ConverterDto::convertToModel).collect(Collectors.toList()) : null)
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
                .roles(employeeDto.getRoles().stream().map(ConverterDto::convertToModel).collect(Collectors.toSet()))
                .image(convertToModel(employeeDto.getImage())).build();
    }

    public static EmployeeDto convertToDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .lastName(employee.getLastName())
                .firstName(employee.getFirstName())
                .middleName(employee.getMiddleName())
                .sortNumber(employee.getSortNumber())
                .phone(employee.getPhone())
                .inn(employee.getInn())
                .description(employee.getDescription())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .department(convertToDto(employee.getDepartment()))
                .position(convertToDto(employee.getPosition()))
                .roles(employee.getRoles().stream().map(ConverterDto::convertToDto).collect(Collectors.toSet()))
                .image(convertToDto(employee.getImage()))
                .tariff(employee.getTariff().stream().map(ConverterDto::convertToDto).collect(Collectors.toSet()))
                .build();
    }

    public static Set<Role> convertToModel(Set<RoleDto> model) {
        return model.stream().map(e -> Role.builder()
                .id(e.getId())
                .name(e.getName())
                .sortNumber(e.getSortNumber()).build()).collect(Collectors.toSet());
    }

    public static Set<RoleDto> convertToDto(Set<Role> model) {
        return model.stream().map(e -> RoleDto.builder()
                .id(e.getId())
                .name(e.getName())
                .sortNumber(e.getSortNumber()).build()).collect(Collectors.toSet());
    }

    public static Movement convertToModel(MovementDto dto) {
        return Movement.builder()
                .id(dto.getId())
                .dateTime(dto.getDateOfCreation())
                .warehouseFrom(convertToModel(dto.getWarehouseFrom()))
                .warehouseTo(convertToModel(dto.getWarehouseTo()))
                .company(convertToModel(dto.getCompany()))
                .sum(dto.getSum())
                .moved(dto.isMoved())
                .printed(dto.isPrinted())
                .comment(dto.getComment()).build();
    }

    public static Invoice convertToModel(InvoiceDto dto) {
        Employee invoiceAuthor = new Employee();
        invoiceAuthor.setId(dto.getInvoiceAuthorId());
        Company company = new Company();
        company.setId(dto.getCompanyId());
        Project project = new Project();
        project.setId(dto.getProjectId());
        Warehouse warehouse = new Warehouse();
        warehouse.setId(dto.getWarehouseId());
        Contractor contractor = new Contractor();
        contractor.setId(dto.getContractorId());
        Contract contract = new Contract();
        contract.setId(dto.getContractId());
        return Invoice.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .invoiceDateTime(dto.getInvoiceDateTime())
                .type(TypeOfInvoice.valueOf(dto.getType()))
                .isPosted(dto.isPosted())
                .invoiceAuthor(invoiceAuthor)
                .company(company)
                .project(project)
                .warehouse(warehouse)
                .invoiceProducts(dto.getProductDtos() != null ? dto.getProductDtos().stream().map(ConverterDto::convertToModel).collect(Collectors.toList()) : null)
                .comment(dto.getComment())
                .contractor(contractor)
                .contract(contract)
                .edits(dto.getEdits() != null ? dto.getEdits().stream().map(ConverterDto::convertToModel).collect(Collectors.toList()) : null)
                .build();
    }

    public static InvoiceDto convertToDto(Invoice invoice) {
        return InvoiceDto.builder()
                .id(invoice.getId())
                .number(invoice.getNumber())
                .invoiceDateTime(invoice.getInvoiceDateTime())
                .type(invoice.getType().name())
                .isPosted(invoice.isPosted())
                .invoiceAuthorId(invoice.getInvoiceAuthor() != null ? invoice.getInvoiceAuthor().getId() : null)
                .invoiceAuthorLastName(invoice.getInvoiceAuthor() != null ? invoice.getInvoiceAuthor().getLastName() : null)
                .invoiceAuthorFirstName(invoice.getInvoiceAuthor() != null ? invoice.getInvoiceAuthor().getFirstName() : null)
                .companyId(invoice.getCompany() != null ? invoice.getCompany().getId() : null)
                .companyName(invoice.getCompany() != null ? invoice.getCompany().getName() : null)
                .projectId(invoice.getProject() != null ? invoice.getProject().getId() : null)
                .projectName(invoice.getProject() != null ? invoice.getProject().getName() : null)
                .warehouseId(invoice.getWarehouse() != null ? invoice.getWarehouse().getId() : null)
                .warehouseName(invoice.getWarehouse() != null ? invoice.getWarehouse().getName() : null)
                .productDtos(invoice.getInvoiceProducts().stream().map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .comment(invoice.getComment())
                .contractorId(invoice.getContractor() != null ? invoice.getContractor().getId() : null)
                .contractorName(invoice.getContractor() != null ? invoice.getContractor().getName() : null)
                .contractId(invoice.getContract() != null ? invoice.getContract().getId() : null)
                .contractNumber(invoice.getContract() != null ? invoice.getContract().getNumber() : null)
                .contractDate(invoice.getContract() != null ? invoice.getContract().getContractDate() : null)
                .edits(invoice.getEdits().stream().map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .build();
    }

    public static InvoiceEdit convertToModel(InvoiceEditDto dto) {
        return InvoiceEdit.builder()
                .id(dto.getId())
                .editAuthor(convertToModel(dto.getEditAuthorDto()))
                .dateTime(dto.getDateTime())
                .field(dto.getField())
                .before(dto.getBefore())
                .after(dto.getAfter())
                .build();
    }

    public static InvoiceEditDto convertToDto(InvoiceEdit invoiceEdit) {
        return InvoiceEditDto.builder()
                .id(invoiceEdit.getId())
                .editAuthorDto(convertToDto(invoiceEdit.getEditAuthor()))
                .dateTime(invoiceEdit.getDateTime())
                .field(invoiceEdit.getField())
                .before(invoiceEdit.getBefore())
                .after(invoiceEdit.getAfter())
                .build();
    }

    public static Project convertToModel(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .code(projectDto.getCode())
                .description(projectDto.getDescription())
                .build();
    }

    public static ProjectDto convertToDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .code(project.getCode())
                .description(project.getDescription())
                .build();
    }

    public static InvoiceProductDto convertToDto(InvoiceProduct invoiceProduct) {
        return InvoiceProductDto.builder()
                .id(invoiceProduct.getId())
                .invoiceDto(convertToDto(invoiceProduct.getInvoice()))
                .productDto(convertToDto(invoiceProduct.getProduct()))
                .count(invoiceProduct.getCount())
                .price(invoiceProduct.getPrice())
                .sum(invoiceProduct.getSum())
                .build();
    }

    public static InvoiceProduct convertToModel(InvoiceProductDto invoiceProductDto) {
        return InvoiceProduct.builder()
                .id(invoiceProductDto.getId())
                .invoice(convertToModel(invoiceProductDto.getInvoiceDto()))
                .product(convertToModel(invoiceProductDto.getProductDto()))
                .count(invoiceProductDto.getCount())
                .price(invoiceProductDto.getPrice())
                .sum(invoiceProductDto.getSum())
                .build();
    }

    public static Product convertToModel(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .weight(productDto.getWeight())
                .volume(productDto.getVolume())
                .purchasePrice(productDto.getPurchasePrice())
                .description(productDto.getDescription())
                .unit(productDto.getUnitDto() != null ? convertToModel(productDto.getUnitDto()) : null)
                .archive(productDto.getArchive())
                .contractor(productDto.getContractorDto() != null ? convertToModel(productDto.getContractorDto()) : null)
                .productPrices(productDto.getProductPricesDto() != null ? productDto.getProductPricesDto().stream().map(ConverterDto::convertToModel).collect(Collectors.toList()) : null)
                .taxSystem(productDto.getTaxSystemDto() != null ? convertToModel(productDto.getTaxSystemDto()) : null)
                .images(productDto.getImagesDto() != null ? productDto.getImagesDto().stream().map(ConverterDto::convertToModel).collect(Collectors.toList()) : null)
                .productGroup(productDto.getProductGroupDto() != null ? convertToModel(productDto.getProductGroupDto()) : null)
                .attributeOfCalculationObject(productDto.getAttributeOfCalculationObjectDto() != null ? convertToModel(productDto.getAttributeOfCalculationObjectDto()) : null)
                .build();
    }

    public static ProductDto convertToDto(Product product) {
        if (product == null) {
            return null;
        }
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .weight(product.getWeight())
                .volume(product.getVolume())
                .purchasePrice(product.getPurchasePrice())
                .description(product.getDescription())
                .unitDto(convertToDto(product.getUnit()))
                .archive(product.getArchive())
                .contractorDto(convertToDto(product.getContractor()))
                .productPricesDto(product.getProductPrices().stream().map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .taxSystemDto(convertToDto(product.getTaxSystem()))
                .imagesDto(product.getImages().stream().map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .productGroupDto(convertToDto(product.getProductGroup()))
                .attributeOfCalculationObjectDto(convertToDto(product.getAttributeOfCalculationObject()))
                .build();
    }

    public static RecycleBinDto convertToDto(RecycleBin recycleBin) {
        return RecycleBinDto.builder()
                .id(recycleBin.getId())
                .documentType(recycleBin.getDocumentType())
                .number(recycleBin.getNumber())
                .date(recycleBin.getDate())
                .sum(recycleBin.getSum())
                .warehouseTo(recycleBin.getWarehouseTo())
                .warehouseFrom(recycleBin.getWarehouseFrom())
                .companyName(recycleBin.getCompanyName())
                .contractorName(recycleBin.getContractorName())
                .status(recycleBin.getStatus())
                .shipped(recycleBin.getShipped())
                .printed(recycleBin.getPrinted())
                .comment(recycleBin.getComment())
                .build();
    }

    public static RecycleBin convertToModel(RecycleBinDto dto) {
        return new RecycleBin(dto.getId(),
                dto.getDocumentType(),
                dto.getNumber(),
                dto.getDate(),
                dto.getSum(),
                dto.getWarehouseTo(),
                dto.getWarehouseFrom(),
                dto.getCompanyName(),
                dto.getContractorName(),
                dto.getStatus(),
                dto.getShipped(),
                dto.getPrinted(),
                dto.getComment()
        );
    }

    public static FileDto convertToDto(File file) {
        return FileDto.builder()
                .id(file.getId())
                .name(file.getName())
                .size(file.getSize())
                .location(file.getLocation())
                .createdDate(file.getCreatedDate())
                .employee(file.getEmployee())
                .build();
    }

    public static File convertToModel(FileDto dto) {
        return File.builder()
                .id(dto.getId())
                .name(dto.getName())
                .size(dto.getSize())
                .location(dto.getLocation())
                .createdDate(dto.getCreatedDate())
                .employee(dto.getEmployee())
                .build();
    }

    public static ProductPrice convertToModel(ProductPriceDto dto) {
        return ProductPrice.builder()
                .id(dto.getId())
                .product(convertToModel(dto.getProductDto()))
                .typeOfPrice(convertToModel(dto.getTypeOfPriceDto()))
                .price(dto.getPrice())
                .build();
    }

    public static ProductPriceDto convertToDto(ProductPrice productPrice) {
        if (productPrice == null) {
            return null;
        }
        return ProductPriceDto.builder()
                .id(productPrice.getId())
                .productDto(convertToDto(productPrice.getProduct()))
                .typeOfPriceDto(convertToDto(productPrice.getTypeOfPrice()))
                .price(productPrice.getPrice())
                .build();
    }

    public static TechnologicalMap convertToModel(TechnologicalMapDto technologicalMapDto) {
        TechnologicalMapGroup technologicalMapGroup = new TechnologicalMapGroup();
        technologicalMapGroup.setId(technologicalMapDto.getTechnologicalMapGroupId());
        return TechnologicalMap.builder()
                .id(technologicalMapDto.getId())
                .name(technologicalMapDto.getName())
                .comment(technologicalMapDto.getComment())
                .isArchived(technologicalMapDto.isArchived())
                .productionCost(technologicalMapDto.getProductionCost())
                .technologicalMapGroup(technologicalMapGroup)
                .products((technologicalMapDto.getFinishedProducts() != null)
                        ? technologicalMapDto.getFinishedProducts()
                        .stream()
                        .map(ConverterDto::convertToModel)
                        .collect(Collectors.toList())
                        : null)
                .materials((technologicalMapDto.getMaterials() != null)
                        ? technologicalMapDto.getMaterials()
                        .stream()
                        .map(ConverterDto::convertToModel)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static TechnologicalMapDto convertToDto(TechnologicalMap technologicalMap) {
        return TechnologicalMapDto.builder()
                .id(technologicalMap.getId())
                .name(technologicalMap.getName())
                .comment(technologicalMap.getComment())
                .isArchived(technologicalMap.isArchived())
                .productionCost(technologicalMap.getProductionCost())
                .technologicalMapGroupId((technologicalMap.getTechnologicalMapGroup() != null) ?
                        technologicalMap.getTechnologicalMapGroup().getId() : null)
                .technologicalMapGroupName((technologicalMap.getTechnologicalMapGroup() != null) ?
                        technologicalMap.getTechnologicalMapGroup().getName() : null)
                .build();
    }

    public static TechnologicalMapGroup convertToModel(TechnologicalMapGroupDto technologicalMapGroupDto) {
        TechnologicalMapGroup parentTechnologicalMapGroup = null;
        if (technologicalMapGroupDto.getParentTechnologicalMapGroupId() != null) {
            parentTechnologicalMapGroup = new TechnologicalMapGroup();
            parentTechnologicalMapGroup.setId(technologicalMapGroupDto.getParentTechnologicalMapGroupId());
            parentTechnologicalMapGroup.setName(technologicalMapGroupDto.getParentTechnologicalMapGroupName());
        }
        return TechnologicalMapGroup.builder()
                .id(technologicalMapGroupDto.getId())
                .name(technologicalMapGroupDto.getName())
                .code(technologicalMapGroupDto.getCode())
                .comment(technologicalMapGroupDto.getComment())
                .parentTechnologicalMapGroup(parentTechnologicalMapGroup)
                .build();
    }

    public static TechnologicalMapGroupDto convertToDto(TechnologicalMapGroup technologicalMapGroup) {
        return TechnologicalMapGroupDto.builder()
                .id(technologicalMapGroup.getId())
                .name(technologicalMapGroup.getName())
                .code(technologicalMapGroup.getCode())
                .comment(technologicalMapGroup.getComment())
                .parentTechnologicalMapGroupId((technologicalMapGroup.getParentTechnologicalMapGroup() != null) ? technologicalMapGroup.getParentTechnologicalMapGroup().getId() : null)
                .parentTechnologicalMapGroupName((technologicalMapGroup.getParentTechnologicalMapGroup() != null) ? technologicalMapGroup.getParentTechnologicalMapGroup().getName() : null)
                .build();
    }

    public static TechnologicalMapProduct convertToModel(TechnologicalMapProductDto technologicalMapProductDto) {
        Product finishedProducts = new Product();
        finishedProducts.setId(technologicalMapProductDto.getFinishedProductId());
        TechnologicalMap technologicalMap = new TechnologicalMap();
        technologicalMap.setId(technologicalMapProductDto.getTechnologicalMapDto().getId());
        return TechnologicalMapProduct.builder()
                .id(technologicalMapProductDto.getId())
                .products(finishedProducts)
                .count(technologicalMapProductDto.getCount())
                .technologicalMap(technologicalMap)
                .build();
    }

    public static TechnologicalMapProductDto convertToDto(TechnologicalMapProduct technologicalMapProduct) {
        return TechnologicalMapProductDto.builder()
                .id(technologicalMapProduct.getId())
                .finishedProductId((technologicalMapProduct.getProducts() != null) ? technologicalMapProduct.getProducts().getId() : null)
                .finishedProductsName((technologicalMapProduct.getProducts() != null) ? technologicalMapProduct.getProducts().getName() : null)
                .count(technologicalMapProduct.getCount())
                .technologicalMapDto(convertToDto(technologicalMapProduct.getTechnologicalMap()))
                .build();
    }

    public static TechnologicalMapMaterial convertToModel(TechnologicalMapMaterialDto technologicalMapMaterialDto) {
        Product materials = new Product();
        materials.setId(technologicalMapMaterialDto.getMaterialId());
        TechnologicalMap technologicalMap = new TechnologicalMap();
        technologicalMap.setId(technologicalMapMaterialDto.getTechnologicalMapDto().getId());
        return TechnologicalMapMaterial.builder()
                .id(technologicalMapMaterialDto.getId())
                .materials(materials)
                .count(technologicalMapMaterialDto.getCount())
                .technologicalMap(technologicalMap)
                .build();
    }

    public static TechnologicalMapMaterialDto convertToDto(TechnologicalMapMaterial technologicalMapMaterial) {
        return TechnologicalMapMaterialDto.builder()
                .id(technologicalMapMaterial.getId())
                .materialId((technologicalMapMaterial.getMaterials() != null) ? technologicalMapMaterial.getMaterials().getId() : null)
                .materialName((technologicalMapMaterial.getMaterials() != null) ? technologicalMapMaterial.getMaterials().getName() : null)
                .count(technologicalMapMaterial.getCount())
                .technologicalMapDto(convertToDto(technologicalMapMaterial.getTechnologicalMap()))
                .build();
    }


    public static ProductionOrder convertToModel(ProductionOrderDto dto) {
        Company company = new Company();
        company.setId(dto.getCompanyId());
        Warehouse warehouse = new Warehouse();
        warehouse.setId(dto.getWarehouseId());
        Project project = new Project();
        project.setId(dto.getProjectId());
        TechnologicalMap technologicalMap = new TechnologicalMap();
        technologicalMap.setId(dto.getTechnologicalMapId());
        return ProductionOrder.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .dateTime(dto.getDateTime())
                .company(dto.getCompanyId() != null ? company : null)
                .technologicalMap(dto.getTechnologicalMapId() != null ? technologicalMap : null)
                .volumeOfProduction(dto.getVolumeOfProduction())
                .warehouseForMaterials(dto.getWarehouseId() != null ? warehouse : null)
                .planDate(dto.getPlanDate())
                .project(dto.getProjectId() != null ? project : null)
                .comment(dto.getComment())
                .build();
    }

    public static ProductionOrderDto convertToDto(ProductionOrder productionOrder) {
        return ProductionOrderDto.builder()
                .id(productionOrder.getId())
                .number(productionOrder.getNumber())
                .dateTime(productionOrder.getDateTime())
                .companyId(productionOrder.getCompany() != null ? productionOrder.getCompany().getId() : null)
                .companyName(productionOrder.getCompany() != null ? productionOrder.getCompany().getName() : null)
                .technologicalMapId(productionOrder.getTechnologicalMap() != null ? productionOrder.getTechnologicalMap().getId() : null)
                .technologicalMapName(productionOrder.getTechnologicalMap() != null ? productionOrder.getTechnologicalMap().getName() : null)
                .volumeOfProduction(productionOrder.getVolumeOfProduction())
                .warehouseId(productionOrder.getWarehouseForMaterials() != null ? productionOrder.getWarehouseForMaterials().getId() : null)
                .warehouseName(productionOrder.getWarehouseForMaterials() != null ? productionOrder.getWarehouseForMaterials().getName() : null)
                .planDate(productionOrder.getPlanDate())
                .projectId(productionOrder.getProject() != null ? productionOrder.getProject().getId() : null)
                .projectName(productionOrder.getProject() != null ? productionOrder.getProject().getName() : null)
                .comment(productionOrder.getComment())
                .build();
    }

    public static TechnologicalOperation convertToModel(TechnologicalOperationDto technologicalOperationDto) {
        Warehouse warehouseForMaterials = new Warehouse();
        warehouseForMaterials.setId(technologicalOperationDto.getWarehouseForMaterialsId());
        Warehouse warehouseForProduct = new Warehouse();
        warehouseForProduct.setId(technologicalOperationDto.getWarehouseForProductId());
        Company company = new Company();
        company.setId(technologicalOperationDto.getCompanyId());
        Project project = new Project();
        project.setId(technologicalOperationDto.getProjectId());
        TechnologicalMap technologicalMap = new TechnologicalMap();
        technologicalMap.setId(technologicalOperationDto.getTechnologicalMapId());
        return TechnologicalOperation.builder()
                .id(technologicalOperationDto.getId())
                .isArchive(technologicalOperationDto.isArchive())
                .number(technologicalOperationDto.getNumber())
                .date(technologicalOperationDto.getTechnologicalOperationDateTime())
                .company(technologicalOperationDto.getCompanyId() != null ? company : null)
                .technologicalMap(technologicalOperationDto.getTechnologicalMapId() != null ? technologicalMap : null)
                .volumeOfProduction(technologicalOperationDto.getVolumeOfProduction())
                .warehouseForMaterials(technologicalOperationDto.getWarehouseForMaterialsId() != null ? warehouseForMaterials : null)
                .warehouseForProduct(technologicalOperationDto.getWarehouseForProductId() != null ? warehouseForProduct : null)
                .project(technologicalOperationDto.getProjectId() != null ? project : null)
                .comments(technologicalOperationDto.getComments())
                .tasks((technologicalOperationDto.getTasks() != null)
                        ? technologicalOperationDto.getTasks()
                        .stream()
                        .map(ConverterDto::convertToModel)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static TechnologicalOperationDto convertToDto(TechnologicalOperation technologicalOperation) {
        return TechnologicalOperationDto.builder()
                .id(technologicalOperation.getId())
                .number(technologicalOperation.getNumber())
                .isArchive(technologicalOperation.isArchive())
                .technologicalOperationDateTime(technologicalOperation.getDate())
                .companyId(technologicalOperation.getCompany() != null ? technologicalOperation.getCompany().getId() : null)
                .companyName(technologicalOperation.getCompany() != null ? technologicalOperation.getCompany().getName() : null)
                .technologicalMapId(technologicalOperation.getTechnologicalMap() != null ? technologicalOperation.getTechnologicalMap().getId() : null)
                .technologicalMapName(technologicalOperation.getTechnologicalMap() != null ? technologicalOperation.getTechnologicalMap().getName() : null)
                .volumeOfProduction(technologicalOperation.getVolumeOfProduction())
                .warehouseForMaterialsId(technologicalOperation.getWarehouseForMaterials() != null ? technologicalOperation.getWarehouseForMaterials().getId() : null)
                .warehouseForMaterialsName(technologicalOperation.getWarehouseForMaterials() != null ? technologicalOperation.getWarehouseForMaterials().getName() : null)
                .warehouseForProductId(technologicalOperation.getWarehouseForProduct() != null ? technologicalOperation.getWarehouseForProduct().getId() : null)
                .warehouseForProductName(technologicalOperation.getWarehouseForProduct() != null ? technologicalOperation.getWarehouseForProduct().getName() : null)
                .projectId(technologicalOperation.getProject() != null ? technologicalOperation.getProject().getId() : null)
                .projectName(technologicalOperation.getProject() != null ? technologicalOperation.getProject().getName() : null)
                .comments(technologicalOperation.getComments())
                .build();
    }

    public static Country convertToModel(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getId())
                .shortName(countryDto.getShortName())
                .longName(countryDto.getLongName())
                .code(countryDto.getCode())
                .codeOne(countryDto.getCodeOne())
                .codeTwo(countryDto.getCodeTwo())
                .build();
    }

    public static CountryDto convertToDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .shortName(country.getShortName())
                .longName(country.getLongName())
                .code(country.getCode())
                .codeOne(country.getCodeOne())
                .codeTwo(country.getCodeTwo())
                .build();
    }

    public static Task convertToModel(TaskDto taskDto) {
        // TODO: Просто заглушка для тестов, исполнитель должен быть всегда.
        Employee executor = null;
        if (taskDto.getExecutorId() != null) {
            executor = new Employee();
            executor.setId(taskDto.getExecutorId());
        }
        Contractor contractor = null;
        if (taskDto.getContractorId() != null) {
            contractor = new Contractor();
            contractor.setId(taskDto.getContractorId());
        }
        Document document = null;
        if (taskDto.getDocumentId() != null) {
            document = new TechnologicalOperation();
            document.setId(taskDto.getDocumentId());
        }
        return Task.builder()
                .id(taskDto.getId())
                .description(taskDto.getDescription())
                .deadline(taskDto.getDeadline())
                .dateOfCreation(taskDto.getDateOfCreation())
                .isDone(taskDto.getIsDone())
                .executor(executor)
                .contractor(contractor)
                .document(document)
                .build();
    }

    public static TaskDto convertToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .dateOfCreation(task.getDateOfCreation())
                .isDone(task.getIsDone())
                .executorId(task.getExecutor() != null ? task.getExecutor().getId() : null)
                .executorName(task.getExecutor() != null ? task.getExecutor().getFirstName() : null)
                .contractorId(task.getContractor() != null ? task.getContractor().getId() : null)
                .contractorName(task.getContractor() != null ? task.getContractor().getName() : null)
                .documentId(task.getDocument() != null ? task.getDocument().getId() : null)
                .documentName(task.getDocument() != null ? task.getDocument().getType() : null)
                .build();
    }

    public static Payment convertToModel(PaymentDto paymentDto) {
        Contract contract = new Contract();
        contract.setId(paymentDto.getContractId());
        Project project = new Project();
        project.setId(paymentDto.getProjectId());
        PaymentExpenditure paymentExpenditure = new PaymentExpenditure();
        paymentExpenditure.setId(paymentDto.getPaymentExpenditureId());


        return Payment.builder()
                .id(paymentDto.getId())
                .number(paymentDto.getNumber())
                .amount(paymentDto.getAmount())
                .typeOfPayment(paymentDto.getTypeOfPayment())
                .date(paymentDto.getDate())
                .purpose(paymentDto.getPurpose())
                .tax(paymentDto.getTax())
                .comment(paymentDto.getComment())
                .isDone(paymentDto.isDone())
                .contract(paymentDto.getContractId() != null ? contract : null)
                .project(paymentDto.getProjectId() != null ? project : null)
                .paymentExpenditure(paymentDto.getPaymentExpenditureId() != null ? paymentExpenditure : null)
                .contractor(paymentDto.getContractorDto() != null ? convertToModel(paymentDto.getContractorDto()) : null)
                .company(paymentDto.getCompanyDto() != null ? convertToModel(paymentDto.getCompanyDto()) : null)
                .documents(paymentDto.getDocuments()) // На данный момент не существует документов, которые можно было бы привязывать к платежам
                .tasks(paymentDto.getTaskDtos() != null
                        ? paymentDto.getTaskDtos()
                        .stream()
                        .map(ConverterDto::convertToModel)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static PaymentDto convertToDto(Payment payment) {
        return PaymentDto.builder()
                .id(payment.getId())
                .number(payment.getNumber())
                .date(payment.getDate())
                .amount(payment.getAmount())
                .purpose(payment.getPurpose())
                .tax(payment.getTax())
                .comment(payment.getComment())
                .isDone(payment.isDone())
                .typeOfPayment(payment.getTypeOfPayment())
                .contractId(payment.getContract() != null ? payment.getContract().getId() : null)
                .contractNumber(payment.getContract() != null ? payment.getContract().getNumber() : null)
                .projectId(payment.getProject() != null ? payment.getProject().getId() : null)
                .projectName(payment.getProject() != null ? payment.getProject().getName() : null)
                .paymentExpenditureId(payment.getPaymentExpenditure() != null ? payment.getPaymentExpenditure().getId() : null)
                .paymentExpenditureName(payment.getPaymentExpenditure() != null ? payment.getPaymentExpenditure().getName() : null)
                .companyDto(convertToDto(payment.getCompany()) != null ? convertToDto(payment.getCompany()) : null)
                .contractorDto(convertToDto(payment.getContractor()) != null ? convertToDto(payment.getContractor()) : null)
                .documents(payment.getDocuments()) // На данный момент не существует документов, которые можно было бы привязывать к платежам
                .taskDtos(payment.getTasks() != null
                        ? payment.getTasks()
                        .stream()
                        .map(ConverterDto::convertToDto)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static MemoDto convertToDto(Memo memo) {
        return MemoDto.builder()
                .id(memo.getId())
                .createDate(memo.getCreateDate())
                .content(memo.getContent())
                .contractorId(memo.getContractor() != null
                        ? memo.getContractor().getId() : null)
                .contractorName(memo.getContractor() != null
                        ? memo.getContractor().getName() : null)
                .employeeWhoCreatedId(memo.getEmployeeWhoCreated() != null
                        ? memo.getEmployeeWhoCreated().getId() : null)
                .employeeWhoCreatedName(memo.getEmployeeWhoCreated() != null
                        ? memo.getEmployeeWhoCreated().getFirstName() : null)
                .employeeWhoEditedId(memo.getEmployeeWhoEdited() != null
                        ? memo.getEmployeeWhoEdited().getId() : null)
                .employeeWhoEditedName(memo.getEmployeeWhoEdited() != null
                        ? memo.getEmployeeWhoEdited().getFirstName() : null)
                .build();
    }

    public static Memo convertToModel(MemoDto memoDto) {
        Contractor contractor = new Contractor();
        contractor.setId(memoDto.getContractorId());
        Employee employeeWhoCreated = new Employee();
        employeeWhoCreated.setId(memoDto.getEmployeeWhoCreatedId());
        Employee employeeWhoEdited = new Employee();
        employeeWhoEdited.setId(memoDto.getEmployeeWhoEditedId());

        return Memo.builder()
                .id(memoDto.getId())
                .createDate(memoDto.getCreateDate())
                .content(memoDto.getContent())
                .employeeWhoCreated(employeeWhoCreated)
                .employeeWhoEdited(employeeWhoEdited)
                .contractor(contractor)
                .build();
    }

    public static Supply convertToModel(SupplyDto supplyDto) {
        if (supplyDto == null) {
            return null;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setId(supplyDto.getWarehouseId());
        Contract contract = new Contract();
        contract.setId(supplyDto.getContractId());
        Contractor contractor = new Contractor();
        contractor.setId(supplyDto.getContractorId());
        Company company = new Company();
        company.setId(supplyDto.getCompanyId());

        MovingFields movingFields = MovingFields.builder()
                .dateOfCreation(supplyDto.getDateOfCreation())
                .warehouse(warehouse)
                .contract(contract)
                .contractor(contractor)
                .company(company)
                .sum(supplyDto.getSum())
                .paid(supplyDto.getPaid())
                .isSent(supplyDto.getIsSent())
                .isPrinted(supplyDto.getIsPrinted())
                .comment(supplyDto.getComment())
                .build();

        return Supply.builder()
                .id(supplyDto.getId())
                .movingFields(movingFields)
                .products(supplyDto.getProductDtos() != null ? supplyDto.getProductDtos()
                        .stream()
                        .map(ConverterDto::convertToModel)
                        .collect(Collectors.toList()) : null)
                .build();
    }

    public static SupplyDto convertToDto(Supply supply) {
        if (supply == null) {
            return null;
        }
        return SupplyDto.builder()
                .id(supply.getId())
                .dateOfCreation(supply.getMovingFields().getDateOfCreation())
                .warehouseId(supply.getMovingFields().getWarehouse().getId())
                .contractId(supply.getMovingFields().getContract().getId())
                .contractorId(supply.getMovingFields().getContractor().getId())
                .companyId(supply.getMovingFields().getCompany().getId())
                .productDtos(supply.getProducts() != null ? supply.getProducts()
                        .stream()
                        .map(ConverterDto::convertToDto)
                        .collect(Collectors.toList()) : null)
                .sum(supply.getMovingFields().getSum())
                .paid(supply.getMovingFields().getPaid())
                .isSent(supply.getMovingFields().getIsSent())
                .isPrinted(supply.getMovingFields().getIsPrinted())
                .comment(supply.getMovingFields().getComment())
                .build();
    }

    public static Shipment convertToModel(ShipmentDto shipmentDto) {
        if (shipmentDto == null) {
            return null;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setId(shipmentDto.getWarehouseId());
        Contract contract = new Contract();
        contract.setId(shipmentDto.getContractId());
        Contractor contractor = new Contractor();
        contractor.setId(shipmentDto.getContractorId());
        Company company = new Company();
        company.setId(shipmentDto.getCompanyId());
        Contractor consignee = new Contractor();
        consignee.setId(shipmentDto.getConsigneeId());
        Contractor carrier = new Contractor();
        carrier.setId(shipmentDto.getCarrierId());

        MovingFields movingFields = MovingFields.builder()
                .dateOfCreation(shipmentDto.getDateOfCreation())
                .warehouse(shipmentDto.getWarehouseId() != null ? warehouse : null)
                .contract(shipmentDto.getContractId() != null ? contract : null)
                .contractor(shipmentDto.getContractorId() != null ? contractor : null)
                .company(shipmentDto.getCompanyId() != null ? company : null)
                .sum(shipmentDto.getSum())
                .paid(shipmentDto.getPaid())
                .isSent(shipmentDto.getIsSent())
                .isPrinted(shipmentDto.getIsPrinted())
                .comment(shipmentDto.getComment())
                .build();

        return Shipment.builder()
                .id(shipmentDto.getId())
                .movingFields(movingFields)
                .products(shipmentDto.getProductDtos() != null ? shipmentDto.getProductDtos()
                        .stream()
                        .map(ConverterDto::convertToModel)
                        .collect(Collectors.toList()) : null)
                .consignee(shipmentDto.getConsigneeId() != null ? consignee : null)
                .carrier(shipmentDto.getCarrierId() != null ? carrier : null)
                .isPaid(shipmentDto.getIsPaid())
                .deliveryAddress(shipmentDto.getDeliveryAddress())
                .build();
    }

    public static ShipmentDto convertToDto(Shipment shipment) {
        if (shipment == null) {
            return null;
        }

        return ShipmentDto.builder()
                .id(shipment.getId())
                .dateOfCreation(shipment.getMovingFields().getDateOfCreation())
                .warehouseId(shipment.getMovingFields().getWarehouse() != null ? shipment.getMovingFields().getWarehouse().getId() : null)
                .contractId(shipment.getMovingFields().getContract() != null ? shipment.getMovingFields().getContract().getId() : null)
                .contractorId(shipment.getMovingFields().getContractor() != null ? shipment.getMovingFields().getContractor().getId() : null)
                .companyId(shipment.getMovingFields().getCompany() != null ? shipment.getMovingFields().getCompany().getId() : null)
                .productDtos(shipment.getProducts() != null ? shipment.getProducts()
                        .stream()
                        .map(ConverterDto::convertToDto)
                        .collect(Collectors.toList()) : null)
                .sum(shipment.getMovingFields().getSum())
                .paid(shipment.getMovingFields().getPaid())
                .isSent(shipment.getMovingFields().getIsSent())
                .isPrinted(shipment.getMovingFields().getIsPrinted())
                .comment(shipment.getMovingFields().getComment())
                .consigneeId(shipment.getConsignee() != null ? shipment.getConsignee().getId() : null)
                .carrierId(shipment.getCarrier() != null ? shipment.getCarrier().getId() : null)
                .isPaid(shipment.getIsPaid())
                .deliveryAddress(shipment.getDeliveryAddress())
                .build();
    }

    public static Feed convertToModel(FeedDto feedDto) {
        return Feed.builder()
                .id(feedDto.getId())
                .feedHead(feedDto.getFeedHead())
                .feedBody(feedDto.getFeedBody())
                .feedDate(feedDto.getFeedDate())
                .build();
    }

    public static FeedDto convertToDto(Feed feed) {
        return FeedDto.builder()
                .id(feed.getId())
                .feedHead(feed.getFeedHead())
                .feedBody(feed.getFeedBody())
                .feedDate(feed.getFeedDate())
                .build();
    }


    public static TariffDto convertToDto(Tariff tariff) {
        return TariffDto.builder()
                .id(tariff.getId())
                .tariffName(tariff.getTariffName())
                .dataSpace(tariff.getDataSpace())
                .salePointCount(tariff.getSalePointCount())
                .onlineStoreCount(tariff.getOnlineStoreCount())
                .paidApplicationOptionCount(tariff.getPaidApplicationOptionCount())
                .isCRM(tariff.getIsCRM())
                .isScripts(tariff.getIsScripts())
                .extendedBonusProgram(tariff.getExtendedBonusProgram())
                .paymentPeriod(tariff.getPaymentPeriod())
                .totalPrice(tariff.getTotalPrice())
                .dateStartSubscription(tariff.getDateStartSubscription())
                .dateEndSubscription(tariff.getDateEndSubscription())
                .build();
    }

    public static Tariff convertToModel(TariffDto tariffDto) {
        return Tariff.builder()
                .id(tariffDto.getId())
                .tariffName(tariffDto.getTariffName())
                .dataSpace(tariffDto.getDataSpace())
                .salePointCount(tariffDto.getSalePointCount())
                .onlineStoreCount(tariffDto.getOnlineStoreCount())
                .paidApplicationOptionCount(tariffDto.getPaidApplicationOptionCount())
                .isCRM(tariffDto.getIsCRM())
                .isScripts(tariffDto.getIsScripts())
                .extendedBonusProgram(tariffDto.getExtendedBonusProgram())
                .paymentPeriod(tariffDto.getPaymentPeriod())
                .totalPrice(tariffDto.getTotalPrice())
                .dateStartSubscription(tariffDto.getDateStartSubscription())
                .dateEndSubscription(tariffDto.getDateEndSubscription())
                .build();
    }

    public static Set<Tariff> convertToModelTariff(Set<TariffDto> tariffDtoSet) {
        return tariffDtoSet.stream().map(tariffDto -> Tariff.builder()
                .id(tariffDto.getId())
                .tariffName(tariffDto.getTariffName())
                .dataSpace(tariffDto.getDataSpace())
                .salePointCount(tariffDto.getSalePointCount())
                .onlineStoreCount(tariffDto.getOnlineStoreCount())
                .paidApplicationOptionCount(tariffDto.getPaidApplicationOptionCount())
                .isCRM(tariffDto.getIsCRM())
                .isScripts(tariffDto.getIsScripts())
                .extendedBonusProgram(tariffDto.getExtendedBonusProgram())
                .paymentPeriod(tariffDto.getPaymentPeriod())
                .totalPrice(tariffDto.getTotalPrice())
                .dateStartSubscription(tariffDto.getDateStartSubscription())
                .dateEndSubscription(tariffDto.getDateEndSubscription())
                .build())
                .collect(Collectors.toSet());
    }

    public static Set<TariffDto> convertToDtoTariff(Set<Tariff> tariffSet) {
        return tariffSet.stream().map(tariff -> TariffDto.builder()
                .id(tariff.getId())
                .tariffName(tariff.getTariffName())
                .dataSpace(tariff.getDataSpace())
                .salePointCount(tariff.getSalePointCount())
                .onlineStoreCount(tariff.getOnlineStoreCount())
                .paidApplicationOptionCount(tariff.getPaidApplicationOptionCount())
                .isCRM(tariff.getIsCRM())
                .isScripts(tariff.getIsScripts())
                .extendedBonusProgram(tariff.getExtendedBonusProgram())
                .paymentPeriod(tariff.getPaymentPeriod())
                .totalPrice(tariff.getTotalPrice())
                .dateStartSubscription(tariff.getDateStartSubscription())
                .dateEndSubscription(tariff.getDateEndSubscription())
                .build())
                .collect(Collectors.toSet());
    }


    public static Requisites convertToModel(RequisitesDto requisitesDto) {
        return Requisites.builder()
                .id(requisitesDto.getId())
                .organization(requisitesDto.getOrganization())
                .legalAddress(requisitesDto.getLegalAddress())
                .INN(requisitesDto.getINN())
                .KPP(requisitesDto.getKPP())
                .BIK(requisitesDto.getBIK())
                .checkingAccount(requisitesDto.getCheckingAccount())
                .build();
    }

    public static RequisitesDto convertToDto(Requisites requisites) {
        return RequisitesDto.builder()
                .id(requisites.getId())
                .organization(requisites.getOrganization())
                .legalAddress(requisites.getLegalAddress())
                .INN(requisites.getINN())
                .KPP(requisites.getKPP())
                .BIK(requisites.getBIK())
                .checkingAccount(requisites.getCheckingAccount())
                .build();
    }

    public static Subscription convertToModel(SubscriptionDto subscriptionDto) {
        return Subscription.builder()
                .id(subscriptionDto.getId())
                .subscriptionExpirationDate(subscriptionDto.getSubscriptionExpirationDate())
                .employee(convertToModel(subscriptionDto.getEmployee()))
                .requisites(convertToModel(subscriptionDto.getRequisites()))
                .tariffs(subscriptionDto.getTariff().stream().map(ConverterDto::convertToModel).collect(Collectors.toSet()))
                .build();
    }

    public static SubscriptionDto convertToDto(Subscription subscription) {
        return SubscriptionDto.builder()
                .id(subscription.getId())
                .subscriptionExpirationDate(subscription.getSubscriptionExpirationDate())
                .requisites(convertToDto(subscription.getRequisites()))
                .employee(convertToDto(subscription.getEmployee()))
                .tariff(subscription.getTariffs().stream().map(ConverterDto::convertToDto).collect(Collectors.toSet()))
                .build();
    }

    public static CustomerReturns convertToModel(CustomerReturnsDto customerReturnsDto) {
    return CustomerReturns.builder()
            .id(customerReturnsDto.getId())
            .date(customerReturnsDto.getDate())
            .sum(customerReturnsDto.getSum())
            .isPaid(customerReturnsDto.getIsPaid())
            .isSend(customerReturnsDto.getIsSend())
            .comment(customerReturnsDto.getComment())
            .warehouse(convertToModel(customerReturnsDto.getWarehouseDto()))
            .contract(convertToModel(customerReturnsDto.getContractDto()))
            .company(convertToModel(customerReturnsDto.getCompanyDto()))
            .contractor(convertToModel(customerReturnsDto.getContractorDto()))
            .products(customerReturnsDto.getProductDtos()
                    .stream()
                    .map(ConverterDto::convertToModel)
                    .collect(Collectors.toList()))
            .files(customerReturnsDto.getFileDtos()
                    .stream()
                    .map(ConverterDto::convertToModel)
                    .collect(Collectors.toList()))
            .tasks(customerReturnsDto.getTaskDtos()
                    .stream()
                    .map(ConverterDto::convertToModel)
                    .collect(Collectors.toList()))
            .build();
    }

    public static CustomerReturnsDto convertToDto(CustomerReturns customerReturns) {
        return CustomerReturnsDto
                .builder()
                .id(customerReturns.getId())
                .date(customerReturns.getDate())
                .sum(customerReturns.getSum())
                .isPaid(customerReturns.getIsPaid())
                .isSend(customerReturns.getIsSend())
                .comment(customerReturns.getComment())
                .warehouseDto(convertToDto(customerReturns.getWarehouse()))
                .contractDto(convertToDto(customerReturns.getContract()))
                .companyDto(convertToDto(customerReturns.getCompany()))
                .contractorDto(convertToDto(customerReturns.getContractor()))
                .productDtos(customerReturns.getProducts()
                        .stream()
                        .map(ConverterDto::convertToDto)
                        .collect(Collectors.toList()))
                .fileDtos(customerReturns.getFiles()
                        .stream()
                        .map(ConverterDto::convertToDto)
                        .collect(Collectors.toList()))
                .taskDtos(customerReturns.getTasks()
                        .stream()
                        .map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .build();
    }


}
