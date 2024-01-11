package com.hbsh.shop.dto;

import com.hbsh.shop.constant.ItemSellStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
//물건Dto
public class ItemDto {
    private Long id;
    private String itemNm;
    private int price;
    private String itemDetail;
    private String sellStatCd;
    private LocalDateTime regTime; // 상품 등록시간
    private LocalDateTime updateTime; // 상품 수정시간
}
