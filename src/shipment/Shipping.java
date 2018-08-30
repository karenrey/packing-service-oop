package shipment;

import java.util.Random;

public interface Shipping {

    String getMode();

    String getDeliveryTime();

    default void printFolio() {
        System.out.println("- Folio number: " + getFolioPrefix() + new Random().nextInt(1000000));
        System.out.println("\n");
    }

    String getFolioPrefix();

    default void printStages() {
        printInitialStages();
        printOtherStages();
        printFinalStages();
    }

    default void printInitialStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
    }

    void printOtherStages();

    default void printFinalStages() {
        System.out.println("- Receiving package at destination office");
    }
}
