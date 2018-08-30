package shipment.impl.air;

import shipment.air.AirShipping;

public class SlowAirShipping implements AirShipping {

    @Override
    public String getMode() {
        return "Slow air shipping";
    }

    @Override
    public String getDeliveryTime() {
        return "One week";
    }
}