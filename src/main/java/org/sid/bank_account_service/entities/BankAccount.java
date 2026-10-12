package org.sid.bank_account_service.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.enums.AccountTYpe;
@Entity
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountTYpe type;
}
