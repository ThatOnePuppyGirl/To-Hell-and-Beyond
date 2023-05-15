package to_infinity_and_beyond.Items.Weapons;

import java.util.Random;

import to_infinity_and_beyond.AbstractClasses.Rarity;
import to_infinity_and_beyond.AbstractClasses.Type;
import to_infinity_and_beyond.AbstractClasses.Weapon;
import to_infinity_and_beyond.MiscClasses.PlayerType;

public final class StarterWand extends Weapon
{

	public StarterWand()
	{
		SetDetails();
	}

	protected void SetDetails()
	{
		this.name = "Starter Wand";
		this.description = "A flimsy stick found in the woods.";
		this.levelNeeded = 0;
		this.type = Type.WEAPON;
		this.rarity = Rarity.COMMON;
		this.isLoot = false;

		this.rng = new Random();
		this.minDamage = 1;
		this.maxDamage = 5;
		this.levelStatMultiplier = 1;
		this.lSTModifier = 0.05f;
		this.critChance = 0.01f;
		this.critMultiplier = 2;
		this.playerType = PlayerType.MAGE;
	}

}
