package packing.size;

import packing.type.PackageType;

public interface SizedPackageType extends PackageType {

    String getSize();

    String getMeasurements();
}
