package packing.size.impl.box;

import packing.size.box.SizedBox;

public class MediumBox extends SizedBox {

    @Override
    public String getSize() {
        return "Medium";
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
        return "100cm";
    }
}