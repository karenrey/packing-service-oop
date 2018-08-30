package shipment.impl.land;

import shipment.land.LandShipping;

public class RegularLandShipping implements LandShipping {

    @Override
    public String getMode() {
        return "Regular land shipping";
    }

    @Override
    public String getDeliveryTime() {
        return "Four to six days";
    }
}
