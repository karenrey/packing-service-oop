package packing.size.impl.envelope;

import packing.size.envelope.SizedEnvelope;

public class SmallEnvelope extends SizedEnvelope {

    @Override
    public String getSize() {
        return "Small";
    }

    @Override
    public String getLength() {
        return "30cm";
    }

    @Override
    public String getWidth() {
        return "10cm";
    }
}