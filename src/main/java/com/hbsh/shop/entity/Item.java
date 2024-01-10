package com.hbsh.shop.entity;

import com.hbsh.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name= "item")
@Getter
@Setter
@ToString
public class Item {
    @Id
    @Column(name = "item_id")
//    Jpa 구현체가 자동으로 id의 값을 생성
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 상품 코드
//    not null, null을 허용하지 않음, 길이는 50
    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명
    @Column(name = "price", nullable = false)
    private int price; // 가격
    @Column(nullable = false)
    private int stockNumber; //재고 수량
    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태
    private LocalDateTime regTime; // 상품 등록시간
    private LocalDateTime updateTime; // 상품 수정시간
}
