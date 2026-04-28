package storeapp.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerFormValidation {

    static Scanner sc = new Scanner(System.in);

    public static int validateInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine().trim();
                int value = Integer.parseInt(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: debe ingresar un numero entero. Intente de nuevo.");
            }
        }
    }

    public static double validateDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine().trim();
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: debe ingresar un numero decimal (ej: 1500.50). Intente de nuevo.");
            }
        }
    }

    public static String validateString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println(">>> Error: el campo no puede estar vacio. Intente de nuevo.");
        }
    }

    public static boolean validateBoolean(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = sc.nextLine().trim();
                if (input.equalsIgnoreCase("true") || input.equals("1")) return true;
                if (input.equalsIgnoreCase("false") || input.equals("0")) return false;
                System.out.println(">>> Error: ingrese true/false o 1/0. Intente de nuevo.");
            } catch (Exception e) {
                System.out.println(">>> Error inesperado. Intente de nuevo.");
            }
        }
    }
}
