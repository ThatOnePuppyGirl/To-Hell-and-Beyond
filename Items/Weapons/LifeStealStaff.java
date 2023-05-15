package to_infinity_and_beyond.Items.Weapons;

import java.util.Random;

import to_infinity_and_beyond.AbstractClasses.Rarity;
import to_infinity_and_beyond.AbstractClasses.Type;
import to_infinity_and_beyond.AbstractClasses.Weapon;
import to_infinity_and_beyond.MiscClasses.PlayerType;

public final class LifeStealStaff extends Weapon
{
	private float lifeStealPortion;
	private float lifeStealLevelBuff;
	
	public LifeStealStaff()
	{
		SetDetails();
	}
	
	protected void SetDetails()
	{
		this.lifeStealPortion = 0.25f;
		this.lifeStealLevelBuff = 0.005f;
		
		this.name = "Life Steal Staff";
		this.description = "A mighty staff capable of "
				+ "stealing enemy's life!"
				+ "\nSpecial effect: Lifegain"
				+ "\nAlways gives user a percentage of "
				+ "enemy's life taken by the attack.";
		this.levelNeeded = 35;
		this.type = Type.WEAPON;
		this.rarity = Rarity.MYTHIC;
		this.isLoot = true;
		
		this.minDamage = 75;
		this.maxDamage = 105;
		this.levelStatMultiplier = 1.05f;
		this.lSTModifier = 0f;
		this.critChance = 0.1f;
		this.critMultiplier = 2.5f;
		this.rng = new Random();
		this.playerType = PlayerType.MAGE;
	}
	
	public int[] GenerateRandomDamageWithLifeSteal(int level)
	{
		// randomNumbers[0] = damage dealt to enemy
		// randomNumbers[1] = damage taken from enemy (can be zero)
		int[] randomNumbers = new int[2];
		
		randomNumbers[0] = this.GenerateRandomDamage(level);
		randomNumbers[1] = this.GenerateRandomLifeSteal(level, randomNumbers[0]);
		
		return randomNumbers;
	}
	
	private int GenerateRandomLifeSteal(int level, int damage)
	{
		float adjustedLifeStealBuff = this.lifeStealLevelBuff * level;
		float adjustedPortion = this.lifeStealPortion + adjustedLifeStealBuff;
		
		int finalLifeSteal = (int) (damage * adjustedPortion);
		
		return finalLifeSteal;
	}

}
