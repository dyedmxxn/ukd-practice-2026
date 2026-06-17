import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        double[] numbers = createArray(rnd);
        System.out.printf("Створений масив дійсних чисел: %s\n", Arrays.toString(numbers));
        System.out.printf("\n========= ЗАВДАННЯ №1 =========\n");
        double multResult = multEven(numbers);
        System.out.printf("Добуток елементів масиву з парними індексами: %.2f\n", multResult);
        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        double sum = zeroSum(numbers);
        if(!Double.isNaN(sum)) {
            System.out.printf("Сума елементів масиву, розташованих між першим і останнім нульовими елементами: %.2f\n", sum);
        }
    }

    private static double[] createArray(Random rnd) {
        int n = rnd.nextInt(1, 11);
        double[] numbers = new double[n];
        for(int i = 0; i < n; i++) {
            int choice = rnd.nextInt(0, 4);
            if(choice == 0) {
                numbers[i] = 0.0;
            }
            else {
                if(choice == 3) {
                    double num = Math.random() * -10;
                    numbers[i] = Math.round(num * 100.0) / 100.0;
                }
                else {
                    double num = Math.random() * 10;
                    numbers[i] = Math.round(num * 100.0) / 100.0;
                }
            }
        }
        return numbers;
    }

    private static double multEven(double[] array) {
        double mult = 1;
        for(int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                mult = mult * array[i];
            }
        }
        return mult;
    }

    private static double zeroSum(double[] array) {
        int firstZeroIndex = -1;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0.0){
                firstZeroIndex = i;
                break;
            }
        }

        int lastZeroIndex = -1;
        for(int i = array.length - 1; i > -1; i--) {
            if(array[i] == 0.0){
                lastZeroIndex = i;
                break;
            }
        }

        if((firstZeroIndex == lastZeroIndex) && (firstZeroIndex != -1 && lastZeroIndex != -1)) {
            System.out.printf("Не можна знайти суму елементів масиву, " +
                    "розташованих між першим і останнім нульовими елементами," +
                    "оскільки в масиві присутній лише один нульовий елемент!\n");
            return Double.NaN;
        }
        if((firstZeroIndex + 1 == lastZeroIndex)) {
            System.out.printf("Не можна знайти суму елементів масиву, " +
                    "розташованих між першим і останнім нульовими елементами," +
                    "оскільки між першим і останнім нульовими елементами немає інших елементів!\n");
            return Double.NaN;
        }
        if(firstZeroIndex == -1 && lastZeroIndex == -1) {
            System.out.printf("Не можна знайти суму елементів масиву, " +
                    "розташованих між першим і останнім нульовими елементами," +
                    "оскільки в масиві відсутні нульові елементи!\n");
            return Double.NaN;
        }

        double sum = 0;
        for(int i = firstZeroIndex + 1; i < lastZeroIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
}