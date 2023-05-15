package to_infinity_and_beyond.Bubbles;

import to_infinity_and_beyond.AbstractClasses.Bubble;
import to_infinity_and_beyond.AbstractClasses.Enemy;
import to_infinity_and_beyond.MainGameFiles.Player;

public final class BlackSlimeBubble extends Bubble
{
	public final int firstDamage; // the first amount of damage to do to the attachee
	/*
	 * constructor for attaching to a player
	 */
	public BlackSlimeBubble(Player player, int levelC)
	{
		firstDamage = AttachToPlayerAndDealDamage(player, levelC);	// attaches to the player
		SetDetails();												// sets details
	}
	
	/*
	 * constructor for attaching to an enemy
	 */
	public BlackSlimeBubble(Enemy enemy, int levelC)
	{
		firstDamage = AttachToEnemyAndDealDamage(enemy, levelC);	// attaches to the enemy
		SetDetails();												// sets details
	}
	
	protected void SetDetails()
	{
		this.name = "Black Slime Bubble";
		this.damageVariation = 5 * this.levelCast;
		this.minDamagePerTurn = 15 + this.damageVariation;
		this.maxDamagePerTurn = 25 + this.damageVariation;
		this.damageNeededToBreak = 20 + this.damageVariation;
	}
}