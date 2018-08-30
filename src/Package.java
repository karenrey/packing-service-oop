import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.Random;

import packing.type.PackageTypeEnum;
import shipment.mode.ShipmentModeEnum;
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

        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            System.out.println("Type: Box (Multi-purpose box-type package)");
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            System.out.println("Type: Envelope (For posting documents, photos and stuff like that)");
        }

        printSizedPackageTypeDescription(packageSizeEnum, packageTypeEnum);
        printPackageContent();
    }

    private void printSizedPackageTypeDescription(PackageSizeEnum packageSizeEnum, PackageTypeEnum packageTypeEnum) {
        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                System.out.println("Size: Small (Length: 40cm, Width: 30cm, Height: 30cm");
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                System.out.println("Size: Medium (Length: 100cm, Width: 100cm, Height: 100cm");
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                System.out.println("Size: Large (Length: 300cm, Width: 100cm, Height: 100cm");
            }
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                System.out.println("Size: Small (Length: 30cm, Width: 10cm");
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                System.out.println("Size: Medium (Length: 40cm, Width: 30cm");
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                System.out.println("Size: Large (Length: 60cm, Width: 45cm");
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
                System.out.println("- Mode: Express land shipping");
                System.out.println("- Delivery time: Two to three days");
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                System.out.println("- Mode: Regular land shipping");
                System.out.println("- Delivery time: Four to six days");
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                System.out.println("- Mode: Slow land shipping");
                System.out.println("- Delivery time: Two weeks");
            }

            printFolio();
            printLandShippingStages();
        } else if (shippingModeEnum.equals(ShipmentModeEnum.AIR)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                System.out.println("- Mode: Express air shipping");
                System.out.println("- Delivery time: Next day");
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                System.out.println("- Mode: Express air shipping");
                System.out.println("- Delivery time: Two to three days");
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                System.out.println("- Mode: Express air shipping");
                System.out.println("- Delivery time: One week");
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
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
        System.out.println("- Receiving package at destination office");
    }

    private void printAirShippingStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
        System.out.println("- Receiving package at destination office");
    }
}
