package AbstractClasses;

import java.util.Random;

public abstract class Enemy {
	protected String name; // the name of the enemy
	protected int index; // the index of the enemy (during fights)

	protected int maxHealth; // the max health (used for healing)
	protected double health; // the current health of the enemy
	protected int level; // the level of the enemy
	protected Item[] possibleLootDrops; // the possible drops for the enemy
	protected double[] lootChances; // the related drop rates (decimal)
	protected Item weapon; // the current weapon (CAN BE NOITEM)
	protected int experienceGained; // the amount of experience the player gains for defeating the enemy
	protected int avgDamage; // the average amount of damage the enemy deals
	protected int dmgVar; // the amount of variation from the average
	protected Random rng; // rng :)

	/*
	 * DealDamage()
	 * Arguments: None
	 * Output:
	 * int - the total amount of damage done.
	 * 
	 * Generates a random amount of damage and returns it.
	 */
	public int DealDamage() {
		int maxRNG = (dmgVar * 2) + 1; // multiplies dmgVar by 2 then adds 1 because of random generation (allows for
										// negative numbers)
		int dmgVar2 = rng.nextInt(maxRNG) - dmgVar; // generates random number then adjusts down (to allow for negative
													// numbers)
		int totalDmg = avgDamage + dmgVar2; // adds dmgVar2 to avgDamage to generate damage

		return totalDmg; // returns totalDmg
	}

	// constructors: Name(String name, int index, double health, int level, Item
	// weapon);
}
