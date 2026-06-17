import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        battle(scn);
        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        multSub(scn);
        System.out.printf("\n========= ЗАВДАННЯ №3 =========\n");
        output();
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

    private static void battle(Scanner scn) {
        System.out.println("Битва під Берестечком відбулася у 1649р.");
        int year = intInput("Який зараз рік? Введіть число: ", scn);
        System.out.printf("З часу битви під Берестечком пройшло %d.\n", year - 1649);
    }

    private static void multSub(Scanner scn) {
        int num1 = intInput("Введіть перше число: ", scn);
        int num2 = intInput("Введіть друге число: ", scn);
        System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
        System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
    }

    private static void output() {
        System.out.printf("====================================\n");
        System.out.printf("%s | %-10s | %-5s | %-10s\n", "№", "Дільниця", "Цех", "Видано");
        System.out.printf("====================================\n");
        System.out.printf("%s | %-10s | %-5s | %-10s\n", "1", "Д15", "Ц9", "27.05.2026");
    }
}