// AmountFormatter.java
package com.example.ratecalculation;

import java.text.DecimalFormat;

public class AmountFormatter {
    private static final DecimalFormat df = new DecimalFormat("0.000");
    
    public static String toString(AmountCalculator calculator) {
        StringBuilder result = new StringBuilder();
        
        // Display any warnings first
        String warnings = calculator.getWarnings();
        if (!warnings.isEmpty()) {
            result.append(warnings).append("\n");
        }
        
        // Display the final values (after any corrections)
        result.append("Monthly Saving Amount: ").append(String.format("%.2f%n", 
            calculator.getSavingAmount()));
        result.append("Annual Interest Rate (percent): ").append(String.format("%.1f%%%n", 
            calculator.getAnnualInterestRate()));
        result.append("Number of Months: ").append(calculator.getNumberOfMonths()).append("\n\n");
        
        result.append("Months    Amount Value\n");
        
        // Calculate and format monthly values
        double monthlyRate = calculator.getAnnualInterestRate() / 1200;
        double total = 0;
        
        for (int i = 0; i <= calculator.getNumberOfMonths(); i++) {
            result.append(String.format("%-10d%s%n", i, df.format(total)));
            total = (total + calculator.getSavingAmount()) * (1 + monthlyRate);
        }
        
        return result.toString();
    }
}
