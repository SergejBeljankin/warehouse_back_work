package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TaskDto;
import com.warehouse_accounting.repositories.TaskRepository;
import com.warehouse_accounting.services.interfaces.TaskService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class implements interface {@link TaskService}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public TaskDto getById(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public void create(TaskDto taskDto) {
        taskRepository.save(ConverterDto.convertToModel(taskDto));
    }

    @Override
    public void update(TaskDto taskDto) {
        taskRepository.save(ConverterDto.convertToModel(taskDto));
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
