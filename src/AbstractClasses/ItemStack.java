package AbstractClasses;

public final class ItemStack {
    private final Item item;
    private int amount;

    public ItemStack(Item newItem, int newAmount) {
        item = newItem;
        amount = newAmount;
    }

    public ItemStack(Item newItem) {
        this(newItem, 1);
    }

    public int addOne() {
        amount++;
        return amount;
    }

    public int addMany(int n) {
        amount += n;
        return amount;
    }

    public boolean removeOne() {
        amount--;
        boolean valid = (amount > 0);
        if (!valid)
            amount++;
        return valid;
    }

    public boolean removeMany(int n) {
        amount -= n;
        boolean valid = (amount > 0);
        if (!valid)
            amount += n;
        return valid;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
