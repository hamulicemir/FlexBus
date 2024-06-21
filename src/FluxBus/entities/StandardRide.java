package FluxBus.entities;
import FluxBus.provided.Bus;
import FluxBus.provided.DateTime;

public class StandardRide extends Busride implements Comparable<Busride>{
    private boolean isOvernight;

    public StandardRide(StandardRide ride){
        super(ride);
        this.isOvernight = ride.isOvernight;
    }
    public StandardRide(String rideID, String origin, String destination, DateTime departure, DateTime arrival, boolean overnight){
        super(rideID, origin, destination, departure, arrival);
        this.isOvernight = overnight;
    }

    @Override
    public String toString() {
        return "StandardRide{" +
                "isOvernight=" + isOvernight +
                '}';
    }
}
