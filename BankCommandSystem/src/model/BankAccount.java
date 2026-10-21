package model;

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(
            String accountHolder,
            String accountNumber,
            double initialBalance) {

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Balance no negative");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit money more than 0");
        }

        balance += amount;

        System.out.println(
                "Deposit done: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawing money should be more than 0 ");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "no funds");
        }

        balance -= amount;

        System.out.println(
                "Withdrawal done: " + amount);
    }

    public void transferTo(
            BankAccount targetAccount,
            double amount) {

        if (targetAccount == null || targetAccount == this) {
            throw new IllegalArgumentException(
                    "Invalid account");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Transfer money should be more than 0");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "No funds to transfer");
        }

        balance -= amount;
        targetAccount.balance += amount;

        System.out.println(
                "Transfer done: " + amount
                + " from " + accountNumber
                + " to " + targetAccount.accountNumber);
    }

    public void checkBalance() {
        System.out.println(
                "Account : " + accountHolder);
        System.out.println(
                "Number of account: " + accountNumber);
        System.out.println(
                "Balance: $" + balance);
    }

}