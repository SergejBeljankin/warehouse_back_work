package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.controllers.rest.PaymentRestController;
import com.warehouse_accounting.repositories.AdjustmentRepository;
import com.warehouse_accounting.repositories.AttributeOfCalculationObjectRepository;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.repositories.CallRepository;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.ContractorGroupRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.CountryRepository;
import com.warehouse_accounting.repositories.CurrencyRepository;
import com.warehouse_accounting.repositories.DepartmentRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.ImageRepository;
import com.warehouse_accounting.repositories.InvoiceProductRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.repositories.MemoRepository;
import com.warehouse_accounting.repositories.MovementRepository;
import com.warehouse_accounting.repositories.PaymentRepository;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.repositories.ProductGroupRepository;
import com.warehouse_accounting.repositories.ProductPriceRepository;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.ProductionOrderRepository;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.repositories.RequisitesRepository;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.repositories.SubscriptionRepository;
import com.warehouse_accounting.repositories.TariffRepository;
import com.warehouse_accounting.repositories.TaskRepository;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.repositories.TechnologicalMapGroupRepository;
import com.warehouse_accounting.repositories.TechnologicalMapMaterialRepository;
import com.warehouse_accounting.repositories.TechnologicalMapProductRepository;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.repositories.TechnologicalOperationRepository;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.repositories.TypeOfPriceRepository;
import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.exceptions.NotFoundEntityException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CheckEntityServiceImpl implements CheckEntityService {

    private final AdjustmentRepository adjustmentRepository;
    private final AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository;
    private final BankAccountRepository bankAccountRepository;
    private final CompanyRepository companyRepository;
    private final ContractorGroupRepository contractorGroupRepository;
    private final ContractRepository contractRepository;
    private final ContractorRepository contractorRepository;
    private final CurrencyRepository currencyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ImageRepository imageRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceProductRepository invoiceProductRepository;
    private final LegalDetailRepository legalDetailRepository;
    private final PaymentRepository paymentRepository;
    private final PositionRepository positionRepository;
    private final ProductRepository productRepository;
    private final ProductGroupRepository productGroupRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ProjectRepository projectRepository;
    private final RoleRepository roleRepository;
    private final TaxSystemRepository taxSystemRepository;
    private final TypeOfContractorRepository typeOfContractorRepository;
    private final TypeOfPriceRepository typeOfPriceRepository;
    private final UnitRepository unitRepository;
    private final WarehouseRepository warehouseRepository;
    private final MovementRepository movementRepository;
    private final ProductionOrderRepository productionOrderRepository;
    //private final TypeOfInvoiceRepository typeOfInvoiceRepository;
    private final TechnologicalMapRepository technologicalMapRepository;
    private final TechnologicalMapGroupRepository technologicalMapGroupRepository;
    private final TechnologicalMapMaterialRepository technologicalMapMaterialRepository;
    private final TechnologicalMapProductRepository technologicalMapProductRepository;
    private final TechnologicalOperationRepository technologicalOperationRepository;
    private final CountryRepository countryRepository;
    private final CallRepository callRepository;
    private final TaskRepository taskRepository;
    private final MemoRepository memoRepository;
    private final TariffRepository tariffRepository;
    private final RequisitesRepository requisitesRepository;
    private final SubscriptionRepository subscriptionRepository;

    public void checkExistUnitById(Long unitId) {
        if (!unitRepository.existsById(unitId)) {
            throw new NotFoundEntityException("Ед. измерения с id=" + unitId + ", не найдена");
        }
    }

    public void checkExistAdjustmentById(Long adjustmentId) {
        if (!adjustmentRepository.existsById(adjustmentId)) {
            throw new NotFoundEntityException("Adjustment с id= " + adjustmentId + " , не найден.");
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
        if (!contractorRepository.existsById(contractorId)) {
            throw new NotFoundEntityException("Contractor с id=" + contractorId + ", не найден");
        }
    }

    @Override
    public void checkExistMovementById(Long movementId) {
        if (!movementRepository.existsById(movementId)) {
            throw new NotFoundEntityException("Movement с id=" + movementId + ", не найден");
        }
    }

    @Override
    public void checkExistInvoiceById(Long invoiceId) {
        if (!invoiceRepository.existsById(invoiceId)) {
            throw new NotFoundEntityException("Invoice с id=" + invoiceId + " не найден.");
        }
    }

    @Override
    public void checkExistInvoiceProductById(Long invoiceProductId) {
        if (invoiceProductRepository.existsById(invoiceProductId)) {
            throw new NotFoundEntityException("InvoiceProduct с id=" + invoiceProductId + " не найден.");
        }
    }

    @Override
    public void checkExistProjectById(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new NotFoundEntityException("Project с id=" + projectId + " не найден.");
        }
    }

    @Override
    public void checkExistProductById(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new NotFoundEntityException("Product с id=" + productId + " не найден.");
        }
    }

    @Override
    public void checkExistProductPriceById(Long productPriceId) {
        if (!productPriceRepository.existsById(productPriceId)) {
            throw new NotFoundEntityException("ProductPrice с id=" + productPriceId + " не найден.");
        }
    }

    @Override
    public void checkExistTechnologicalOperationById(Long technologicalOperationId) {
        if (!technologicalOperationRepository.existsById(technologicalOperationId)) {
            throw new NotFoundEntityException("TechnologicalOperation c id=" + technologicalOperationId + "не найденю");
        }
    }

//    public void checkExistTypeOfInvoiceById(Long typeOfInvoiceId) {
//        if (!typeOfInvoiceRepository.existsById(typeOfInvoiceId)) {
//            throw new NotFoundEntityException("TypeOfInvoiceId с id=" + typeOfInvoiceId + ", не найден");
//        }
//    }

    @Override
    public void checkExistProductionOrderById(Long productionOrderId) {
        if (!productionOrderRepository.existsById(productionOrderId)) {
            throw new NotFoundEntityException("ProductionOrder с id=" + productionOrderId + " не найден.");
        }
    }

    @Override
    public void checkExistCountryById(Long countryId) {
        if (!countryRepository.existsById(countryId)) {
            throw new NotFoundEntityException("Country с id=" + countryId + " не найден.");
        }
    }

    @Override
    public void checkExistTechnologicalMapById(Long id) {
        if (!technologicalMapRepository.existsById(id)) {
            throw new NotFoundEntityException("TechnologicalMap с id=" + id + " не найден.");
        }
    }

    @Override
    public void checkExistTechnologicalMapGroupById(Long id) {
        if (!technologicalMapGroupRepository.existsById(id)) {
            throw new NotFoundEntityException("TechnologicalMapGroup с id=" + id + " не найден.");
        }
    }

    @Override
    public void checkExistTechnologicalMapProductById(Long id) {
        if (!technologicalMapProductRepository.existsById(id)) {
            throw new NotFoundEntityException("TechnologicalMapProduct с id=" + id + " не найден.");
        }
    }

    @Override
    public void checkExistTechnologicalMapMaterialById(Long id) {
        if (!technologicalMapMaterialRepository.existsById(id)) {
            throw new NotFoundEntityException("TechnologicalMapMaterial с id=" + id + " не найден.");
        }
    }

    @Override
    public void checkExistCallById(Long callId) {
        if (!callRepository.existsById(callId)) {
            throw new NotFoundEntityException("Call с id=" + callId + " не найден.");
        }
    }

    @Override
    public void checkExistTaskById(Long TaskId) {
        if (!taskRepository.existsById(TaskId)) {
            throw new NotFoundEntityException("Call с id=" + TaskId + " не найден.");
        }
    }

    @Override
    public void checkExistPaymentById(Long paymentId) {
        if (!paymentRepository.existsById(paymentId)) {
            throw new NotFoundEntityException("Payment с id=" + paymentId + " не найден.");
        }
    }

    @Override
    public void checkExistMemoById(Long memoId) {
        if (!memoRepository.existsById(memoId)) {
            throw new NotFoundEntityException("Заметка с id=" + memoId + " не найдена.");
        }
    }

    @Override
    public void checkExistTariffById(Long tariffId) {
        if (!tariffRepository.existsById(tariffId)) {
            throw new NotFoundEntityException("Тариф с id=" + tariffId + " не найден.");
        }
    }

    @Override
    public void checkExistRequisitesById(Long requisitesId) {
        if (!requisitesRepository.existsById(requisitesId)) {
            throw new NotFoundEntityException("Реквизиты с id=" + requisitesId + " не найден.");
        }
    }

    @Override
    public void checkExistSubscriptionById(Long subscriptionId) {
        if (!subscriptionRepository.existsById(subscriptionId)) {
            throw new NotFoundEntityException("Подписка с id=" + subscriptionId + " не найдена.");
        }
    }
}