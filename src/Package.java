import javafx.util.Pair;
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
import util.SingleStringPrinter;

import java.util.LinkedHashMap;
import java.util.Map;

class Package {

    private MailInfo mailInfo;
    private PackageContent packageContent;

    private MapPrinter mapPrinter = new MapPrinterImpl();
    private SingleStringPrinter singleStringPrinter = System.out::println;

    Package(MailInfo mailInfo, PackageContent packageContent) {
        this.mailInfo = mailInfo;
        this.packageContent = packageContent;
    }

    void shipAndPrintTicket(PackageTypeEnum packageTypeEnum,
                                   PackageSizeEnum packageSizeEnum,
                                   ShipmentModeEnum shippingModeEnum,
                                   DeliveryTimeEnum deliveryTimeEnum) {

        mapPrinter.print(getMailingInformation());
        singleStringPrinter.print("\n");

        printPackageInformation(packageTypeEnum, packageSizeEnum);
        printShippingInformation(shippingModeEnum, deliveryTimeEnum);

        singleStringPrinter.print("**********************************************");
        singleStringPrinter.print("\n");
    }

    private Pair<String, Map<String, String>> getMailingInformation() {
        Map<String, String> mailInfoMap = new LinkedHashMap<>();
        Pair<String, Map<String, String>> section = new Pair<>("MAIL INFORMATION", mailInfoMap);
        mailInfoMap.put("Sender's name", mailInfo.getSenderName());
        mailInfoMap.put("Sender's address", mailInfo.getSenderAddress());
        mailInfoMap.put("Receiver's name", mailInfo.getReceiverName());
        mailInfoMap.put("Receiver's address", mailInfo.getReceiverAddress());
        return section;
    }

    private void printPackageInformation(PackageTypeEnum packageTypeEnum, PackageSizeEnum packageSizeEnum) {
        singleStringPrinter.print("PACKAGE INFORMATION");
        singleStringPrinter.print("--------------");
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
        singleStringPrinter.print("Type: " + sizedPackageType.getName() + " (" + sizedPackageType.getDescription() + ")");
        singleStringPrinter.print("Size: " + sizedPackageType.getSize() + " (" + sizedPackageType.getMeasurements() + ")");
    }

    private void printPackageContent() {
        singleStringPrinter.print("Content: " + packageContent.getDescription());

        if (packageContent.isFragile()) {
            singleStringPrinter.print("(F) Fragile");
        }

        if (packageContent.isLiquid()) {
            singleStringPrinter.print("(L) Liquid");
        }

        if (packageContent.isDangerous()) {
            singleStringPrinter.print("(D) Dangerous");
        }

        singleStringPrinter.print("\n");
    }

    private void printShippingInformation(ShipmentModeEnum shippingModeEnum, DeliveryTimeEnum deliveryTimeEnum) {
        singleStringPrinter.print("SHIPPING INFORMATION");
        singleStringPrinter.print("--------------");

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
        singleStringPrinter.print("- Mode: " + shipping.getMode());
        singleStringPrinter.print("- Delivery time: " + shipping.getDeliveryTime());
        shipping.printFolio();
        shipping.printStages();
    }

    interface MapPrinter {
        void print(Pair<String, Map<String, String>> information);
    }

    class MapPrinterImpl implements MapPrinter {
        public void print(Pair<String, Map<String, String>> information) {
            singleStringPrinter.print(information.getKey());
            singleStringPrinter.print("--------------");
            for (Map.Entry<String, String> e : information.getValue().entrySet()) {
                String key = e.getKey();
                String value = e.getValue();
                singleStringPrinter.print("- " + key + ": " + value);
            }
        }
    }
}
