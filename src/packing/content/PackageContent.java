package packing.content;

public class PackageContent {

    private String description;
    private boolean fragile;
    private boolean liquid;
    private boolean dangerous;

    public PackageContent(String description, boolean fragile, boolean liquid, boolean dangerous) {
        this.description = description;
        this.fragile = fragile;
        this.liquid = liquid;
        this.dangerous = dangerous;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFragile() {
        return fragile;
    }

    public boolean isLiquid() {
        return liquid;
    }

    public boolean isDangerous() {
        return dangerous;
    }
}
