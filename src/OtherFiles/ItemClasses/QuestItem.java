package OtherFiles.ItemClasses;

public class QuestItem extends Item {
    // TODO: make npc class lol
    // private final NPC deliverTo;
    // private final List<ItemStack> itemRewards;
    // private final int goldRewards;

    public QuestItem(boolean canStack, String itemName, int itemID, int level, ItemRarityEnum inputRarity,
            ItemTypeEnum type) {
        super(canStack, itemName, itemID, level, inputRarity, type, ItemTypeEnum.QUEST_ITEM);
    }
}
