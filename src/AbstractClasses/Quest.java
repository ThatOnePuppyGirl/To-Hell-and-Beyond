package AbstractClasses;

import java.util.ArrayList;

public final class Quest {
	protected String questName;
	protected String questDescription;
	protected boolean isStoryQuest;
	protected String npcName;
	protected Item[] requiredItems;
	protected ArrayList<Item> stillRequiredItems;
	protected Item[] itemRewards;
	protected String[] otherRewards;

	public Quest(String name, String desc, boolean story, String nname, Item[] requiredItem, Item[] itemReward,
			String[] otherReward) {
		this.questName = name;
		this.questDescription = desc;
		this.isStoryQuest = story;
		this.npcName = nname;
		this.requiredItems = requiredItem;
		for (Item item : requiredItem)
			this.stillRequiredItems.add(item);
		this.itemRewards = itemReward;
		this.otherRewards = otherReward;
	}
}
