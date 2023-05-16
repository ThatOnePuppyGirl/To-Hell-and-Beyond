package Items.Weapons;

import AbstractClasses.Weapon;

public final class BladeOfLife extends Weapon {
	private float lifeStealChance;
	private float lifeStealPortion;
	private float lifeStealLevelBuff;

	public boolean DoesLifeStealThisAttack(int level) {
		return false;
		// TODO: generate
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
		return 0;
		// TODO: generate
	}

}
