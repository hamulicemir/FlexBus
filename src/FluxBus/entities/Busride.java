package FluxBus.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import FluxBus.provided.*;

/**
 * A bus ride in the fix bus management system (FluxBus).<br>
 * <p>
 * A bus ride stores information about place and time of departure and arrival
 * as well as the bus and the driver. Both driver and passengers can be added to
 * a bus ride.
 * <p>
 * <p>
 * Bus rides are naturally ordered by ID.
 *
 * @author TeM
 */
public abstract class Busride implements Comparable<Busride>{
    private DateTime arrival;
    private DateTime departure;
    private String destination;
    private Person driver;
    private String origin;
    private Set<Person> passengers = new HashSet<>();
    private String rideID;
    private Bus vehicle;

    public Busride(Busride orig){
        this.arrival = orig.arrival;
        this.departure = orig.departure;
        this.destination = orig.destination;
        this.driver = orig.driver;
        this.origin = orig.origin;
        this.passengers = orig.passengers;
        this.rideID = orig.rideID;
        this.vehicle = orig.vehicle;
    }
    public Busride(String rideID, String origin, String destination, DateTime departure, DateTime arrival){
        setRideID(rideID);
        setOrigin(origin);
        setDestination(destination);
        setDeparture(departure);
        setArrival(arrival);
    }

    public int compareTo(Busride o){
        if(o == null){
            throw new IllegalArgumentException();
        }
        return this.rideID.compareTo(o.rideID);
    }
    private String ensureNonNullNonEmpty(String str) throws IllegalArgumentException{
        if(str != null && !str.isEmpty()){
            return str;
        }
        else
            throw new IllegalArgumentException();
    }

    public boolean add(Person passenger){
        if (passenger != null && !this.passengers.contains(passenger)){
            this.passengers.add(passenger);
            return true;
        }
        return false;
    }

    public final void setArrival(DateTime arrival) {
        this.arrival = new DateTime(arrival);
    }

    public final void setDeparture(DateTime departure) {
        this.departure = new DateTime(departure);
    }

    public final void setDestination(String destination) {
        this.destination = ensureNonNullNonEmpty(destination);
    }

    public final void setDriver(Person driver) {
        if(driver != null)
            this.driver = driver;
    }

    public final void setOrigin(String origin) {
        this.origin = ensureNonNullNonEmpty(origin);
    }

    public final void setRideID(String rideID) {
        this.rideID = ensureNonNullNonEmpty(rideID);
    }

    public Busride setVehicle(Bus vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public DateTime getArrival() {
        return new DateTime(arrival);
    }

    public String getOrigin() {
        return origin;
    }

    public String getRideID() {
        return rideID;
    }

    /**
     * Creates a String representation of this bus ride.<br>
     *
     * @ProgrammingProblem.Hint provided
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%n%5s from %s (%s) to %s (%s)" + " with driver %s and %d passengers " + "<%s> %n%s%n%s",
                rideID, origin, departure, destination, arrival, driver, passengers == null ? 0 : passengers.size(),
                vehicle == null ? "no vehicle" : vehicle.toString(), driver, passengers);
    }

}
