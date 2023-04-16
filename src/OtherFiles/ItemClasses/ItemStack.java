package OtherFiles.ItemClasses;

public class ItemStack {
    private final Item item;
    private int count;

    public ItemStack(Item inItem, int initialItemCount) {
        item = inItem;
        count = initialItemCount;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public int increaseCount(int amount) {
        count += amount;
        return count;
    }

    public boolean decreaseCount(int amount) {
        if (count - amount < 0)
            return false;

        count -= amount;
        return true;
    }

    public boolean hasSameItem(ItemStack otherStack) {
        if (otherStack.getItem().equals(item))
            return true;
        return false;
    }
}
