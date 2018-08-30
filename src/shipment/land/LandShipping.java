package shipment.land;

import shipment.Shipping;

public interface LandShipping extends Shipping {

    @Override
    default String getFolioPrefix() {
        return "L-";
    }

    @Override
    default void printOtherStages() {
        singleStringPrinter.print("- Putting package in a delivery truck");
        singleStringPrinter.print("- Driving to destination");
        singleStringPrinter.print("- Arriving to the destination office");
    }
}
