import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        System.out.printf("Введіть свій ПІБ: ");
        String fullName = scn.nextLine();

        String initialsResult = initials(fullName);
        System.out.printf("Ініціали: %s\n", initialsResult);

        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        int n = rnd.nextInt(2, 101);
        String generatedString = generateString(n, rnd);
        System.out.printf("Випадковий рядок довжиною, що не перевищує n(%d): %s\n", n, generatedString);
        countChar(generatedString);
    }

    private static String initials(String fullName) {
        String[] words = fullName.split("\\s+");
        if(words.length == 3) {
            String initials = "%c. %c. %c.".formatted(words[0].charAt(0), words[1].charAt(0), words[2].charAt(0));
            return initials;
        }
        else {
            return "Неправильно введений ПІБ!";
        }
    }

    private static String generateString(int n, Random rnd) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append("%c".formatted(rnd.nextInt(33, 127)));
        }
        return sb.toString();
    }

    private static void countChar(String text) {
        ArrayList<Integer> plusIndexes = new ArrayList<>();
        ArrayList<Integer> multIndexes = new ArrayList<>();
        int plusCount = 0;
        int multCount = 0;

        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '+') {
                plusCount++;
                plusIndexes.add(i + 1);
            }
            if(text.charAt(i) == '*') {
                multCount++;
                multIndexes.add(i + 1);
            }
        }

        if(plusCount > 0) {
            System.out.printf("\nЗнак \"+\" зустрічається у рядку %d раз\n", plusCount);
            System.out.printf("Позиція(-ї) знаку у рядку: %s\n", plusIndexes.toString());
        }
        else {
            System.out.printf("\nЗнак \"+\" у рядку відсутній\n");
        }

        if(multCount > 0) {
            System.out.printf("\nЗнак \"*\" зустрічається у рядку %d раз\n", multCount);
            System.out.printf("Позиція(-ї) знаку у рядку: %s\n", multIndexes.toString());
        }
        else {
            System.out.printf("\nЗнак \"*\" у рядку відсутній\n");
        }
    }
}