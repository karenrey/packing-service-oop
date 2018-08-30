package shipment.land;

import java.util.Random;

public interface LandShipping {

    String getMode();

    String getDeliveryTime();

    default void printFolio() {
        System.out.println("- Folio number: L-" + new Random().nextInt(1000000));
        System.out.println("\n");
    }

    default void printStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
        System.out.println("- Receiving package at destination office");
    }
}
