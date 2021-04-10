package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Task;
import com.warehouse_accounting.models.dto.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for entity {@link Task}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 10.04.2021
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TaskDto(" +
            "t.id, " +
            "t.description, " +
            "t.deadline, " +
            "t.dateOfCreation, " +
            "t.isDone, " +
            "e.id, " +
            "e.firstName, " +
            "c.id, " +
            "c.name, " +
            "d.id, " +
            "d.type) " +
            "FROM Task t " +
            "LEFT JOIN Employee e ON (t.executor.id = e.id) " +
            "LEFT JOIN Contractor c ON (t.contractor.id = c.id) " +
            "LEFT JOIN Document d ON (t.document.id = d.id)")
    List<TaskDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TaskDto(" +
            "t.id, " +
            "t.description, " +
            "t.deadline, " +
            "t.dateOfCreation, " +
            "t.isDone, " +
            "e.id, " +
            "e.firstName, " +
            "c.id, " +
            "c.name, " +
            "d.id, " +
            "d.type) " +
            "FROM Task t " +
            "LEFT JOIN Employee e ON (t.executor.id = e.id) " +
            "LEFT JOIN Contractor c ON (t.contractor.id = c.id) " +
            "LEFT JOIN Document d ON (t.document.id = d.id) " +
            "WHERE t.id = :id")
    TaskDto getById(@Param("id") Long id);

    @Query("SELECT task FROM Task task WHERE task.document.id = :id")
    List<Task> getListTaskById(@Param("id") Long id);
}
