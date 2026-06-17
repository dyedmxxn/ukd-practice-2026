public class Flight {
    private String flightID;
    private String planeModel;
    private String flightDestination;
    private String raceSchedule;

    public Flight(String flightID, String planeModel, String flightDestination, String raceSchedule) {
        this.flightID = flightID;
        this.planeModel = planeModel;
        this.flightDestination = flightDestination;
        this.raceSchedule = raceSchedule;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public String getRaceSchedule() {
        return raceSchedule;
    }

    public void setRaceSchedule(String raceSchedule) {
        this.raceSchedule = raceSchedule;
    }

   public String flightInfo() {
       return "Рейс %s (напрямок: %s). Літак: %s, розклад: %s\n".formatted(flightID, flightDestination, planeModel, raceSchedule);
   }
}
