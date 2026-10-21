package app;

import model.BankAccount;
import command.DepositCommand;
import command.WithdrawCommand;
import command.TransferCommand;
import command.CheckBalanceCommand;
import invoker.BankSystem;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(
                "Samuel Santos", "2000", 456.0);

        BankAccount account2 = new BankAccount(
                "Luis Berger", "2001", 399.0);

        BankSystem bankingSystem = new BankSystem();

        System.out.println("Bank system");

        System.out.println("\n Deposit");
        bankingSystem.executeCommand(new DepositCommand(account1, 200.0));

        System.out.println("\n Withdraw");
        bankingSystem.executeCommand(
                new WithdrawCommand(account1, 190.0));

        System.out.println("\n Transfer");
        bankingSystem.executeCommand(
                new TransferCommand(account1, account2, 154.0));

        System.out.println("\n Status account");
        bankingSystem.executeCommand(
                new CheckBalanceCommand(account1));

        System.out.println("\n Check account");
        bankingSystem.executeCommand(
                new CheckBalanceCommand(account2));

        System.out.println("\n Undo changes");
        bankingSystem.undoLastCommand();

        System.out.println("\n Satdistics");
        bankingSystem.executeCommand(
                new CheckBalanceCommand(account1));

        bankingSystem.executeCommand(
                new CheckBalanceCommand(account2));
    }

}