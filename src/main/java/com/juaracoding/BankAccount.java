package com.juaracoding;

public class BankAccount {

    int accountNumber;
    String name;
    double amount;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccount(int accountNumber, String name, double amount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.amount = amount;
    }

    public double deposit(double amount) {
        this.amount = this.amount + amount;
        System.out.println(amount + " deposited");
        return this.amount;
    }

    public double withdraw(double amount) throws InsufficientBalanceException {
        if (this.amount < amount) {
            throw new InsufficientBalanceException("Insufficient Balance");
        } else {
            this.amount -= amount;
            System.out.println(amount + " withdrawn");
        }
        return this.amount;
    }

    public void checkBalance() {
        System.out.println("Balance is: " + amount);
    }

    public void display() {
        System.out.println(accountNumber + " " + name + " " + amount);
    }


}
