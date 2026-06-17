import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        int[][] matrix = createMatrix(rnd, scn);

        System.out.printf("Створена матриця цілих чисел: \n");
        printMatrix(matrix);

        int resultSum = sum(matrix);
        int resultCount = count(matrix);

        System.out.printf("\nСума елементів матриці, які знаходяться під головною діагоналлю і на ній: %d\n", resultSum);
        System.out.printf("Кількість елементів матриці, які знаходяться під головною діагоналлю і на ній: %d\n", resultCount);
    }

    private static int[][] createMatrix(Random rnd, Scanner scn) {
        int n;
        do {
            n = intInput("Введіть розмір матриці(n<=12): ", scn);
        } while(n > 12 || n < 1);

        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = rnd.nextInt(0, 101);
            }
        }
        return matrix;
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int sum(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j <= i; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    private static int count(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j <= i; j++) {
                count++;
            }
        }

        return count;
    }
}