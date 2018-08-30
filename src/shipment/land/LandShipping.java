package shipment.land;

import shipment.Shipping;

public interface LandShipping extends Shipping {

    @Override
    default String getFolioPrefix() {
        return "L-";
    }

    @Override
    default void printOtherStages() {
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
    }
}
