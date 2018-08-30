package packing.size.box;

import packing.size.SizedPackageType;
import packing.type.Box;

public abstract class SizedBox extends Box implements SizedPackageType {

    @Override
    public final String getMeasurements() {
        return "Length: " + getLength() + ", Width: " + getWidth() + ", Height: " + getHeight();
    }

    public abstract String getLength();

    public abstract String getWidth();

    public abstract String getHeight();
}
