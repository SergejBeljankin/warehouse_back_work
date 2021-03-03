package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.repositories.AttributeOfCalculationObjectRepository;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.ContractorGroupRepository;
import com.warehouse_accounting.repositories.CurrencyRepository;
import com.warehouse_accounting.repositories.DepartmentRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.ImageRepository;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.repositories.ProductGroupRepository;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.repositories.TypeOfPriceRepository;
import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.exceptions.NotFoundEntityException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckEntityServiceImpl implements CheckEntityService {

    private final AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository;
    private final BankAccountRepository bankAccountRepository;
    private final CompanyRepository companyRepository;
    private final ContractorGroupRepository contractorGroupRepository;
    private final ContractRepository contractRepository;
    private final CurrencyRepository currencyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ImageRepository imageRepository;
    private final LegalDetailRepository legalDetailRepository;
    private final PositionRepository positionRepository;
    private final ProductGroupRepository productGroupRepository;
    private final RoleRepository roleRepository;
    private final TaxSystemRepository taxSystemRepository;
    private final TypeOfContractorRepository typeOfContractorRepository;
    private final TypeOfPriceRepository typeOfPriceRepository;
    private final UnitRepository unitRepository;
    private final WarehouseRepository warehouseRepository;
    //private final TypeOfInvoiceRepository typeOfInvoiceRepository;

    public CheckEntityServiceImpl(UnitRepository unitRepository,
                                  AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository,
                                  BankAccountRepository bankAccountRepository,
                                  CompanyRepository companyRepository,
                                  ContractorGroupRepository contractorGroupRepository,
                                  ContractRepository contractRepository,
                                  CurrencyRepository currencyRepository,
                                  DepartmentRepository departmentRepository,
                                  ImageRepository imageRepository,
                                  LegalDetailRepository legalDetailRepository,
                                  PositionRepository positionRepository,
                                  RoleRepository roleRepository,
                                  TaxSystemRepository taxSystemRepository,
                                  TypeOfContractorRepository typeOfContractorRepository,
                                  TypeOfPriceRepository typeOfPriceRepository,
                                  WarehouseRepository warehouseRepository,
                                  ProductGroupRepository productGroupRepository,
                                  EmployeeRepository employeeRepository
//                                 ,TypeOfInvoiceRepository typeOfInvoiceRepository
                                 ) {
        this.unitRepository = unitRepository;
        this.attributeOfCalculationObjectRepository = attributeOfCalculationObjectRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.companyRepository = companyRepository;
        this.contractorGroupRepository = contractorGroupRepository;
        this.contractRepository = contractRepository;
        this.currencyRepository = currencyRepository;
        this.departmentRepository = departmentRepository;
        this.imageRepository = imageRepository;
        this.legalDetailRepository = legalDetailRepository;
        this.positionRepository = positionRepository;
        this.roleRepository = roleRepository;
        this.taxSystemRepository = taxSystemRepository;
        this.typeOfContractorRepository = typeOfContractorRepository;
        this.typeOfPriceRepository = typeOfPriceRepository;
        this.warehouseRepository = warehouseRepository;
        this.productGroupRepository = productGroupRepository;
        this.employeeRepository = employeeRepository;
//        this.typeOfInvoiceRepository = typeOfInvoiceRepository;
    }

    public void checkExistUnitById(Long unitId) {
        if (!unitRepository.existsById(unitId)) {
            throw new NotFoundEntityException("Ед. измерения с id=" + unitId + ", не найдена");
        }
    }

    public void checkExistAttributeOfCalculationObjectById(Long attributeOfCalculationObjectId) {
        if (!attributeOfCalculationObjectRepository.existsById(attributeOfCalculationObjectId)) {
            throw new NotFoundEntityException("AttributeOfCalculationObject с id=" + attributeOfCalculationObjectId +
                    ", не найден");
        }
    }

    public void checkExistCompanyById(Long companyId) {
        if (!companyRepository.existsById(companyId)) {
            throw new NotFoundEntityException("Company с id=" + companyId + ", не найдена");
        }
    }

    public void checkExistBankAccountById(Long bankAccountId) {
        if (!bankAccountRepository.existsById(bankAccountId)) {
            throw new NotFoundEntityException("BankAccount с id=" + bankAccountId + ", не найден");
        }
    }

    public void checkExistContractorGroupById(Long contractorGroupId) {
        if (!contractorGroupRepository.existsById(contractorGroupId)) {
            throw new NotFoundEntityException("ContractorGroup с id=" + contractorGroupId + ", не найден");
        }
    }

    public void checkExistContractById(Long contractId) {
        if (!contractRepository.existsById(contractId)) {
            throw new NotFoundEntityException("Contract с id=" + contractId + ", не найден");
        }
    }

    public void checkExistCurrencyById(Long currencyId) {
        if (!currencyRepository.existsById(currencyId)) {
            throw new NotFoundEntityException("Currency с id=" + currencyId + ", не найден");
        }
    }

    public void checkExistDepartmentById(Long departmentId) {
        if (!departmentRepository.existsById(departmentId)) {
            throw new NotFoundEntityException("Department с id=" + departmentId + ", не найден");
        }
    }

    public void checkExistImageById(Long imageId) {
        if (!imageRepository.existsById(imageId)) {
            throw new NotFoundEntityException("Image с id=" + imageId + ", не найден");
        }
    }

    public void checkExistLegalDetailById(Long legalDetailId) {
        if (!legalDetailRepository.existsById(legalDetailId)) {
            throw new NotFoundEntityException("LegalDetail с id=" + legalDetailId + ", не найден");
        }
    }

    public void checkExistPositionById(Long positionId) {
        if (!positionRepository.existsById(positionId)) {
            throw new NotFoundEntityException("Position с id=" + positionId + ", не найден");
        }
    }

    public void checkExistRoleById(Long roleId) {
        if (!roleRepository.existsById(roleId)) {
            throw new NotFoundEntityException("Role с id=" + roleId + ", не найден");
        }
    }

    public void checkExistTaxSystemById(Long taxSystemId) {
        if (!taxSystemRepository.existsById(taxSystemId)) {
            throw new NotFoundEntityException("TaxSystemId с id=" + taxSystemId + ", не найден");
        }
    }

    public void checkExistTypeOfContractorById(Long typeOfContractorId) {
        if (!typeOfContractorRepository.existsById(typeOfContractorId)) {
            throw new NotFoundEntityException("TypeOfContractor с id=" + typeOfContractorId + ", не найден");
        }
    }

    public void checkExistTypeOfPriceById(Long typeOfPriceId) {
        if (!typeOfPriceRepository.existsById(typeOfPriceId)) {
            throw new NotFoundEntityException("TypeOfPrice с id=" + typeOfPriceId + ", не найден");
        }
    }

    public void checkExistWarehouseById(Long warehouseId) {
        if (!warehouseRepository.existsById(warehouseId)) {
            throw new NotFoundEntityException("Warehouse с id=" + warehouseId + ", не найден");
        }
    }

    public void checkExistEmployeeById(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new NotFoundEntityException("Employee с id=" + employeeId + ", не найден");
        }
    }

    public void checkExistProductGroupById(Long productGroupID) {
        if (!productGroupRepository.existsById(productGroupID)) {
            throw new NotFoundEntityException("ProductGroup с id=" + productGroupID + ", не найден");
        }
    }

    @Override
    public void checkExistContractorById(Long contractorId) {

    }

    public void checkExistTypeOfInvoiceById(Long typeOfInvoiceID) {
//        if (!typeOfInvoiceRepository.existsById(typeOfInvoiceID)) {
//            throw new NotFoundEntityException("TypeOfInvoiceID с id=" + typeOfInvoiceID + ", не найден");
//        }
    }
}
