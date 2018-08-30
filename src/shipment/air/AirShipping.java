package shipment.air;

import java.util.Random;

public interface AirShipping {

    String getMode();

    String getDeliveryTime();

    default void printFolio() {
        System.out.println("- Folio number: A-" + new Random().nextInt(1000000));
        System.out.println("\n");
    }

    default void printStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
        System.out.println("- Receiving package at destination office");
    }
}
