package packing.size.impl.box;

import packing.size.box.SizedBox;

public class LargeBox extends SizedBox {

    @Override
    public String getSize() {
        return "Large";
    }

    @Override
    public String getLength() {
        return "100cm";
    }

    @Override
    public String getWidth() {
        return "100cm";
    }

    @Override
    public String getHeight() {
        return "300cm";
    }
}