package AbstractClasses;

import MiscClasses.PlayerType;

public abstract class Weapon extends Item {
	protected int minDamage; // the minimum damage the weapon can deal (not including crits)
	protected int maxDamage; // the maxmimum damage the weapon can deal (not including crits)
	protected float levelStatMultiplier;// the amount to multiply the stats by per level (usually between 1 and 1.5)
	protected float lSTModifier; // TODO: should I actually have this? or is this just too OP
	protected float critChance; // chance for crit (between 0.0f and 1.0f)
	protected float critMultiplier; // how much to multiply the damage by for a crit
	protected PlayerType playerType; // the PlayerType that can use this weapon

	/*
	 * GenerateRandomDamage(int level)
	 * Inputs:
	 * level (int) - the level of the user
	 * Output:
	 * int - The total damage done
	 * 
	 * Generates a random amount of damage (including crits)
	 */
	public int GenerateRandomDamage(int level) {
		return 0;
		// TODO: generate
	}

	public PlayerType GetPlayerType() {
		return this.playerType;
	}
}
