package to_infinity_and_beyond.Enemies;

import java.util.Random;

import to_infinity_and_beyond.AbstractClasses.Enemy;
import to_infinity_and_beyond.AbstractClasses.Item;
import to_infinity_and_beyond.AbstractClasses.NoItem;
import to_infinity_and_beyond.Items.Consumables.NormalSlimeBall;

public class NormalSlime extends Enemy
{
	
	public NormalSlime(String n, int i, int l)
	{
		// constant variables not dependent on anything
		this.name = n;
		this.index = i;
		this.level = l;
		this.weapon = new NoItem();
		this.possibleLootDrops = new Item[] {new NormalSlimeBall()};
		this.lootChances = new double[] {0.5};
		
		// random variables dependent on level
		
		this.rng = new Random();
		int maxHealthRand = rng.nextInt(this.level) + 1;
		int expRand1 = rng.nextInt(this.level) + 1;
		double expRand2 = rng.nextDouble() + 0.5d;
		
		
		this.maxHealth = maxHealthRand * 5;
		this.experienceGained = (int) Math.round(expRand1 * expRand2);
		this.avgDamage = 2 * level;
		this.dmgVar = 1 * level;
	
	}
}
