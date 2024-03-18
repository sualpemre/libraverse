package com.libraverse.accountservice.dto;

import com.libraverse.accountservice.entity.Role;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.SortedSet;
@Getter
@Setter
public class AccountDto {
    private String id;
    private String userName;
    private String name;
    private String surname;
    private String email;
    private boolean isActive;
    private Date lastLogin;
    private Date createdAt;
    private Date updatedAt;
    private Role role;

}

