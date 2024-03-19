package com.libraverse.accountservice.service.account;

import com.libraverse.accountservice.models.account.AccountCreateRequest;
import com.libraverse.accountservice.models.account.AccountUpdateRequest;
import com.libraverse.accountservice.entity.Account;

import java.util.List;

public interface AccountService {

    Account findById(String account_id);
    Account save(AccountCreateRequest account);
    List<Account> findAll();
    Account update(String account_id, AccountUpdateRequest accountDto);
    void delete(String account_id);
}
