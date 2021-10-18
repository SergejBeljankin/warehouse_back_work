package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Feed;
import com.warehouse_accounting.models.dto.FeedDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
    @Query("SELECT new com.warehouse_accounting.models.dto.FeedDto(" +
            "feed.id," +
            "feed.feedHead," +
            "feed.feedBody,"+
            "feed.feedDate"+
            ")"+
            "FROM Feed feed")
    List<FeedDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.FeedDto(" +
            "feed.id," +
            "feed.feedHead," +
            "feed.feedBody,"+
            "feed.feedDate"+
            ")"+
            "FROM Feed feed WHERE feed.id=:id")
    FeedDto getById(@Param("id") Long id);
}
