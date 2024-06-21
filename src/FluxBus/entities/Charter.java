package FluxBus.entities;

import FluxBus.provided.DateTime;

public class Charter extends Busride implements Comparable<Busride>{
    private double includedMileage;

    public Charter(String rideID, String origin, String destination, DateTime departure, DateTime arrival){
        super(rideID, origin, destination, departure, arrival);
    }

    public double getIncludedMileage() {
        return includedMileage;
    }

    public void setIncludedMileage(double includedMileage)
    {
        if(includedMileage > 0)
            this.includedMileage = includedMileage;
        else{
            throw new IllegalArgumentException("IncludedMileage has to be greater than zero!");
        }
    }

    @Override
    public String toString() {
        return "Charter{" +
                "includedMileage=" + includedMileage +
                '}';
    }
}
