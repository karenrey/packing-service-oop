package shipment.impl.land;

import shipment.land.LandShipping;

public class ExpressLandShipping implements LandShipping {

    @Override
    public String getMode() {
        return "Express land shipping";
    }

    @Override
    public String getDeliveryTime() {
        return "Two to three days";
    }
}
