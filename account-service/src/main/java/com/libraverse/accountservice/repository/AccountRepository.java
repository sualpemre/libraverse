package com.libraverse.accountservice.repository;

import com.libraverse.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, String> {
}
