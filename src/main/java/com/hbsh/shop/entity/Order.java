package com.hbsh.shop.entity;

import com.hbsh.shop.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; //주문일
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; //주문 상태
// cascade = CascadeType.ALL 부모엔티티 영속성 상태를 자식에게 모두 전이
// orphanRemoval = true 주문엔티티(부모엔티티) 부모는 One 자식은 many 에서 주문상품(자식엔티티)를 삭제했을 때
// orderItem 엔티티가 삭제됨
//    여러개의 주문상품은 하나의 주문을 가진다. 즉 하나의 주문은 여러개의 주문상품을 가진다.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

}
