package to_infinity_and_beyond.Items.Weapons;

import java.util.Random;

import to_infinity_and_beyond.AbstractClasses.Rarity;
import to_infinity_and_beyond.AbstractClasses.Type;
import to_infinity_and_beyond.AbstractClasses.Weapon;
import to_infinity_and_beyond.MiscClasses.PlayerType;

public final class PlasticSword extends Weapon
{

	public PlasticSword()
	{
		SetDetails();
	}

	protected void SetDetails()
	{
		this.name = "Plastic Sword";
		this.description = "A toy sword someone donated to Goodwill.";
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
		this.playerType = PlayerType.WARRIOR;
	}

}
