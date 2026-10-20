package org.sid.bank_account_service.mappers;

import org.sid.bank_account_service.dto.BankAccountReponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountReponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountReponseDTO bankAccountReponseDTO=new BankAccountReponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountReponseDTO);
        return bankAccountReponseDTO;
    }
}
