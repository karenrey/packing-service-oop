package packing.size.envelope;

import packing.type.Envelope;

public abstract class SizedEnvelope extends Envelope {

    public abstract String getSize();

    public abstract String getLength();

    public abstract String getWidth();
}
