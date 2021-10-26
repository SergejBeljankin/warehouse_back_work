//package com.warehouse_accounting.services.impl;
//
//import com.warehouse_accounting.models.dto.ReturnDto;
//import com.warehouse_accounting.repositories.FileRepository;
//import com.warehouse_accounting.repositories.ProductRepository;
//import com.warehouse_accounting.repositories.ReturnRepository;
//import com.warehouse_accounting.repositories.TaskRepository;
//import com.warehouse_accounting.services.interfaces.ReturnService;
//import com.warehouse_accounting.util.ConverterDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//public class ReturnServiceImpl implements ReturnService {
//    private final ReturnRepository returnRepository;
//    private final ProductRepository productRepository;
//    private final FileRepository fileRepository;
//    private final TaskRepository taskRepository;
//
//    @Autowired
//    public ReturnServiceImpl(ReturnRepository returnRepository, ProductRepository productRepository,
//                             FileRepository fileRepository, TaskRepository taskRepository) {
//        this.returnRepository = returnRepository;
//        this.productRepository = productRepository;
//        this.fileRepository = fileRepository;
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public List<ReturnDto> getAll() {
//        List<ReturnDto> returnDtos = returnRepository.getAll();
//        for (ReturnDto dto : returnDtos){
//
////          здесь должны обрабатываться файлы, но для них еще не готов репозиторий.
////          В остальных методах - аналогично
//
////            dto.setFileDtos(fileRepository
////                    .get);
////            dto.setTaskDtos(taskRepository
////                    .getListTaskById(dto.getId())
////                    .stream()
////                    .map(ConverterDto::convertToDto)
////                    .collect(Collectors.toList()));
////            dto.getProductDtos(productRepository
////                    .getListProductById(dto.getId())
////                    .stream()
////                    .map(ConverterDto::convertToDto)
////                    .collect(Collectors.toList()));
//        }
//
//        return null;
//    }
//
//    @Override
//    public ReturnDto getById(Long id) {
//        ReturnDto returnDto = returnRepository.getById(id);
////        returnDto.setFileDtos();
////        returnDto.setTaskDtos(taskRepository.
////                getListTaskOfContructorById(returnDto.getId())
////                .stream()
////                .map(ConverterDto::convertToDto)
////                .collect(Collectors.toList()));
////        returnDto.setProductDtos(productRepository
////                .getListProductById(returnDto.getId())
////                .stream()
////                .map(ConverterDto::convertToDto)
////                .collect(Collectors.toList()));
//        return null;
//    }
//
//    @Override
//    public void create(ReturnDto returnDto) {
////        returnRepository.save(ConverterDto.convertToModel(returnDto));
//    }
//
//    @Override
//    public void update(ReturnDto returnDto) {
////        returnRepository.save(ConverterDto.convertToModel(returnDto));
//    }
//
//    @Override
//    public void deleteById(Long id) {
////        returnRepository.deleteById(id);
//    }
//}
