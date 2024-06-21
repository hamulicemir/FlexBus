package FluxBus.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import FluxBus.entities.*;
import FluxBus.provided.*;
import FluxBus.util.*;

/**
 * Fix bus management (FluxBus) system demo application
 *
 * @author TeM
 */
public class Main {
    

    /**
     * Prints all bus rides.
     *
     * @param rides the bus rides to print
     * @ProgrammingProblem.Hint provided
     */
    public static void print(List<Busride> rides) {
        System.out.println("--- Listing Bus Rides");
        for (Busride f : rides)
            System.out.println(f + "\n");
        System.out.printf("--- %d bus rides listed%n%n", rides.size());
    }


    /**
     * creates some demo data
     *
     * @return the demo data.
     * @ProgrammingProblem.Hint provided
     */
    public static List<Busride> init() {

        // ---------------- buses
        List<Bus> buses = new LinkedList<>();
        buses.add(new Bus("W-123", 56));
        buses.add(new Bus("BL-666", 63));
        buses.add(new Bus("BP-ACAB2", 75));

        // ---------------- passengers
        List<Person> passengers = new LinkedList<>();
        passengers.add(new Person("John", "Doe", "AT00004711"));
        passengers.add(new Person("Jane", "Doe", "AT00000815"));
        passengers.add(new Person("John", "Jackson", "US00004711"));
        passengers.add(new Person("Jack", "Doe", "UK00000007"));
        passengers.add(new Person("Jack", "Johnson", "DE00004711"));

        // ---------------- drivers
        List<Person> drivers = new LinkedList<>();
        drivers.add(new Person("Rip", "Riley", "ISIS666"));
        drivers.add(new Person("Cheryl", "Tunt", "ISIS456"));
        drivers.add(new Person("Lana", "Kane", "ISIS001"));

        // ---------------- bus rides
        List<Busride> rides = new LinkedList<>();
        rides.add(new StandardRide("RT55X", "Vienna", "Budapest", new DateTime(2018, 06, 25, 6, 30),
                new DateTime(2018, 06, 25, 10, 55), false));
        rides.add(new Charter("AS34X", "Vienna", "Brno", new DateTime(2018, 06, 23, 6, 30),
                new DateTime(2018, 06, 23, 8, 55)));
        rides.add(new Charter("ACAB-3", "Zuerich", "Vienna", new DateTime(2018, 05, 25, 6, 30),
                new DateTime(2018, 05, 25, 20, 13)));
        rides.add(new Charter("ABBA4E", "Vienna", "Athen", new DateTime(2018, 07, 25, 4, 30),
                new DateTime(2018, 07, 26, 23, 20)));
        rides.add(new Charter("BRMC666", "Madrid", "Vienna", new DateTime(2018, 06, 28, 18, 30),
                new DateTime(2018, 06, 30, 06, 00)));
        rides.add(new StandardRide("I8NY", "Vienna", "Paris", new DateTime(2018, 06, 28, 21, 00),
                new DateTime(2018, 06, 29, 15, 05), true));
        rides.add(new StandardRide("I8NY", "Vienna", "Paris", new DateTime(2018, 06, 1, 21, 00),
                new DateTime(2018, 06, 2, 15, 05), true));

        Busride f;

        // ---------------- set up ride
        f = rides.get(0).setVehicle(buses.get(0));
        f.setDriver(drivers.get(0));
        // list passengers
        f.add(passengers.get(0));
        f.add(passengers.get(1));
        f.add(passengers.get(2));
        f.add(passengers.get(3));


        // ---------------- set up ride
        f = rides.get(1).setVehicle(buses.get(1));
        f.add(passengers.get(1));
        f.add(passengers.get(2));
        f.add(passengers.get(3));
        f.setDriver(drivers.get(2));


        // ---------------- set up ride
        f = rides.get(2).setVehicle(buses.get(2));
        f.setDriver(drivers.get(1));
        Person p = new Person(drivers.get(0)); // staff becomes a passenger
        f.add(passengers.get(2));
        f.add(passengers.get(1));
        f.add(passengers.get(3));
        f.add(p);


        // ---------------- set up ride
        f = rides.get(3);
        f.add(passengers.get(2));
        f.add(passengers.get(1));
        f.add(passengers.get(3));

        // ---------------- set up ride
        f = rides.get(4);
        f.add(passengers.get(2));
        f.add(passengers.get(1));
        f.add(passengers.get(3));

        // ---------------- set up ride
        f = rides.get(5);
        f.add(passengers.get(2));
        f.add(passengers.get(1));
        f.add(passengers.get(3));

        return rides;
    }

}
