package com.practice.test.bootendtoend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountTypeId;
    private String accountTypeName;
    enum Type{
        CHECKINGACCOUNT,
        LOANACCOUNT,
        SAVINGACCOUNT
    }
    public Type getAccountType(String accountTypeName){
        if(accountTypeName.equalsIgnoreCase("CheckingAccount" ) ){
             return Type.CHECKINGACCOUNT;
        }else if( accountTypeName.equalsIgnoreCase("LoanAccount")){
            return Type.LOANACCOUNT;
        }
        else return Type.SAVINGACCOUNT;
    }
}
