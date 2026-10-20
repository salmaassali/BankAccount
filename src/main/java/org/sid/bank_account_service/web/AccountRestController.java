package org.sid.bank_account_service.web;

import org.sid.bank_account_service.dto.BankAccountReponseDTO;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.sid.bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
private AccountService accountService;
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(() ->new RuntimeException(String.format("Account not found")));
    }
    @PostMapping("/bankAccounts")
    public BankAccountReponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){

        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}") // Added leading slash
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));


        if (bankAccount.getBalance() != null) {
            account.setBalance(bankAccount.getBalance());
        }
        if (bankAccount.getCreateAt() != null) {
            account.setCreateAt(new Date());
        }
        if (bankAccount.getType() != null) {
            account.setType(bankAccount.getType());
        }
        if (bankAccount.getCurrency() != null) {
            account.setCurrency(bankAccount.getCurrency());
        }
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
