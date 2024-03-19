package com.libraverse.accountservice.service.account.Impl;

import com.libraverse.accountservice.entity.Account;
import com.libraverse.accountservice.models.account.AccountCreateRequest;
import com.libraverse.accountservice.models.account.AccountUpdateRequest;
import com.libraverse.accountservice.repository.AccountRepository;
import com.libraverse.accountservice.service.account.AccountService;
import com.libraverse.accountservice.utils.ObjectMapperUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Account findById(String account_id){
        Assert.notNull(account_id, "Account id cannot be null");
        return accountRepository.findById(account_id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + account_id));
    }

    @Override
    public Account save(@Validated AccountCreateRequest createModel){
        Account account = ObjectMapperUtils.map(createModel, Account.class);
        String encodedPassword = passwordEncoder.encode(createModel.getPassword());
        createModel.setPassword(encodedPassword);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @Override
    public Account update(String account_id, AccountUpdateRequest updateModel){
        Assert.notNull(account_id, "Account id cannot be null");
        Account account = accountRepository.findById(account_id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + account_id));
        Account x = ObjectMapperUtils.map(updateModel, account);
        System.out.println(x.getName());
        return accountRepository.save(x);
    }

    @Override
    public void delete(String account_id) {
        accountRepository.deleteById(account_id);
    }
}
