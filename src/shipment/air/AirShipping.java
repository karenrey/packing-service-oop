package shipment.air;

import shipment.Shipping;

public interface AirShipping extends Shipping {

    @Override
    default String getFolioPrefix() {
        return "A-";
    }

    @Override
    default void printOtherStages() {
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
    }
}
