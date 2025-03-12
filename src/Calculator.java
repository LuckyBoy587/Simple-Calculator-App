import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first operand: ");
            double operand1 = scanner.nextDouble();

            System.out.print("Enter second operand: ");
            double operand2 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            scanner.close();
            double result = evaluate(operand1, operand2, operator);
            System.out.println("The result is: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double evaluate(double operand1, double operand2, char operator) {
        if (operator == '/' && operand2 == 0)
            throw new ArithmeticException("Cannot divide by zero");
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}