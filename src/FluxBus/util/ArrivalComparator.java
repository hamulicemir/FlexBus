package FluxBus.util;

import FluxBus.entities.Busride;
import FluxBus.provided.DateTime;

import java.util.Comparator;

public class ArrivalComparator implements Comparator<Busride> {

    public ArrivalComparator(){}

    @Override
    public int compare(Busride o1, Busride o2) {
        if(o1 != null && o2 != null)
            return o1.getArrival().compareTo(o2.getArrival());
        else
            throw new IllegalArgumentException();
    }
}
