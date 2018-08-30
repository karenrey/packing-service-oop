package shipment.impl.land;

import shipment.land.LandShipping;

public class SlowLandShipping implements LandShipping {

    @Override
    public String getMode() {
        return "Slow land shipping";
    }

    @Override
    public String getDeliveryTime() {
        return "Two weeks";
    }
}
