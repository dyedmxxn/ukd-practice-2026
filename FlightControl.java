import java.util.ArrayList;
import java.util.Comparator;

public class FlightControl {
    private ArrayList<Flight> db;

    public FlightControl(ArrayList<Flight> db) {
        this.db = db;
    }

    public void addFlight(Flight flight) {
        db.add(flight);
    }

    public void removeFlight(String searchedID) {
        boolean found = false;
        for(Flight flight : db) {
            if(flight.getFlightID().equalsIgnoreCase(searchedID)) {
                db.remove(flight);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.printf("Рейсів з таким номером не знайдено\n");
        }
    }

    public void printFlights() {
        for(Flight flight : db) {
            System.out.printf("%s", flight.flightInfo());
        }
    }

    public void sortByID() {
        db.sort(Comparator.comparing(Flight::getFlightID));
        printFlights();
    }

    public void searchFlight(String searchedModel) {
        boolean found = false;
        for(Flight flight : db) {
            if(flight.getPlaneModel().equalsIgnoreCase(searchedModel)) {
                System.out.printf("%s", flight.flightInfo());
                found = true;
            }
        }

        if(!found) {
            System.out.printf("Рейсів з таким літаком не знайдено\n");
        }
    }

    public void revenueTable() {
        boolean found = false;
        for(Flight flight : db) {
            if(flight instanceof PassengerFlight) {
                System.out.printf("Потенційна виручка рейсу %s літака %s: %.2f грн\n", flight.getFlightID(), flight.getPlaneModel(), ((PassengerFlight) flight).calculateMaxRevenue());
                found = true;
            }
        }

        if(!found) {
            System.out.printf("У списку всіх рейсів немає пасажирських, порахувати потенційну виручку неможливо!\n");
        }
    }
}
