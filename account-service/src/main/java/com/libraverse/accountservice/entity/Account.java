package com.libraverse.accountservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
@Entity
@Table(name="account")
@DynamicUpdate
public class Account implements Serializable {

    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id", nullable = false)
    private String id;

    @Setter
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "surname", nullable = false)
    private String surname;

    @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


}
