package org.sid.bank_account_service.service;

import jakarta.transaction.Transactional;
import org.sid.bank_account_service.dto.BankAccountReponseDTO;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.enums.AccountTYpe;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
   @Autowired
   private BankAccountRepository bankAccountRepository;
   private AccountMapper accountMapper;
   @Autowired
    @Override
    public BankAccountReponseDTO addAccount(BankAccountRequestDTO bankAccountDto) {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDto.getType())
                .createAt(new Date())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountReponseDTO bankAccountReponseDTO =accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountReponseDTO;
   }
}
