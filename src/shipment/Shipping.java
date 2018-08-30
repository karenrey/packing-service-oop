package shipment;

import util.NumberedStringPrinter;
import util.SingleStringPrinter;

import java.util.Random;

public interface Shipping {

    String getMode();

    String getDeliveryTime();

    default void printFolio() {
        singleStringPrinter.print("- Folio number: " + getFolioPrefix() + new Random().nextInt(1000000));
        singleStringPrinter.print("\n");
    }

    String getFolioPrefix();

    default void printStages() {
        printInitialStages();
        printOtherStages();
        printFinalStages();
    }

    default void printInitialStages() {
        singleStringPrinter.print("- Receiving package at the origin office");
        singleStringPrinter.print("- Labeling package for shipping");
    }

    void printOtherStages();

    default void printFinalStages() {
        singleStringPrinter.print("- Receiving package at destination office");
    }

    SingleStringPrinter singleStringPrinter = System.out::println;
}
