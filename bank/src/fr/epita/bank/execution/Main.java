package fr.epita.bank.execution;

import fr.epita.bank.datamodel.*;

import java.util.Scanner;

/**
 * this is the main launcher of this application
 */
public class Main {

    public static final double COMMISSION_RATE = 0.01;
    public static double test;

    public static void main(String[] args) {
        System.out.println("Welcome to the bank application!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ticker name of the stock you want to define");
        String tickerName = scanner.nextLine();
        //1. initialize GOLD stock
        Stock stock = new Stock();
        stock.setTicker(tickerName);
        stock.setCurrentPrice(34000.0);

        //2. initialize customer
        Customer customer = new Customer("123456789", "John");

        //3. initialize account
        InvestmentAccount investmentAccount = new InvestmentAccount();
        investmentAccount.setCustomer(customer);
        investmentAccount.setBalance(100000.0);
        investmentAccount.setAccountNumber("123456789");

        //4. create an order to buy 1 unit of GOLD
        Double currentPrice = stock.getCurrentPrice();
        int quantity = 1;
        double value = currentPrice * quantity;
        StockOrder order = new StockOrder();
        order.setStock(stock);
        order.setInvestmentAccount(investmentAccount);
        order.setQuantity(quantity);
        order.setPrice(currentPrice);
        order.setCommission(value * COMMISSION_RATE);
        investmentAccount.setBalance(investmentAccount.getBalance() - value - order.getCommission());

        //5. check and display the balance of the account
        System.out.println("final balance:");
        System.out.println(investmentAccount.getBalance());

        //===


        System.out.println("Savings Account Balance");
        Customer bob = new Customer();
        bob.setName("Bob");

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setCustomer(bob);
        savingsAccount.setBalance(10000.0);
        savingsAccount.setAccountNumber("987654321");
        savingsAccount.setInterestRate(0.05);

        Double currentBalance = savingsAccount.getBalance();
        Double gain = currentBalance * savingsAccount.getInterestRate();
        savingsAccount.setBalance(currentBalance + gain);

        System.out.println("final balance:" + savingsAccount.getBalance());


        scanner.close();


    }
}
