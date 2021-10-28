package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.exceptions.NotFoundEntityException;
import com.warehouse_accounting.repositories.AdjustmentRepository;
import com.warehouse_accounting.repositories.ApplicationRepository;
import com.warehouse_accounting.repositories.AttributeOfCalculationObjectRepository;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.repositories.BonusTransactionRepository;
import com.warehouse_accounting.repositories.CallRepository;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.ContractorGroupRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.CountryRepository;
import com.warehouse_accounting.repositories.CurrencyRepository;
import com.warehouse_accounting.repositories.DepartmentRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.FeedRepository;
import com.warehouse_accounting.repositories.FileRepository;
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
import com.warehouse_accounting.repositories.RecycleBinRepository;
import com.warehouse_accounting.repositories.ShipmentRepository;
import com.warehouse_accounting.repositories.SubscriptionRepository;
import com.warehouse_accounting.repositories.SupplyRepository;
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
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.exceptions.NotFoundEntityException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CheckEntityServiceImpl implements CheckEntityService {
    @Override
    public void checkExist(Long id, JpaRepository repository, String objectName) {
        if(!repository.existsById(id)) {
            throw new NotFoundEntityException(objectName + " с id=" + id + " не найден");
        }
    }
}