package com.warehouse_accounting.repositories;


import com.warehouse_accounting.models.Image;
import com.warehouse_accounting.models.dto.ImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT new com.warehouse_accounting.models.dto.ImageDto(" +
            "im.id," +
            "im.imageUrl," +
            "im.sortNumber"+
            ")"+
            "FROM Image im")
    List<ImageDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.ImageDto(" +
            "im.id," +
            "im.imageUrl," +
            "im.sortNumber"+
            ")"+
            "FROM Image im WHERE im.id=:id")
    ImageDto getById(@Param("id") Long id);

    @Query("SELECT p.images FROM Product p WHERE p.id = :id")
    List<Image> getListImageById(@Param("id") Long id);
}
