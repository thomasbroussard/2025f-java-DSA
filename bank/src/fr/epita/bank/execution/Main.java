package fr.epita.bank.execution;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.Stock;

/**
 * this is the main launcher of this application
 */
public class Main {

    public static double test;

    public static void main(String[] args) {
        System.out.println("Hello World");
        Customer customer = new Customer();

        Stock stock = new Stock();
        stock.setTicker("GOLD");

    }
}
