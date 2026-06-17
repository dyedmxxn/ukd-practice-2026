import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        ArrayList<Double> sequenceResult = calculateSequence(1.0, 4);
        double sum = 0.0;
        for(double num : sequenceResult) {
            sum += num;
        }
        System.out.printf("Сума 5 елементів ряду %s дорівнює %.2f\n", sequenceResult.toString(), sum);

        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        double resultV = calculateV(scn);
        printResult("Значення функції V(x, y, z) дорівнює", resultV);

        System.out.printf("\n========= ЗАВДАННЯ №3 =========\n");
        short randomNumber = (short) rnd.nextInt(1, 32768);
        printDigits(randomNumber);
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

    private static ArrayList<Double> calculateSequence(double A0, int count) {
        ArrayList<Double> sequence = new ArrayList<>();
        sequence.add(A0);
        for(int i = 0; i < count; i++) {
            double current = sequence.get(i);
            sequence.add(current / (current + 1));
        }
        return sequence;
    }

    private static double calculateV(Scanner scn) {
        ArrayList<Double> arguments = getArguments(scn, 3);
        ArrayList<Double> sinArg = new ArrayList<>();
        ArrayList<Double> cosArg = new ArrayList<>();

        for(int i = 0; i < arguments.size(); i++) {
            sinArg.add(Math.sin(arguments.get(i)));
            cosArg.add(Math.cos(arguments.get(i)));
        }

        double maxSin = findMax(sinArg);
        double minCos = findMin(cosArg);

        double V = maxSin / (1.1 + minCos);
        return V;
    }

    private static void printDigits(short randomNumber) {
        String[] digits = Short.toString(randomNumber).split("");
        String result = String.join("  ", digits);
        System.out.printf("Число %d представляє собою послідовність цифр: %s\n", randomNumber, result);
    }

    private static ArrayList<Double> getArguments(Scanner scn, int argumentAmount) {
        ArrayList<Double> arguments = new ArrayList<>();
        for(int i = 0; i < argumentAmount; i++) {
            arguments.add(doubleInput("Введіть аргумент №%d(у форматі x.xx...x): ".formatted(i + 1), scn));
        }
        return arguments;
    }

    private static double findMax(ArrayList<Double> arg) {
        return Collections.max(arg);
    }

    private static double findMin(ArrayList<Double> arg) {
        return Collections.min(arg);
    }

    private static void printResult(String text, double result) {
        System.out.printf("%s: %.2f\n", text, result);
    }
}