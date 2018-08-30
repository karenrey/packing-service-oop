package packing.size.impl.envelope;

import packing.type.impl.Envelope;

public class LargeEnvelope extends Envelope {

    public String getSize() {
        return "large";
    }

    public String getLength() {
        return "60cm";
    }

    public String getWidth() {
        return "45cm";
    }
}