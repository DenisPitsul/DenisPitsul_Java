package task1;

import java.util.Scanner;

public class UserInteraction {

    private final Exercise exercise;
    private final Scanner scanner;

    public UserInteraction() {
        this.exercise = new Exercise();
        this.scanner = new Scanner(System.in);
    }

    public void openMenuForSubTask1() {
        try {
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(scanner.nextLine());
            exercise.sayHelloIfNumberGraterThan7(number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid character. You need to input number");
            openMenuForSubTask1();
        }
    }

    public void openMenuForSubTask2() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (name.matches("[a-zA-Z]+")) {
            exercise.sayHelloJohnOrOutputMassage(name);
        } else {
            System.out.println("Name can contains only letters.");
            openMenuForSubTask2();
        }
    }

    public void openMenuForSubTask3() {
        int length = getArrayLengthFromCommandLine();
        int[] array = getArrayFromCommandLine(length);
        exercise.outputArrayElementsThatAreMultiplesOfNumber3(array);
    }

    private int getArrayLengthFromCommandLine() {
        try {
            System.out.println("Enter the length of the array: ");
            int length = Integer.parseInt(scanner.nextLine());
            if (length <= 0) {
                System.out.println("Invalid length. Please enter a positive integer.");
                return getArrayLengthFromCommandLine();
            }
            return length;
        } catch (NumberFormatException e) {
            System.out.println("Invalid length. Please enter a positive integer.");
            return getArrayLengthFromCommandLine();
        }
    }

    private int[] getArrayFromCommandLine(int length) {
        int[] array = new int[length];
        System.out.println("Enter array elements:");
        for (int i = 0; i < length; i++) {
            while (true) {
                System.out.print("Element " + (i + 1) + ": ");
                try {
                    array[i] = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
        }
        return array;
    }
}
