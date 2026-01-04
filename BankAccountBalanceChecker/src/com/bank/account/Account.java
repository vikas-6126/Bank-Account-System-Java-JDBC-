package com.bank.account;

public class Account {
    private int accNo;
    private String holderName;
    private double balance;

    public Account(int accNo, String holderName, double balance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccNo() { return accNo; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return "Account [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + "]";
    }
}