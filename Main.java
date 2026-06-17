import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        double[] numbers = createArray(scn);
        System.out.printf("\nСтворений масив дійсних чисел: %s\n", Arrays.toString(numbers));
        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        double[] sortedNumbers = selectionSort(numbers);
        System.out.printf("Впорядкований(в порядку зростання) масив дійсних чисел: %s\n", Arrays.toString(sortedNumbers));
        System.out.printf("\n========= ЗАВДАННЯ №3 =========\n");
        System.out.printf("Сума: %.2f | Добуток: %.2f\n", sum(numbers), mult(numbers));
        System.out.printf("Кількість додатніх чисел: %d | Кількість від'ємних чисел: %d\n", countPos(numbers), countNeg(numbers));
        System.out.printf("Середнє арифметичне: %.2f\n", avg(numbers));
    }

    private static int intInput(String text, Scanner scn) {
        int num;
        while (true) {
            try {
                System.out.print(text);
                num = scn.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Ви можете ввести тільки число!");
                scn.next();
            }
        }
    }

    private static double doubleInput(String text, Scanner scn) {
        double num;
        while (true) {
            try {
                System.out.print(text);
                num = scn.nextDouble();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Ви можете ввести тільки число!");
                scn.next();
            }
        }
    }

    private static double[] createArray(Scanner scn) {
        int length;
        do {
            length = intInput("Введіть довжину масиву(до 10): ", scn);
        } while (length > 10 || length <= 0);

        double[] numbers = new double[length];

        for(int i = 0; i < length; i++) {
            double num;
            do {
                num = doubleInput("Введіть дійсне число від 1 до 7(не включно, у форматі х.хх...х): ", scn);
            } while(num <= 1.0 || num >= 7.0);
            numbers[i] = num;
        }
        return numbers;
    }

    private static double[] selectionSort(double[] array) {
        double temp;
        int smallestIndex;
        for(int i = 0; i < array.length; i++) {
            smallestIndex = i;

            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[smallestIndex]){
                    smallestIndex = j;
                }
            }

            temp = array[smallestIndex];
            array[smallestIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    private static double sum(double[] array) {
        double sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static double mult(double[] array) {
        double mult = 1;
        for(int i = 0; i < array.length; i++) {
            mult = mult * array[i];
        }
        return mult;
    }

    private static int countPos(double[] array) {
        int countPos = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > 0.0) {
                countPos++;
            }
        }
        return countPos;
    }

    private static int countNeg(double[] array) {
        int countNeg = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < 0.0) {
                countNeg++;
            }
        }
        return countNeg;
    }

    private static double avg(double[] array) {
        double sum = sum(array);
        double avg = sum / (double) array.length;
        return avg;
    }

}