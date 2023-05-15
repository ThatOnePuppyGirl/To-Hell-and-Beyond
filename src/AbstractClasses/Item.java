package AbstractClasses;

public abstract class Item {

	protected String name; // the name of the item
	protected String description; // a description of the item
	protected int levelNeeded; // the level needed to use the item (must be positive)
	protected Type type; // the Type of the item (see .AbstractClasses.Type.java)
	protected Rarity rarity; // the Rarity of the item (see .AbstractClasses.Rarity.java)
	protected boolean isLoot; // is this item chest loot?
}
