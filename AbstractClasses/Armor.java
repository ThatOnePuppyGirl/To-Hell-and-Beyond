package to_infinity_and_beyond.AbstractClasses;

import java.util.Random;

public abstract class Armor extends Item
{
	
	protected Random rng; 				// rng - random number generator 
	protected float pctDmgBlocked; 		// initial percent of damage blocked
	protected float blockVariation;		// a variation (to allow ranges such as 15-20%)
	protected float blockVarLevelBuff;	// a buff to the blockVariation that increases by level
	protected ArmorType armorType;		// the armor type (Enum: HEAD, TORSO, LEGS, FEET)

	/*
	 * Generates a random amount of damage to deal depending on the armor's 
	 * block percentage and the level of the user (NOT THE ATTACKER)
	 * Should never be overridden.
	 * Returns the random amount of damage
	 */
	public final int GenerateDamageDealt(int damageRecieved, int level)
	{
		float d = blockVarLevelBuff * level; 	// Generates the total block percentage variation
		float e = 0.5f - d; 					// adjusts for negative variation (larger variation means less chance for negative)
		float f = rng.nextFloat() - e; 			// generates new float and adjusts for negative
		float g = f * blockVariation; 			// generates final block variation
		float h = pctDmgBlocked + g; 			// generates total damage blocked percentage
		float i = damageRecieved * (1 - h); 	// calculates damage done
		
		return (int) i; 						// returns final damage done
	}
	
	/*
	 * Getter for armorType
	 */
	public final ArmorType GetArmorType()
	{
		return this.armorType;
	}
	
}