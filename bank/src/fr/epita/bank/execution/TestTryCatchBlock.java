package fr.epita.bank.execution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTryCatchBlock {

    public static void main(String[] args) {

        int num2 = 0;
        try (Scanner scanner = new Scanner(System.in);){ //this is a try-catch block, we will discuss it further
            int num1 = scanner.nextInt();
            System.out.println("Input 1 accepted");
            num2 = scanner.nextInt();
            System.out.println("Input 2 accepted");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Entry: " +  e.getMessage());
            e.printStackTrace();
        }

        System.out.println(num2);
    }
}
