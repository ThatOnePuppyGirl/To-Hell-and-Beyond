package Items.Weapons;

import java.util.Random;

import AbstractClasses.Rarity;
import AbstractClasses.Type;
import AbstractClasses.Weapon;
import MiscClasses.PlayerType;

public final class BladeOfLife extends Weapon {
	private float lifeStealChance;
	private float lifeStealPortion;
	private float lifeStealLevelBuff;

	public BladeOfLife() {
		SetDetails();
	}

	protected void SetDetails() {
		this.lifeStealChance = 0.1f;
		this.lifeStealPortion = 0.25f;
		this.lifeStealLevelBuff = 0.005f;

		this.name = "Blade of Life";
		this.description = "A red katana. "
				+ "Can steal life from its enemies."
				+ "\nSpecial effect: Lifegain"
				+ "\nGives user a percentage of "
				+ "enemy's life taken by the attack.";
		this.levelNeeded = 10;
		this.type = Type.WEAPON;
		this.rarity = Rarity.LEGENDARY;
		this.isLoot = false;

		this.minDamage = 10;
		this.maxDamage = 20;
		this.levelStatMultiplier = 1.05f;
		this.lSTModifier = 0f;
		this.critChance = 0.3f;
		this.critMultiplier = 3f;
		this.rng = new Random();
		this.playerType = PlayerType.WARRIOR;

	}

	public boolean DoesLifeStealThisAttack(int level) {
		int rand = rng.nextInt(1001);
		int lifeSteal = (int) (this.lifeStealChance + (lifeStealLevelBuff * level) * 1000);
		if (rand <= lifeSteal)
			return true;
		else
			return false;
	}

	public int[] GenerateRandomDamageWithLifeSteal(int level) {
		// randomNumbers[0] = damage dealt to enemy
		// randomNumbers[1] = damage taken from enemy (can be zero)
		int[] randomNumbers = new int[2];

		randomNumbers[0] = this.GenerateRandomDamage(level);
		randomNumbers[1] = this.GenerateRandomLifeSteal(level, randomNumbers[0]);

		return randomNumbers;
	}

	private int GenerateRandomLifeSteal(int level, int damage) {
		float adjustedLifeStealBuff = this.lifeStealLevelBuff * level;
		float adjustedPortion = this.lifeStealPortion + adjustedLifeStealBuff;

		int finalLifeSteal = (int) (damage * adjustedPortion);

		return finalLifeSteal;
	}

}
