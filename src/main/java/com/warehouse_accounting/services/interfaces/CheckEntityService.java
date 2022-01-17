package com.warehouse_accounting.services.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckEntityService {
    void checkExist(Long id, JpaRepository repository, String objectName);
    void checkExistCustomerReturnsById(Long id);
/*
    void checkExistUnitById(Long unitId);


    void checkExistAttributeOfCalculationObjectById(Long attributeOfCalculationObjectId);

    void checkExistCompanyById(Long companyId);

    void checkExistBankAccountById(Long bankAccountId);

    void checkExistContractorGroupById(Long contractorGroupId);

    void checkExistContractById(Long contractId);

    void checkExistCurrencyById(Long currencyId);

    void checkExistDepartmentById(Long departmentId);

    void checkExistImageById(Long imageId);

    void checkExistLegalDetailById(Long legalDetailId);

    void checkExistPositionById(Long positionId);

    void checkExistRoleById(Long roleId);

    void checkExistTaxSystemById(Long taxSystemId);

    void checkExistTypeOfContractorById(Long typeOfContractorId);

    void checkExistTypeOfPriceById(Long typeOfPriceId);

    void checkExistWarehouseById(Long warehouseId);

    void checkExistEmployeeById(Long employeeId);

    void checkExistProductGroupById(Long productGroupID);

    void checkExistContractorById(Long contractorId);

    void checkExistMovementById(Long contractorId);

//  void checkExistTypeOfInvoiceById(Long typeOfInvoiceId);

    void checkExistInvoiceById(Long invoiceId);

    void checkExistInvoiceProductById(Long invoiceProductId);

    void checkExistPaymentById(Long PaymentId);

    void checkExistProjectById(Long projectId);

    void checkExistProductById(Long productId);

    void checkExistProductPriceById(Long productPriceId);

    void checkExistTechnologicalOperationById(Long technologicalOperationId);

    void checkExistProductionOrderById(Long productionOrderId);

    void checkExistCountryById(Long countryId);

    void checkExistTechnologicalMapById(Long invoiceId);

    void checkExistTechnologicalMapGroupById(Long invoiceId);

    void checkExistTechnologicalMapProductById(Long invoiceId);

    void checkExistTechnologicalMapMaterialById(Long invoiceId);

    void checkExistCallById(Long CallId);

    void checkExistTaskById(Long TaskId);

    void checkExistAdjustmentById(Long adjustmentId);

    void checkExistMemoById(Long memoId);

    void checkExistTariffById(Long tariffId);

    void checkExistRequisitesById(Long requisitesId);

    void checkExistSubscriptionById(Long subscriptionId);

    void checkExistFeedById(Long feedId);

    void checkExistBonusTransactionById(Long bonusTransactionId);

    void checkExistApplicationById(Long id);
*/
    void checkExistSettingsById(Long settingsId);

    void checkExistLanguageById(Long settingsId);

    void checkExistPrintingDocumentsById(Long printingDocumentsId);

    void checkExistStartScreenById(Long startScreenId);

    void checkExistNotificationsById(Long notificationsId);
/*
    void checkExistSelectorById(Long selectorId);
*/

}
