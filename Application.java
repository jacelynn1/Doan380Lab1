package ca.ucalgary.ensf380;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // loop to run program until user wants to exit
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator, thanks!");
                break;
            }

            // operations that require 2 inputs
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") &&
                !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") &&
                !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") &&
                !operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean validOperation = true;
                
                // case switch is used to determine which operation is chosen based on user input
                switch (operation.toLowerCase()) {
                    case "add":
                        result = num1 + num2;
                        break;
                    case "subtract":
                        result = num1 - num2;
                        break;
                    case "multiply":
                        result = num1 * num2;
                        break;
                    case "divide":
                        result = divide(num1, num2);
                        break;
                    case "pow":
                        result = power(num1, num2);
                        break;
                    default:
                        validOperation = false;
                        System.out.println("Invalid operation.");
                        break;
                }

                if (validOperation) {
                    System.out.println("Result: " + result);
                }
            } else {
                // operations requiring one input
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                double result = 0;
                boolean valid = true;
                switch (operation.toLowerCase()) {
                    case "sqrt":
                        result = sqrt(num);
                        break;
                    case "log":
                        result = log(num);
                        break;
                    case "log10":
                        result = log10(num);
                        break;
                    case "sin":
                        result = sin(Math.toRadians(num));
                        break;
                    case "cos":
                        result = cos(Math.toRadians(num));
                        break;
                    case "tan":
                        result = tan(Math.toRadians(num));
                        break;
                    case "factorial":
                        result = factorial((int)num);
                        break;
                    default:
                        valid = false;
                        System.out.println("invalid operation.");
                        break;
                }
                // if operation is valid then print the result
                if (valid) {
                    System.out.println("Result: " + result);
                }
            }
        }

        scanner.close();
    }
    
    // method for division and invalid division entries
    private static double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("error, can't divide by zero");
        }
    }

    // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }
    
    // factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        long result = factorialHelper(num, num);
        System.out.println("\rCalculating factorial: 100%");
        return result;
    }
    
    // helper method for factorial calc with progress delay
    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            return 1;
        }
        // calc progress and update progress bar
        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }
}
