import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        System.out.printf("Після перервірки, програма повернула значення - \"%d\"\n", posOrNeg(scn));
        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        sumAndAvg(scn);
        System.out.printf("\n========= ЗАВДАННЯ №3 =========\n");
        month(scn);
        System.out.printf("\n========= ЗАВДАННЯ №4 =========\n");
        sumAndAvgLooped(scn);
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

    private static int posOrNeg(Scanner scn) {
        double num = doubleInput("Введіть дійсне число(у x.xx...x вигляді): ", scn);
        if (num < 0) {
            return -1;
        }
        else if (num > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static void recursiveInput(Scanner scn, int repeat, ArrayList<Integer> numbers) {
        if(repeat == 0) {
            return;
        }

        int num = intInput("Введіть число: ", scn);
        numbers.add(num);

        recursiveInput(scn, repeat - 1, numbers);
    }

    private static void sumAndAvg(Scanner scn) {
        ArrayList<Integer> numbers = new ArrayList<>();
        recursiveInput(scn, 6, numbers);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Сума 6 введених чисел: %d\n", sum);
        System.out.printf("Середнє арифметичне 6 введених чисел: %.2f\n", sum / (float) numbers.size());
    }

    private static void month(Scanner scn) {
        ArrayList<String> months = new ArrayList<>(List.of("Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень"));
        int number = intInput("Введіть номер місяця(1 - Січень; 2 - Лютий і так далі): ", scn);
        if (number > 0 && number < months.size() + 1) {
            System.out.printf("%s\n", months.get(number - 1));
        }
        else {
            System.out.printf("Не існує місяця з номером %d\n", number);
        }
    }

    private static void sumAndAvgLooped(Scanner scn) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            numbers.add(intInput("Введіть число: ", scn));
        }

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        System.out.printf("Сума 6 введених чисел: %d\n", sum);
        System.out.printf("Середнє арифметичне 6 введених чисел: %.2f\n", sum / (float) numbers.size());
    }
}