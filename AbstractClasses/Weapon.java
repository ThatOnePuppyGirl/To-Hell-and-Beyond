package to_infinity_and_beyond.AbstractClasses;

import java.util.Random;

import to_infinity_and_beyond.MiscClasses.PlayerType;

public abstract class Weapon extends Item
{
	protected int minDamage;			// the minimum damage the weapon can deal (not including crits)
	protected int maxDamage;			// the maxmimum damage the weapon can deal (not including crits)
	protected float levelStatMultiplier;// the amount to multiply the stats by per level (usually between 1 and 1.5)
	protected float lSTModifier;		// TODO: should I actually have this? or is this just too OP
	protected float critChance;			// chance for crit (between 0.0f and 1.0f)
	protected float critMultiplier;		// how much to multiply the damage by for a crit
	protected Random rng;				// random number generator
	protected PlayerType playerType;	// the PlayerType that can use this weapon
	
	/*
	 * GenerateRandomDamage(int level)
	 * Inputs:
	 * level (int) - the level of the user
	 * Output:
	 * int - The total damage done
	 * 
	 * Generates a random amount of damage (including crits)
	 */
	public int GenerateRandomDamage(int level)
	{
		float totalLevelStatMultiplier = (this.levelStatMultiplier + this.lSTModifier) * level; // generates the total level stat multiplier
		int adjustedMax = (int) (this.maxDamage * totalLevelStatMultiplier); 					// adjusts the max
		int adjustedMin = (int) (this.minDamage * totalLevelStatMultiplier);					// adjusts the min
		int baseRandomDamage = rng.nextInt(adjustedMax - adjustedMin + 1);						// base for random
		int adjustedRandomDamage = baseRandomDamage + adjustedMin;								
																	// SEE Bubble.java for thorough explanation
		float critRNG = rng.nextFloat();							// creates random float
		boolean crit = (critRNG <= this.critChance);				// checks if the float is less than or equal to the crit chance
																	// if it is, then we hit a crit! set to true
		return (crit ? (int) (adjustedRandomDamage * critMultiplier) : adjustedRandomDamage); 	// returns the total damage (adjust for crit)
	}
	
	public PlayerType GetPlayerType()
	{
		return this.playerType;
	}
}
