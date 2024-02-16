package task1;

public class Exercise {

    public void sayHelloIfNumberGraterThan7(int number) {
        if (number > 7) {
            System.out.println("Hello");
        }
    }

    public void sayHelloJohnOrOutputMassage(String name) {
        if (name.equals("John")) {
            System.out.println("Hello, John");
        } else {
            System.out.println("There is no such name");
        }
    }

    public void outputArrayElementsThatAreMultiplesOfNumber3(int[] array) {
        System.out.println("Array elements that are multiples of 3:");
        for (int num : array) {
            if (num % 3 == 0) {
                System.out.print(num + " ");
            }
        }
    }
}
