package AbstractClasses;

import java.util.Random;

public abstract class Armor extends Item {

	protected float pctDmgBlocked; // initial percent of damage blocked
	protected float blockVariation; // a variation (to allow ranges such as 15-20%)
	protected float blockVarLevelBuff; // a buff to the blockVariation that increases by level
	protected ArmorType armorType; // the armor type (Enum: HEAD, TORSO, LEGS, FEET)

	/*
	 * Generates a random amount of damage to deal depending on the armor's
	 * block percentage and the level of the user (NOT THE ATTACKER)
	 * Should never be overridden.
	 * Returns the random amount of damage
	 */
	public final int GenerateDamageDealt(int damageRecieved, int level) {
		return 0;

		// TODO: generate
	}

	/*
	 * Getter for armorType
	 */
	public final ArmorType GetArmorType() {
		return this.armorType;
	}

}