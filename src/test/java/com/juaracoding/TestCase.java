package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase {

    BankAccount bankAccount;
    int accountNumber = 290198;
    String name = "Ihza";
    double amount = 2000;

    @BeforeMethod
    public void setUpAccount() {
        bankAccount = new BankAccount();
        bankAccount.setAccount(accountNumber, name, amount);
    }

    @Test(priority = 1)
    public void deposit() {
        amount = bankAccount.deposit(4000);
        Assert.assertEquals(amount, 6000);
    }

    @Test(priority = 2)
    public void withdraw() {
        try {
            amount = bankAccount.withdraw(3500);
            Assert.assertEquals(amount, 2500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 3)
    public void verifyAccountDetails() {
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setName(name);
        Assert.assertEquals(bankAccount.getAccountNumber(), 290198);
        Assert.assertEquals(bankAccount.getName(), "Ihza");
    }

    @AfterMethod
    public void checkBalance() {
        bankAccount.checkBalance();
    }

    @AfterClass
    public void displayAccount() {
        bankAccount.display();
    }
}
