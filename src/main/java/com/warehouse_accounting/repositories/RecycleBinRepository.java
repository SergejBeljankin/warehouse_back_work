package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.RecycleBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleBinRepository extends JpaRepository<RecycleBin, Long> {
}
