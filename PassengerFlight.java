public class PassengerFlight extends Flight {
    private int passengerCapacity;
    private double ticketPrice;

    public PassengerFlight(String flightID, String planeModel, String flightDestination, String raceSchedule, int passengerCapacity, double ticketPrice) {
        super(flightID, planeModel, flightDestination, raceSchedule);
        this.passengerCapacity = passengerCapacity;
        this.ticketPrice = ticketPrice;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double calculateMaxRevenue() {
        return passengerCapacity * ticketPrice;
    }

    @Override
    public String flightInfo() {
        String baseInfo = super.flightInfo().replace("\n", "");
        return "%s. Місткість: %d чол., Ціна квитка: %.2f грн\n".formatted(baseInfo, passengerCapacity, ticketPrice);
    }
}
