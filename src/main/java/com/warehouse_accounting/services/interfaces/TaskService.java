package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.TaskDto;

import java.util.List;

/**
 * This is the interface for the service for the entity {@link com.warehouse_accounting.models.Task}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
public interface TaskService {
    List<TaskDto> getAll();

    TaskDto getById(Long id);

    void create(TaskDto taskDto);

    void update(TaskDto taskDto);

    void deleteById(Long id);
}
