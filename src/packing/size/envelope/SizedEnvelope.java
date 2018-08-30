package packing.size.envelope;

import packing.size.SizedPackageType;
import packing.type.Envelope;

public abstract class SizedEnvelope extends Envelope implements SizedPackageType {

    @Override
    public final String getMeasurements() {
        return "Length: " + getLength() + ", Width: " + getWidth();
    }

    public abstract String getLength();

    public abstract String getWidth();
}
