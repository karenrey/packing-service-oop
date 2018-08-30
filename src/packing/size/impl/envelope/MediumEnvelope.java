package packing.size.impl.envelope;

import packing.size.envelope.SizedEnvelope;

public class MediumEnvelope extends SizedEnvelope {

    @Override
    public String getSize() {
        return "Medium";
    }

    @Override
    public String getLength() {
        return "40cm";
    }

    @Override
    public String getWidth() {
        return "30cm";
    }
}