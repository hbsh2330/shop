package com.hbsh.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//회원의 가입정보를 담을 DTO
public class MemberFormDto {
    private String name;
    private String email;
    private String password;
    private String address;
}
