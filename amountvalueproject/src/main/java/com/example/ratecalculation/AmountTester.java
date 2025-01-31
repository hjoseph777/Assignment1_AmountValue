// AmountTester.java
package com.example.ratecalculation;

import java.util.Scanner;

public class AmountTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter amount, interest rate, and number of months:");
        double amount = input.nextDouble();
        double rate = input.nextDouble();
        int months = input.nextInt();
        
        AmountCalculator calculator = new AmountCalculator(amount, rate, months);
        System.out.println(AmountFormatter.toString(calculator));
        
        input.close();
    }
}
