package com.libraverse.accountservice.controller;
import com.libraverse.accountservice.dto.AccountDto;
import com.libraverse.accountservice.entity.Account;
import com.libraverse.accountservice.models.account.AccountCreateRequest;
import com.libraverse.accountservice.models.account.AccountUpdateRequest;
import com.libraverse.accountservice.entity.Role;
import com.libraverse.accountservice.service.account.AccountService;
import com.libraverse.accountservice.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> get(@PathVariable String account_id){
        Account account = accountService.findById(account_id);
        return ResponseEntity.ok(ObjectMapperUtils.map(account, AccountDto.class));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll(){
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(accounts, AccountDto.class));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> registerUser(@RequestBody AccountCreateRequest createModel) {
        if (!createModel.getPassword().equals(createModel.getRe_password())) {
            return ResponseEntity.badRequest().body(null);
        }
        Account account = accountService.save(createModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(account, AccountDto.class));
    }
    @PatchMapping("/{account_id}/update")
    public ResponseEntity<AccountDto> update(@PathVariable String account_id, @RequestBody AccountUpdateRequest updateModel){
        Account account = accountService.update(account_id, updateModel);
        return ResponseEntity.ok(ObjectMapperUtils.map(account, AccountDto.class));
    }

    @DeleteMapping("/{account_id}/delete")
    public void delete(@PathVariable String account_id){
        accountService.delete(account_id);
    }

}
