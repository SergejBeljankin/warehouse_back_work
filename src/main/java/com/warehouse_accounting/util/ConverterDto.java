package com.warehouse_accounting.util;

import com.warehouse_accounting.models.Adjustment;
import com.warehouse_accounting.models.AttributeOfCalculationObject;
import com.warehouse_accounting.models.BankAccount;
import com.warehouse_accounting.models.Call;
import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.Contract;
import com.warehouse_accounting.models.Contractor;
import com.warehouse_accounting.models.ContractorGroup;
import com.warehouse_accounting.models.Country;
import com.warehouse_accounting.models.Currency;
import com.warehouse_accounting.models.Department;
import com.warehouse_accounting.models.Document;
import com.warehouse_accounting.models.Employee;
import com.warehouse_accounting.models.PaymentExpenditure;
import com.warehouse_accounting.models.Image;
import com.warehouse_accounting.models.Invoice;
import com.warehouse_accounting.models.InvoiceEdit;
import com.warehouse_accounting.models.InvoiceProduct;
import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.Movement;
import com.warehouse_accounting.models.Payment;
import com.warehouse_accounting.models.Position;
import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.ProductGroup;
import com.warehouse_accounting.models.ProductPrice;
import com.warehouse_accounting.models.ProductionOrder;
import com.warehouse_accounting.models.Project;
import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.Task;
import com.warehouse_accounting.models.TaxSystem;
import com.warehouse_accounting.models.TechnologicalMap;
import com.warehouse_accounting.models.TechnologicalMapGroup;
import com.warehouse_accounting.models.TechnologicalMapMaterial;
import com.warehouse_accounting.models.TechnologicalMapProduct;
import com.warehouse_accounting.models.TechnologicalOperation;
import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.TypeOfInvoice;
import com.warehouse_accounting.models.TypeOfPrice;
import com.warehouse_accounting.models.Unit;
import com.warehouse_accounting.models.Warehouse;
import com.warehouse_accounting.models.dto.AdjustmentDto;
import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ContractorGroupDto;
import com.warehouse_accounting.models.dto.CountryDto;
import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.models.dto.DepartmentDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.dto.ImageDto;
import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.models.dto.InvoiceEditDto;
import com.warehouse_accounting.models.dto.InvoiceProductDto;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.MovementDto;
import com.warehouse_accounting.models.dto.PaymentDto;
import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.models.dto.ProductPriceDto;
import com.warehouse_accounting.models.dto.ProductionOrderDto;
import com.warehouse_accounting.models.dto.ProjectDto;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.models.dto.TaskDto;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;
import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.models.dto.TypeOfPriceDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.models.dto.WarehouseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
        return ImageDto.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .sortNumber(image.getSortNumber())
                .build();
    }

    public static ProductGroupDto convertToDto(ProductGroup productGroup) {
        return ProductGroupDto.builder()
                .id(productGroup.getId())
                .name(productGroup.getName())
                .sortNumber(productGroup.getSortNumber())
                .parentId(productGroup.getParentProductGroup().getId())
                .build();
    }

    public static ProductGroup convertToModel(ProductGroupDto productGroupDto) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(productGroupDto.getParentId());
        return ProductGroup.builder()
                .id(productGroupDto.getId())
                .name(productGroupDto.getName())
                .sortNumber(productGroupDto.getSortNumber())
                .parentProductGroup(productGroup)
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
                .image(convertToDto(employee.getImage())).build();
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
                .dateTime(dto.getDateTime())
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

    public static ProductPrice convertToModel(ProductPriceDto dto) {
        return ProductPrice.builder()
                .id(dto.getId())
                .product(convertToModel(dto.getProductDto()))
                .typeOfPrice(convertToModel(dto.getTypeOfPriceDto()))
                .price(dto.getPrice())
                .build();
    }

    public static ProductPriceDto convertToDto(ProductPrice productPrice) {
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
        List<Document> documents = new ArrayList<>(); // На данный момент не существует документов, которые можно было бы привязывать к платежам

        return Payment.builder()
                .id(paymentDto.getId())
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
                .contractor(convertToModel(paymentDto.getContractorDto()))
                .company(convertToModel(paymentDto.getCompanyDto()))
                .employee(convertToModel(paymentDto.getEmployeeDto()))
                .documents(documents) // На данный момент не существует документов, которые можно было бы привязывать к платежам
                .tasks(paymentDto.getTaskDtos() != null
                        ? paymentDto.getTaskDtos()
                        .stream()
                        .map(task -> convertToModel(task))
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static PaymentDto convertToDto(Payment payment) {
        return PaymentDto.builder()
                .id(payment.getId())
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
                .employeeDto(convertToDto(payment.getEmployee()))
                .companyDto(convertToDto(payment.getCompany()))
                .contractorDto(convertToDto(payment.getContractor()))
                .documentId(new ArrayList<>()) // На данный момент не существует документов, которые можно было бы привязывать к платежам
                .taskDtos(payment.getTasks() != null
                        ? payment.getTasks()
                        .stream()
                        .map(task -> convertToDto(task))
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

}
