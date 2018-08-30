import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.Random;

import packing.size.box.SizedBox;
import packing.size.envelope.SizedEnvelope;
import packing.size.impl.box.LargeBox;
import packing.size.impl.box.MediumBox;
import packing.size.impl.box.SmallBox;
import packing.size.impl.envelope.LargeEnvelope;
import packing.size.impl.envelope.MediumEnvelope;
import packing.size.impl.envelope.SmallEnvelope;
import packing.type.PackageTypeEnum;
import packing.type.impl.Box;
import packing.type.impl.Envelope;
import shipment.impl.air.ExpressAirShipping;
import shipment.impl.air.RegularAirShipping;
import shipment.impl.air.SlowAirShipping;
import shipment.impl.land.ExpressLandShipping;
import shipment.impl.land.RegularLandShipping;
import shipment.impl.land.SlowLandShipping;
import shipment.mode.ShipmentModeEnum;
import shipment.mode.impl.AirShipping;
import shipment.mode.impl.LandShipping;
import shipment.time.DeliveryTimeEnum;

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
        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                SizedBox smallBox = new SmallBox();
                System.out.println("Type: " + smallBox.getName() + " (" + smallBox.getDescription() + ")");
                System.out.println("Size: " + smallBox.getSize() + " (Length: " + smallBox.getLength() + ", Width: " + smallBox.getWidth() + ", Height: " + smallBox.getHeight() + ")");
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                SizedBox mediumBox = new MediumBox();
                System.out.println("Type: " + mediumBox.getName() + " (" + mediumBox.getDescription() + ")");
                System.out.println("Size: " + mediumBox.getSize() + " (Length: " + mediumBox.getLength() + ", Width: " + mediumBox.getWidth() + ", Height: " + mediumBox.getHeight() + ")");
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                SizedBox largeBox = new LargeBox();
                System.out.println("Type: " + largeBox.getName() + " (" + largeBox.getDescription() + ")");
                System.out.println("Size: " + largeBox.getSize() + " (Length: " + largeBox.getLength() + ", Width: " + largeBox.getWidth() + ", Height: " + largeBox.getHeight() + ")");
            }
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                SizedEnvelope smallEnvelope = new SmallEnvelope();
                System.out.println("Type: " + smallEnvelope.getName() + " (" + smallEnvelope.getDescription() + ")");
                System.out.println("Size: " + smallEnvelope.getSize() + " (Length: " + smallEnvelope.getLength() + ", Width: " + smallEnvelope.getWidth() + ")");
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                SizedEnvelope mediumEnvelope = new MediumEnvelope();
                System.out.println("Type: " + mediumEnvelope.getName() + " (" + mediumEnvelope.getDescription() + ")");
                System.out.println("Size: " + mediumEnvelope.getSize() + " (Length: " + mediumEnvelope.getLength() + ", Width: " + mediumEnvelope.getWidth() + ")");
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                SizedEnvelope largeEnvelope = new LargeEnvelope();
                System.out.println("Type: " + largeEnvelope.getName() + " (" + largeEnvelope.getDescription() + ")");
                System.out.println("Size: " + largeEnvelope.getSize() + " (Length: " + largeEnvelope.getLength() + ", Width: " + largeEnvelope.getWidth() + ")");
            }
        }
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

        if (shippingModeEnum.equals(ShipmentModeEnum.LAND)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                ExpressLandShipping expressLandShipping = new ExpressLandShipping();
                System.out.println("- Mode: " + expressLandShipping.getMode());
                System.out.println("- Delivery time: " + expressLandShipping.getDeliveryTime());
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                RegularLandShipping regularLandShipping = new RegularLandShipping();
                System.out.println("- Mode: " + regularLandShipping.getMode());
                System.out.println("- Delivery time: " + regularLandShipping.getDeliveryTime());
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                SlowLandShipping slowLandShipping = new SlowLandShipping();
                System.out.println("- Mode: " + slowLandShipping.getMode());
                System.out.println("- Delivery time: " + slowLandShipping.getDeliveryTime());
            }

            printFolio();
            printLandShippingStages();
        } else if (shippingModeEnum.equals(ShipmentModeEnum.AIR)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                ExpressAirShipping expressAirShipping = new ExpressAirShipping();
                System.out.println("- Mode: " + expressAirShipping.getMode());
                System.out.println("- Delivery time: " + expressAirShipping.getDeliveryTime());
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                RegularAirShipping regularAirShipping = new RegularAirShipping();
                System.out.println("- Mode: " + regularAirShipping.getMode());
                System.out.println("- Delivery time: " + regularAirShipping.getDeliveryTime());
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                SlowAirShipping slowAirShipping = new SlowAirShipping();
                System.out.println("- Mode: " + slowAirShipping.getMode());
                System.out.println("- Delivery time: " + slowAirShipping.getDeliveryTime());
            }

            printFolio();
            printAirShippingStages();
        }
    }

    private void printFolio() {
        System.out.println("- Folio number: " + new Random().nextInt(1000000));
        System.out.println("\n");
    }

    private void printLandShippingStages() {
        new LandShipping().printStages();
    }

    private void printAirShippingStages() {
        new AirShipping().printStages();
    }
}
