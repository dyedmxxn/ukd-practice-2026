import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Flight> flightsDb = new ArrayList<>();
        FlightControl controller = new FlightControl(flightsDb);
        controller.addFlight(new Flight("PS034", "Airbus A320", "Лондон", "Щопонеділка"));
        controller.addFlight(new Flight("BA123", "Boeing 737", "Київ", "Щоденно"));
        controller.addFlight(new Flight("LH777", "Boeing 777", "Берлін", "По вихідних"));
        controller.addFlight(new Flight("RY404", "Boeing 737", "Варшава", "Щосереди"));

        String menu = """
                \n========= МЕНЮ =========
                [0] - Вийти;
                [1] - Показати всі рейси;
                [2] - Відсортувати рейси за номером;
                [3] - Знайти рейси за літаком;
                [4] - Додати новий рейс;
                [5] - Видалити рейс;
                [6] - Додати пасажирський рейс;
                [7] - Потенційна виручка всіх пасажирських рейсів;\n
                """;

        int answer;
        do {
            System.out.print(menu);
            answer = intInput("Оберіть опцію: ", scn);

            switch (answer) {
                case 1:
                    System.out.println("\n========= Всі рейси =========");
                    controller.printFlights();
                    break;
                case 2:
                    System.out.println("\n========= Сортування (за номером) =========");
                    controller.sortByID();
                    break;
                case 3:
                    System.out.print("Введіть тип літака для пошуку (наприклад, Boeing 737): ");
                    String model = scn.nextLine();
                    System.out.println("\n========= Результати пошуку =========");
                    controller.searchFlight(model);
                    break;
                case 4:
                    System.out.println("\n========= Створення нового рейсу =========");
                    System.out.print("Введіть номер рейсу: ");
                    String id = scn.nextLine();
                    System.out.print("Введіть модель літака: ");
                    String plane = scn.nextLine();
                    System.out.print("Введіть напрямок руху: ");
                    String destination = scn.nextLine();
                    System.out.print("Введіть періодичність вильоту: ");
                    String schedule = scn.nextLine();

                    Flight newFlight = new Flight(id, plane, destination, schedule);
                    controller.addFlight(newFlight);
                    System.out.println("\nРейс успішно додано до бази даних!");
                    break;
                case 5:
                    System.out.println("\n========= Видалення рейсу =========");
                    System.out.print("Введіть номер рейсу: ");
                    String removeID = scn.nextLine();
                    controller.removeFlight(removeID);
                    break;
                case 6:
                    System.out.println("\n========= Створення пасажирського рейсу =========");
                    System.out.print("Введіть номер рейсу: ");
                    String pId = scn.nextLine();
                    System.out.print("Введіть модель літака: ");
                    String pPlane = scn.nextLine();
                    System.out.print("Введіть напрямок руху: ");
                    String pDestination = scn.nextLine();
                    System.out.print("Введіть періодичність вильоту: ");
                    String pSchedule = scn.nextLine();

                    int capacity = intInput("Введіть місткість літака(чол.): ", scn);
                    double price = doubleInput("Введіть ціну квитка: ", scn);

                    PassengerFlight newPassengerFlight = new PassengerFlight(pId, pPlane, pDestination, pSchedule, capacity, price);
                    controller.addFlight(newPassengerFlight);

                    System.out.println("\nПасажирський рейс успішно додано до загальної бази даних!");
                    break;
                case 7:
                    System.out.println("\n========= Потенційна виручка всіх пасажирських рейсів =========");
                    controller.revenueTable();
            }
        } while (answer != 0);

        System.out.println("\nРоботу програми завершено.");
    }

    private static int intInput(String text, Scanner scn) {
        int num;
        while (true) {
            try {
                System.out.print(text);
                num = scn.nextInt();
                scn.nextLine();
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
                scn.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Ви можете ввести тільки число!");
                scn.next();
            }
        }
    }
}