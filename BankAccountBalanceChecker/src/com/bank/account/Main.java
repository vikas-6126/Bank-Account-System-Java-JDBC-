package com.bank.account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {
            System.out.println("\n=== Bank Account System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account acc = new Account(accNo, name, balance);
                    if (dao.createAccount(acc)) {
                        System.out.println("✅ Account created successfully!");
                    } else {
                        System.out.println("❌ Failed to create account.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int searchAccNo = sc.nextInt();
                    Account found = dao.getAccountByNumber(searchAccNo);

                    if (found != null) {
                        System.out.println("Account Holder: " + found.getHolderName());
                        System.out.println("Balance: ₹" + found.getBalance());
                    } else {
                        System.out.println("❌ Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}