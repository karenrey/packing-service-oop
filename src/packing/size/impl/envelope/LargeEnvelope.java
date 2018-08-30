package packing.size.impl.envelope;

import packing.size.envelope.SizedEnvelope;

public class LargeEnvelope extends SizedEnvelope {

    @Override
    public String getSize() {
        return "large";
    }

    @Override
    public String getLength() {
        return "60cm";
    }

    @Override
    public String getWidth() {
        return "45cm";
    }
}