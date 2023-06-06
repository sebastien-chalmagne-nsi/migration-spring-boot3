package com.example.demo.repository;

import com.example.demo.entity.ItemEntity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<ItemEntity, Long>, CrudRepository<ItemEntity, Long> {
}
