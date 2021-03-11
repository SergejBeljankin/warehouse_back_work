package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.repositories.AttributeOfCalculationObjectRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.ImageRepository;
import com.warehouse_accounting.repositories.ProductGroupRepository;
import com.warehouse_accounting.repositories.ProductPriceRepository;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.services.interfaces.ProductService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UnitRepository unitRepository;
    private final ContractorRepository contractorRepository;
    private final ProductPriceRepository productPriceRepository;
    private final TaxSystemRepository taxSystemRepository;
    private final ImageRepository imageRepository;
    private final ProductGroupRepository productGroupRepository;
    private final AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              UnitRepository unitRepository,
                              ContractorRepository contractorRepository,
                              ProductPriceRepository productPriceRepository,
                              TaxSystemRepository taxSystemRepository,
                              ImageRepository imageRepository,
                              ProductGroupRepository productGroupRepository,
                              AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository) {
        this.productRepository = productRepository;
        this.unitRepository = unitRepository;
        this.contractorRepository = contractorRepository;
        this.productPriceRepository = productPriceRepository;
        this.taxSystemRepository = taxSystemRepository;
        this.imageRepository = imageRepository;
        this.productGroupRepository = productGroupRepository;
        this.attributeOfCalculationObjectRepository = attributeOfCalculationObjectRepository;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> productDtos = productRepository.getAll();
        productDtos.forEach(productDto -> {
            productDto.setUnitDto(unitRepository.getById(productDto.getUnitDto().getId()));
            productDto.setContractorDto(contractorRepository.getById(productDto.getContractorDto().getId()));
            productDto.setProductPricesDto(productPriceRepository.getListProductPriceById(productDto.getId()).stream()
                    .map(ConverterDto::convertToDto).collect(Collectors.toList()));
            productDto.setTaxSystemDto(taxSystemRepository.getById(productDto.getTaxSystemDto().getId()));
            productDto.setImagesDto(imageRepository.getListImageById(productDto.getId()).stream()
                    .map(ConverterDto::convertToDto).collect(Collectors.toList()));
            productDto.setProductGroupDto(productGroupRepository.getById(productDto.getProductGroupDto().getId()));
            productDto.setAttributeOfCalculationObjectDto(attributeOfCalculationObjectRepository.getById(
                    productDto.getAttributeOfCalculationObjectDto().getId()));
        });
        return productDtos;
    }

    @Override
    public ProductDto getById(Long id) {
        ProductDto productDto = productRepository.getById(id);
        productDto.setUnitDto(unitRepository.getById(productDto.getUnitDto().getId()));
        productDto.setContractorDto(contractorRepository.getById(productDto.getContractorDto().getId()));
        productDto.setProductPricesDto(productPriceRepository.getListProductPriceById(productDto.getId()).stream()
                .map(ConverterDto::convertToDto).collect(Collectors.toList()));
        productDto.setTaxSystemDto(taxSystemRepository.getById(productDto.getTaxSystemDto().getId()));
        productDto.setImagesDto(imageRepository.getListImageById(productDto.getId()).stream()
                .map(ConverterDto::convertToDto).collect(Collectors.toList()));
        productDto.setProductGroupDto(productGroupRepository.getById(productDto.getProductGroupDto().getId()));
        productDto.setAttributeOfCalculationObjectDto(attributeOfCalculationObjectRepository.getById(
                productDto.getAttributeOfCalculationObjectDto().getId()));
        return productDto;
    }

    @Override
    public void create(ProductDto productDto) {
        productRepository.save(ConverterDto.convertToModel(productDto));

    }

    @Override
    public void update(ProductDto productDto) {
        productRepository.save(ConverterDto.convertToModel(productDto));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
