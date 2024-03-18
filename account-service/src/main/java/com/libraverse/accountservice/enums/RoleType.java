package com.libraverse.accountservice.enums;

import lombok.Getter;

@Getter
public enum RoleType {

    ADMINISTRATOR("ROLE_ADMINISTRATOR"),
    SELLER("ROLE_SELLER"),
    CUSTOMER("ROLE_CUSTOMER");
    private final String name;
    RoleType(String name) {
        this.name = name;
    }

}
