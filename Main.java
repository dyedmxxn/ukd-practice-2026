public class Main {
    public static void main(String[] args) {
        System.out.printf("========= ЗАВДАННЯ №1 =========\n");
        calculateFunction();
        System.out.printf("\n========= ЗАВДАННЯ №2 =========\n");
        wCalculate(2.8, -0.3, 4, 1, 2, 0.05);

    }

    private static void calculateFunction() {
        double A = Math.PI / 3.0;
        double B = 2.0 * Math.PI / 3.0;
        int M = 20;
        double H = (B - A) / M;

        System.out.printf("%-5s | %-15s | %-15s\n", "i", "Xi", "f(Xi) = cos(Xi)");
        System.out.printf("=========================================\n");

        for(int i = 0; i <= M; i++) {
            double Xi = A + i * H;
            double fx = Math.cos(Xi);
            System.out.printf("%-5d | %-15.5f | %-15.5f\n", i, Xi, fx);
        }
    }

    private static void wCalculate(double a, double b, int c, int fromPoint, int toPoint, double step) {
        long stepCount = Math.round((toPoint - fromPoint) / step);
        double epsilon = 0.0001;

        System.out.printf("%-5s | %-25s | %-5s\n", "Step", "Function used", "Result");
        System.out.printf("===========================================\n");

        for(int i = 0; i <= stepCount; i++) {
            double x = (fromPoint) + i*step;
             if(x < 1.2 - epsilon) { //x < 1.2
                 System.out.printf("%-5.2f | %-25s | %-5.5f\n", x, "ax^2 + bx + c", a*Math.pow(x, 2) + b*x + c);
             }

             else if (Math.abs(x - 1.2) < epsilon) { //x == 1.2
                 System.out.printf("%-5.2f | %-25s | %-5.5f\n", x, "a/x + √(x^2 + 1)", a / x + Math.sqrt(Math.pow(x, 2) + 1));
             }

             else { //x > 1.2
                 System.out.printf("%-5.2f | %-25s | %-5.5f\n", x, "(a + bx) / √(x^2 + 1)", (a + b*x) / Math.sqrt(Math.pow(x, 2) + 1));
             }
        }
    }
}