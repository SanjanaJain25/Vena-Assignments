package collection_Day3;
import java.util.*;

// Asset class with unique ID
class Asset {
    String assetId;
    String name;

    public Asset(String assetId, String name) {
        this.assetId = assetId;
        this.name = name;
    }

    // Ensure uniqueness based on assetId
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        Asset a = (Asset) o;
        return this.assetId.equals(a.assetId);
    }

    public int hashCode() {
        return assetId.hashCode();
    }

    public String toString() {
        return "[" + assetId + " - " + name + "]";
    }
}

public class Q11_CompanyAssetTracker {

    Map<String, Set<Asset>> departmentAssets = new HashMap<>();
    Set<String> globalAssetIds = new HashSet<>(); // To detect duplicate asset IDs

    // Method to add asset
    void addAsset(String department, Asset asset) {
        if (globalAssetIds.contains(asset.assetId)) {
            System.out.println("❌ Duplicate Asset ID: " + asset.assetId + " (Already exists)");
            return;
        }

        departmentAssets.putIfAbsent(department, new HashSet<>());
        departmentAssets.get(department).add(asset);
        globalAssetIds.add(asset.assetId);

        System.out.println("✅ Asset Added: " + asset + " to " + department);
    }

    // Display all assets department-wise
    void displayAssets() {
        for (String dept : departmentAssets.keySet()) {
            System.out.println("\nDepartment: " + dept);
            for (Asset asset : departmentAssets.get(dept)) {
                System.out.println("  " + asset);
            }
        }
    }

    public static void main(String[] args) {
        Q11_CompanyAssetTracker tracker = new Q11_CompanyAssetTracker();

        tracker.addAsset("IT", new Asset("A001", "Laptop"));
        tracker.addAsset("IT", new Asset("A002", "Printer"));
        tracker.addAsset("HR", new Asset("A003", "Projector"));
        tracker.addAsset("Finance", new Asset("A001", "Scanner")); // Duplicate ID test

        tracker.displayAssets();
    }
}
