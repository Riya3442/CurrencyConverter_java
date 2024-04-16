import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("Select base currency:");
        System.out.println("1. USD (United States Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound Sterling)");
        System.out.println("4. INR (Indian Rupee)");
        System.out.print("Enter your choice: ");
        int baseCurrencyChoice = scanner.nextInt();

        System.out.println("Select target currency:");
        System.out.println("1. USD (United States Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound Sterling)");
        System.out.println("4. INR (Indian Rupee)");
        System.out.print("Enter your choice: ");
        int targetCurrencyChoice = scanner.nextInt();

        System.out.print("Enter amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Get exchange rate from API
        double exchangeRate = getExchangeRate(baseCurrencyChoice, targetCurrencyChoice);

        // Convert amount
        double convertedAmount = amountToConvert * exchangeRate;

        // Display result
        String targetCurrencySymbol = getCurrencySymbol(targetCurrencyChoice);
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrencySymbol);

        scanner.close();
    }

    public static double getExchangeRate(int baseCurrencyChoice, int targetCurrencyChoice) {
        // For simplicity, let's assume we are using a mock API to fetch exchange rates.
        // In a real-world scenario, you would call an actual API.
        double[][] exchangeRates = {
                {1.0, 0.89, 0.76, 75.09}, // USD
                {1.12, 1.0, 0.85, 84.18},  // EUR
                {1.31, 1.18, 1.0, 98.89},  // GBP
                {0.013, 0.012, 0.011, 1.0} // INR
        };
        return exchangeRates[baseCurrencyChoice - 1][targetCurrencyChoice - 1];
    }

    public static String getCurrencySymbol(int currencyChoice) {
        switch (currencyChoice) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            case 3:
                return "GBP";
            case 4:
                return "INR";
            default:
                return "";
        }
    }
}