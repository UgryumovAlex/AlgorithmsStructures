public class StorageItem {
    private int weight;
    private int cost;
    private String itemName;

    public StorageItem(int weight, int cost, String name) {
        this.weight = weight;
        this.cost = cost;
        this.itemName = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("["+itemName+" : W="+getWeight() + ",C="+getCost()+"]");
        return sb.toString();
    }
}
