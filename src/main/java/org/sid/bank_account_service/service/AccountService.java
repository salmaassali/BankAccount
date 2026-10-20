package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.BankAccountReponseDTO;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.entities.BankAccount;

public interface AccountService {
     BankAccountReponseDTO addAccount(BankAccountRequestDTO bankAccountDto);
    }


