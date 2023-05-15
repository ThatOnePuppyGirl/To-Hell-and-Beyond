package to_infinity_and_beyond.AbstractClasses;

public abstract class Item
{
	
	protected String name;			// the name of the item
	protected String description;	// a description of the item
	protected int levelNeeded;		// the level needed to use the item  (must be positive)
	protected Type type;			// the Type of the item (see to_infinity_and_beyond.AbstractClasses.Type.java)
	protected Rarity rarity;		// the Rarity of the item (see to_infinity_and_beyond.AbstractClasses.Rarity.java)
	protected boolean isLoot;		// is this item chest loot?
	
	protected abstract void SetDetails();	// abstract method to set the details 
	
}
