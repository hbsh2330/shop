package com.hbsh.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
//Auditing 적용
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass //부모클래스 상속받는 자식클래스에게 매핑정보 제공
@Getter
@Setter
public abstract class BaseTimeEntity {
    @CreatedDate // 엔티티가 생성될 때 자동으로 시간 저장
    @Column(updatable = false)
    private LocalDateTime regTime;
    @LastModifiedDate // 엔티티의 값이 변경될 때 자동으로 시간 저장
    private LocalDateTime updateTime;
}
