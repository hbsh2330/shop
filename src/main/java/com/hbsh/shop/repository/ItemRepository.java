package com.hbsh.shop.repository;


import com.hbsh.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm);
    List<Item> findByItemNmAndItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetailContaining(@Param("itemDetail") String itemDetail);


}
