package ca.ucalgary.ensf380;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args.length > 0) {
            // process CLI arguments
            String op = args[0]; // extract first arg as the operation to perform
            double num1 = Double.parseDouble(args[1]); // extract second arg as nums to operate on 
            double num2 = Double.parseDouble(args[2]); // extract third arg as nums to operate on
            double result = calcOperation(op, num1, num2); // extracted values are passed to calcOperation which return result
            System.out.println("result: " + result); // print result to console
        } else { 
            // no CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide):");
            String op = scanner.next(); // read operation from user
            System.out.println("Enter your first number: ");
            double num1 = scanner.nextDouble(); // read first num
            System.out.println("Enter your second number: ");
            double num2 = scanner.nextDouble(); // read second num
            double result = calcOperation(op, num1, num2); 
            System.out.println("Result: " + result);
        }
    }
    
    private static double calcOperation(String op, double num1, double num2) {
        switch (op) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide": 
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("error, can't divide by zero");
                }
            default: 
                throw new IllegalArgumentException("invalid operation: " + op);
        }
    }
}
