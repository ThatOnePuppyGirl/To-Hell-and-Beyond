package Items.Weapons;

import java.util.Random;

import AbstractClasses.Rarity;
import AbstractClasses.Type;
import AbstractClasses.Weapon;
import MiscClasses.PlayerType;

public final class SnapDragon extends Weapon {
	public SnapDragon() {
		SetDetails();
	}

	private float critChanceLevelBoost;

	protected void SetDetails() {
		this.name = "Snap Dragon";
		this.description = "A sentient sword with teeth! "
				+ "The more you use it, the more it likes you."
				+ "\n +2.5% crit chance for level over 20.";
		this.levelNeeded = 20;
		this.type = Type.WEAPON;
		this.rarity = Rarity.LEGENDARY;
		this.isLoot = true;

		this.minDamage = 50;
		this.maxDamage = 85;
		this.levelStatMultiplier = 1.05f;
		this.critChanceLevelBoost = 0.05f;
		this.lSTModifier = 0f;
		this.critChance = 0.2f;
		this.critMultiplier = 2.5f;
		this.rng = new Random();
		this.playerType = PlayerType.WARRIOR;
	}

	public int GenerateRandomDamage(int level) {
		int adjustedMax = (int) (this.maxDamage * (this.levelStatMultiplier + (this.lSTModifier * level)) * level);
		int adjustedMin = (int) (this.minDamage * (this.levelStatMultiplier + (this.lSTModifier * level)) * level);
		int baseRandomDamage = rng.nextInt(adjustedMax - adjustedMin + 1);
		int adjustedRandomDamage = baseRandomDamage + adjustedMin;

		float critRNG = rng.nextFloat();
		float adjustedCritChance = this.critChance + (this.critChanceLevelBoost * level);
		boolean crit = (critRNG <= adjustedCritChance);

		return (crit ? (int) (adjustedRandomDamage * this.critMultiplier) : adjustedRandomDamage);

	}

}
