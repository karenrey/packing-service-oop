package shipment.impl.air;

import shipment.air.AirShipping;

public class RegularAirShipping implements AirShipping {

    @Override
    public String getMode() {
        return "Regular air shipping";
    }

    @Override
    public String getDeliveryTime() {
        return "Two to three days";
    }
}