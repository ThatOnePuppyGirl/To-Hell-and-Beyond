package to_infinity_and_beyond.Items.Armor;

import java.util.Random;

import to_infinity_and_beyond.AbstractClasses.Armor;
import to_infinity_and_beyond.AbstractClasses.ArmorType;
import to_infinity_and_beyond.AbstractClasses.Rarity;
import to_infinity_and_beyond.AbstractClasses.Type;

public final class LeatherHelmet extends Armor
{
	public LeatherHelmet()
	{
		SetDetails();
	}
	
	protected void SetDetails()
	{
		this.name = "Leather Helmet";
		this.description = "A worn down leather helmet. Found on the ground.";
		this.levelNeeded = 0;
		this.type = Type.ARMOR;
		this.rarity = Rarity.COMMON;
		this.isLoot = false;
		
		this.rng = new Random();
		this.pctDmgBlocked = 0.05f;
		this.blockVariation = 0.01f;
		this.blockVarLevelBuff = 0.025f;
		this.armorType = ArmorType.HEAD;
	}

}
