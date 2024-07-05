package ca.ucalgary.ensf380;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // use a loop to keep the calculator running until the user exits
        while (true) {
        	// display available options
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
            String operation = scanner.next();
            
            // exit option
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator, thanks!");
                break;
            }

            // check if operation requires 2 inputs
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") &&
                !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") &&
                !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") &&
                !operation.equalsIgnoreCase("factorial") && !operation.equalsIgnoreCase("permutation")) {
                System.out.print("Enter first number: ");	// ask user for two inputs
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;	// store result of the operation
                boolean validOperation = true; // indicator is operation is valid 
                switch (operation.toLowerCase()) { // calculate operation based on which case input chooses 
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

                if (validOperation) {	// display result if operation was valid 
                    System.out.println("Result: " + result);
                }
            } else {
                // operations requiring one input
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                double result = 0; 	// variable to store result
                boolean validOperation = true;
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
                    case "permutation":
                        // permutations require two inputs
                        System.out.print("\nEnter the number of inputs: ");
                        int n = (int)num;
                        System.out.print("\nEnter the number of inputs to choose: ");
                        int r = scanner.nextInt();
                        // check it input is valid
                        if (n >= 0 && r >= 0 && r <= 100 && r <= n) {
                        	// calc and display perms using recursion and iteration
                            System.out.println("Permutation (recursive): " + permRecursive(n, r));
                            System.out.println("Permutation (iterative): " + permIterative(n, r));
                        } else {
                            System.out.println("Invalid input for permutation.");
                        }
                        break;
                    default:
                        validOperation = false;
                        System.out.println("Invalid operation.");
                        break;
                }

                if (validOperation) {	// display result if operation is valid
                    System.out.println("Result: " + result);
                }
            }
        }

        scanner.close();
    }

    // division method, errors when trying to divide by zero
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
    
    // factorial calc with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        long result = factorialHelp(num, num);
        System.out.println("\rCalculating factorial: 100%");
        return result;
    }
    
    // helper method for recursive factorial calc
    private static long factorialHelp(int origNum, int num) {
        if (num <= 1) {
            return 1;
        }
        int progress = (int) (((origNum - num + 1) / (double) origNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelp(origNum, num - 1);
    }

    // permutation using recursion
    public static long permRecursive(int i, int k) {
        if (i == 0) {
            return 1;
        }
        return k * permRecursive(i - 1, r - 1);
    }

    // permutations using iteration
    public static long permIterative(int j, int y) {
        long result = 1;
        for (int i = 0; i < y; i++) {
            result *= (j - i);
        }
        return result;
    }
}
