package OtherFiles.ItemClasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public abstract class Item {
    private final ItemRarityEnum rarity;
    private final EnumSet<ItemTypeEnum> types = EnumSet.noneOf(ItemTypeEnum.class);
    private final int levelNeeded;
    private final String name;
    private final int id;
    private final boolean isStackable;

    public Item(boolean canStack, String itemName, int itemID, int level, ItemRarityEnum inputRarity,
            ItemTypeEnum... typesArray) {
        isStackable = canStack;
        name = itemName;
        id = itemID;
        levelNeeded = level;
        rarity = inputRarity;
        types.addAll(Arrays.asList(typesArray));
    }

    public ItemRarityEnum getRarity() {
        return rarity;
    }

    public Set<ItemTypeEnum> getTypes() {
        return Collections.unmodifiableSet(types);
    }

    public int getLevelNeeded() {
        return levelNeeded;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public boolean getStackability() {
        return isStackable;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Item))
            return false;
        if (obj == this)
            return true;
        if (((Item) obj).id == this.id)
            return true;
        return false;
    }
}
