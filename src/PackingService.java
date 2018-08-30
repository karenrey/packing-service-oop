import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import packing.type.PackageTypeEnum;
import shipment.ShipmentModeEnum;
import shipment.DeliveryTimeEnum;

public class PackingService {

    public static void main(String[] args) {
        sendPackageOne();
        sendPackageTwo();
        sendPackageThree();
        sendPackageFour();
    }

    private static void sendPackageOne() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Victor Anchondo").setSenderAddress("Cuauhtemoc, Chih")
                .setReceiverName("Fer Calderon").setReceiverAddress("Meoqui, Chih");

        PackageContent packageContent = new PackageContent("Glass trophy to the java dev of the year", true, false, false);
        Package pack = new Package(mailInfo, packageContent);
        pack.shipAndPrintTicket(PackageTypeEnum.BOX, PackageSizeEnum.SMALL, ShipmentModeEnum.LAND, DeliveryTimeEnum.REGULAR);
    }

    private static void sendPackageTwo() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Carlos Marin").setSenderAddress("Cd. Juarez, Chih")
                .setReceiverName("Crys Castillo").setReceiverAddress("Chihuahua, Chih");

        PackageContent packageContent = new PackageContent("12-bottle box of rum", true, true, false);
        Package pack = new Package(mailInfo, packageContent);
        pack.shipAndPrintTicket(PackageTypeEnum.BOX, PackageSizeEnum.MEDIUM, ShipmentModeEnum.AIR, DeliveryTimeEnum.REGULAR);
    }

    private static void sendPackageThree() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Juan Melo").setSenderAddress("Cuauhtemoc, Chih")
                .setReceiverName("Fer Martinez").setReceiverAddress("Chihuahua, Chih");

        PackageContent packageContent = new PackageContent("Javaschool member card", false, false, false);
        Package pack = new Package(mailInfo, packageContent);
        pack.shipAndPrintTicket(PackageTypeEnum.ENVELOPE, PackageSizeEnum.SMALL, ShipmentModeEnum.LAND, DeliveryTimeEnum.EXPRESS);
    }

    private static void sendPackageFour() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Colima, Col");

        PackageContent packageContent = new PackageContent("Anthrax", false, false, true);
        Package pack = new Package(mailInfo, packageContent);
        pack.shipAndPrintTicket(PackageTypeEnum.ENVELOPE, PackageSizeEnum.MEDIUM, ShipmentModeEnum.AIR, DeliveryTimeEnum.EXPRESS);
    }
}
