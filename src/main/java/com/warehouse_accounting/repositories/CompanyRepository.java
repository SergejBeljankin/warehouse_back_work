package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/*
Используем JpaRepository
Dto - это dto той сущности для которой создаётся сервис.
Конструирование Dto делаем в запросе к базе
List<Dto> getAll();

Dto getById(Long id);

void create(Dto dto);

void update(Dto dto);

void deleteById(Long id);
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


}
