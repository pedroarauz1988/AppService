package com.service.pedro.arauz.enums;

public enum AccountType {

    AHORROS("Ahorros"), CORRIENTE("Corriente");

    private String accountType;

    AccountType(String accountType){
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return accountType;
    }
}
