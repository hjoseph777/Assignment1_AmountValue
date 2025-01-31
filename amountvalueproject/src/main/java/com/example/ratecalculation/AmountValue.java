package com.example.ratecalculation;

// AmountValue.java - Main class to calculate and display growth of savings with compound interest

import java.util.Scanner;
import java.text.DecimalFormat;

public class AmountValue {
    private double monthlyAmount;
    private double annualInterestRate;
    private int numberOfMonths;
    private static final DecimalFormat df = new DecimalFormat("0.000");

    public AmountValue(double amount, double rate, int months) {
        setMonthlyAmount(amount);
        setAnnualInterestRate(rate);
        setNumberOfMonths(months);
    }

    public void setMonthlyAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Monthly amount must be positive");
        }
        this.monthlyAmount = amount;
    }

    public void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.annualInterestRate = rate;
    }

    public void setNumberOfMonths(int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Number of months must be positive");
        }
        this.numberOfMonths = months;
    }

    private double calculateMonthlyValue(int month) {
        double monthlyRate = annualInterestRate / 1200; // Convert to monthly decimal
        double total = 0;
        
        for (int i = 0; i <= month; i++) {
            total = (total + monthlyAmount) * (1 + monthlyRate);
        }
        
        return total;
    }

    public void displayGrowthTable() {
        // Display the values (showing 0 for any negative inputs)
        System.out.printf("\nMonthly Saving Amount: %.2f%n", monthlyAmount <= 0 ? 0.00 : monthlyAmount);
        System.out.printf("Annual Interest Rate (percent): %.1f%%%n", annualInterestRate < 0 ? 0.0 : annualInterestRate);
        System.out.printf("Number of Months: %d%n%n", numberOfMonths <= 0 ? 0 : numberOfMonths);
        
        System.out.println("Months    Amount Value");
        System.out.println("0         0.000");
        
        for (int i = 1; i <= numberOfMonths; i++) {
            System.out.printf("%d         %s%n", i, df.format(calculateMonthlyValue(i)));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean hasError = false;
        
        try {
            System.out.println("Enter amount, interest rate, and number of months:");
            double amount = scanner.nextDouble();
            double rate = scanner.nextDouble();
            int months = scanner.nextInt();

            AmountValue calculator = new AmountValue(amount, rate, months);
            calculator.displayGrowthTable();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Create calculator with original values even if negative
            AmountValue calculator = new AmountValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
            calculator.displayGrowthTable();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
