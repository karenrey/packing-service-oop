package shipment.air;

import shipment.Shipping;

public interface AirShipping extends Shipping {

    @Override
    default String getFolioPrefix() {
        return "A-";
    }

    @Override
    default void printOtherStages() {
        singleStringPrinter.print("- Putting package in a plane");
        singleStringPrinter.print("- Flying to destination");
        singleStringPrinter.print("- Delivering to the destination office");
    }
}
