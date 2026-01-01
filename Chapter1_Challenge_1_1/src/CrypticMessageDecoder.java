import java.util.Scanner;


public class CrypticMessageDecoder{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Cryptic Message Decoder ---");
        System.out.print("Enter a positive integer (must have 4 or more digits): ");

        long inputMessage = scanner.nextLong();
        scanner.close();

        double number = (double) inputMessage;

        int numDigits = (int) Math.log10(number) + 1;

        long lastDigit = inputMessage % 10;

        long firstDivisor = (long) Math.pow(10, numDigits - 1);

        long firstDigit = inputMessage / firstDivisor;

        long secondLastDigit = (inputMessage / 10) % 10;
        long secondDivisor = (long) Math.pow(10, numDigits - 2);  
        long secondDigit = (inputMessage / secondDivisor) % 10;

        long product = firstDigit * lastDigit; // 1 * 9 = 9

        long sum = secondDigit + secondLastDigit; // 3 + 7 = 10

        int sumDigits = (sum == 0) ? 1 : (int) Math.log10(sum) + 1;
        long shiftFactor = (long) Math.pow(10, sumDigits);

        long finalCode = (product * shiftFactor) + sum;


        System.out.println("\n--- Decryption Results ---");
        System.out.println("First Digit: " + firstDigit);
        System.out.println("Last Digit: " + lastDigit);
        System.out.println("Second Digit: " + secondDigit);
        System.out.println("Second-Last Digit: " + secondLastDigit);
        System.out.println("Product of First and Last Digits: " + product);
        System.out.println("Sum of Second and Second-Last Digits: " + sum);
        System.out.println("---------------------------------");
        System.out.println("The decrypted code is: " + finalCode);
    }
}
