// AmountCalculator.java
package com.example.ratecalculation;

public class AmountCalculator {
    private double savingAmount;
    private double annualInterestRate;
    private int numberOfMonths;
    private StringBuilder warnings = new StringBuilder();

    // Constructor added here
    public AmountCalculator(double amount, double rate, int months) {
        setSavingAmount(amount);
        setAnnualInterestRate(rate);
        setNumberOfMonths(months);
    }

    public void setSavingAmount(double amount) {
        if (amount < 0) {
            warnings.append("Warning: Negative amount detected. Setting amount to 0.\n");
            this.savingAmount = 0;
        } else {
            this.savingAmount = amount;
        }
    }

    public void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            warnings.append("Warning: Negative interest rate detected. Setting rate to 0.\n");
            this.annualInterestRate = 0;
        } else {
            this.annualInterestRate = rate;
        }
    }

    public void setNumberOfMonths(int months) {
        if (months < 0) {
            warnings.append("Warning: Negative months detected. Setting months to 0.\n");
            this.numberOfMonths = 0;
        } else {
            this.numberOfMonths = months;
        }
    }

    public String getWarnings() {
        return warnings.toString();
    }

    // Getters
    public double getSavingAmount() { return savingAmount; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public int getNumberOfMonths() { return numberOfMonths; }
}

