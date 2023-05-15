package AbstractClasses;

import MiscClasses.EffectType;

public abstract class Consumable extends Item {
	protected int uses; // the number of uses the item has left (initialized as the max)
	protected EffectType effect; // the type of effect the item gives when uses
	protected int durationTurns; // how long (turns) the effect lasts
	protected int strength; // strength of the effect (aka level)
	protected String effectString = // sets the effect string to a string with
			effect.toString() + " " // a full description of the effect
					+ String.valueOf(durationTurns) + " "
					+ String.valueOf(strength);

	/*
	 * UseItem()
	 * Arguments: None
	 * Outputs:
	 * effectString (String) - the string describing the details
	 * of the effect.
	 * 
	 * Takes away a use and returns the effect string.
	 */
	public String UseItem() {
		uses--; // Decreases uses by 1
		return effectString; // returns effectString
	}

	/*
	 * Getter for uses variable
	 */
	public int GetUses() {
		return uses;
	}
}
