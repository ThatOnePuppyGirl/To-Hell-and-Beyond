package to_infinity_and_beyond.Items.Armor;

import java.util.Random;

import to_infinity_and_beyond.AbstractClasses.Armor;
import to_infinity_and_beyond.AbstractClasses.ArmorType;
import to_infinity_and_beyond.AbstractClasses.Rarity;
import to_infinity_and_beyond.AbstractClasses.Type;

public final class LeatherShirt extends Armor
{
	public LeatherShirt()
	{
		SetDetails();
	}
	
	protected void SetDetails()
	{
		this.name = "Leather Shirt";
		this.description = "A worn down leather shirt. A bit big for you.";
		this.levelNeeded = 0;
		this.type = Type.ARMOR;
		this.rarity = Rarity.COMMON;
		this.isLoot = false;
		
		this.rng = new Random();
		this.pctDmgBlocked = 0.05f;
		this.blockVariation = 0.01f;
		this.blockVarLevelBuff = 0.025f;
		this.armorType = ArmorType.TORSO;
	}

}