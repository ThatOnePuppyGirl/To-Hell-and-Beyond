package OtherFiles;

import java.util.ArrayList;
import OtherFiles.ItemClasses.ItemStack;

public class Quest {
    // private final NPC deliverTo;
    private final int goldReward;
    private double progress = 0.0;
    private final ArrayList<ItemStack> requiredItems = new ArrayList<>();
    private final ArrayList<ItemStack> currentItems = new ArrayList<>();

    public Quest(int gold) {
        goldReward = gold;
    }
}
