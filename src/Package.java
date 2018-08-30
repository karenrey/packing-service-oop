import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import packing.size.SizedPackageType;
import packing.size.impl.box.LargeBox;
import packing.size.impl.box.MediumBox;
import packing.size.impl.box.SmallBox;
import packing.size.impl.envelope.LargeEnvelope;
import packing.size.impl.envelope.MediumEnvelope;
import packing.size.impl.envelope.SmallEnvelope;
import packing.type.PackageTypeEnum;
import shipment.Shipping;
import shipment.impl.air.ExpressAirShipping;
import shipment.impl.air.RegularAirShipping;
import shipment.impl.air.SlowAirShipping;
import shipment.impl.land.ExpressLandShipping;
import shipment.impl.land.RegularLandShipping;
import shipment.impl.land.SlowLandShipping;
import shipment.ShipmentModeEnum;
import shipment.DeliveryTimeEnum;

class Package {

    private MailInfo mailInfo;
    private PackageContent packageContent;

    Package(MailInfo mailInfo, PackageContent packageContent) {
        this.mailInfo = mailInfo;
        this.packageContent = packageContent;
    }

    void shipAndPrintTicket(PackageTypeEnum packageTypeEnum,
                                   PackageSizeEnum packageSizeEnum,
                                   ShipmentModeEnum shippingModeEnum,
                                   DeliveryTimeEnum deliveryTimeEnum) {

        printMailingInformation();
        System.out.println("\n");

        printPackageInformation(packageTypeEnum, packageSizeEnum);
        printShippingInformation(shippingModeEnum, deliveryTimeEnum);

        System.out.println("**********************************************");
        System.out.println("\n");
    }

    private void printMailingInformation() {
        System.out.println("MAIL INFORMATION");
        System.out.println("--------------");
        System.out.println("Sender's name: " + mailInfo.getSenderName());
        System.out.println("Sender's address: " + mailInfo.getSenderAddress());
        System.out.println("Receiver's name: " + mailInfo.getReceiverName());
        System.out.println("Receiver's address: " + mailInfo.getReceiverAddress());
    }

    private void printPackageInformation(PackageTypeEnum packageTypeEnum, PackageSizeEnum packageSizeEnum) {
        System.out.println("PACKAGE INFORMATION");
        System.out.println("--------------");
        printSizedPackageTypeDescription(packageSizeEnum, packageTypeEnum);
        printPackageContent();
    }

    private void printSizedPackageTypeDescription(PackageSizeEnum packageSizeEnum, PackageTypeEnum packageTypeEnum) {
        SizedPackageType sizedPackageType = null;
        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                sizedPackageType = new SmallBox();
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                sizedPackageType = new MediumBox();
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                sizedPackageType = new LargeBox();
            }
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                sizedPackageType = new SmallEnvelope();
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                sizedPackageType = new MediumEnvelope();
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                sizedPackageType = new LargeEnvelope();
            }
        }
        printSizedPackageTypeDescription(sizedPackageType);
    }

    private void printSizedPackageTypeDescription(SizedPackageType sizedPackageType) {
        System.out.println("Type: " + sizedPackageType.getName() + " (" + sizedPackageType.getDescription() + ")");
        System.out.println("Size: " + sizedPackageType.getSize() + " (" + sizedPackageType.getMeasurements() + ")");
    }

    private void printPackageContent() {
        System.out.println("Content: " + packageContent.getDescription());

        if (packageContent.isFragile()) {
            System.out.println("(F) Fragile");
        }

        if (packageContent.isLiquid()) {
            System.out.println("(L) Liquid");
        }

        if (packageContent.isDangerous()) {
            System.out.println("(D) Dangerous");
        }

        System.out.println("\n");
    }

    private void printShippingInformation(ShipmentModeEnum shippingModeEnum, DeliveryTimeEnum deliveryTimeEnum) {
        System.out.println("SHIPPING INFORMATION");
        System.out.println("--------------");

        Shipping shipping = null;

        if (shippingModeEnum.equals(ShipmentModeEnum.LAND)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                shipping = new ExpressLandShipping();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                shipping = new RegularLandShipping();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                shipping = new SlowLandShipping();
            }
        } else if (shippingModeEnum.equals(ShipmentModeEnum.AIR)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                shipping = new ExpressAirShipping();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                shipping = new RegularAirShipping();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                shipping = new SlowAirShipping();
            }
        }

        printShippingInformation(shipping);
    }

    private void printShippingInformation(Shipping shipping) {
        System.out.println("- Mode: " + shipping.getMode());
        System.out.println("- Delivery time: " + shipping.getDeliveryTime());
        shipping.printFolio();
        shipping.printStages();
    }
}
