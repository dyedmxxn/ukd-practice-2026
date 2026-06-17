import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        int n = intInput("Введіть розмір матриці: ", scn);
        int[][] matrix = createMatrix(rnd, n);

        System.out.printf("Початкова матриця: \n");
        printMatrix(matrix);

        int[] array = createArray(rnd, n);
        System.out.printf("\nОдновимірний масив: %s\n", Arrays.toString(array));

        rewrite(matrix, array);
        System.out.printf("\nМатриця із перезаписаними значеннями: \n");
        printMatrix(matrix);
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

    private static int[][] createMatrix(Random rnd, int n) {
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = rnd.nextInt(10, 100);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[] createArray(Random rnd, int n) {
        int[] array = new int[n*n];

        for(int i = 0; i < n*n; i++) {
            array[i] = rnd.nextInt(100, 201);
        }
        return array;
    }

    private static void rewrite(int[][] matrix, int[] array) {
        int arrayIndex = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = array[arrayIndex];
                arrayIndex++;
            }
        }
    }
}