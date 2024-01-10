package com.hbsh.shop.repository;


import com.hbsh.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String itemNm);
    List<Item> findByItemNmAndItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);
}
