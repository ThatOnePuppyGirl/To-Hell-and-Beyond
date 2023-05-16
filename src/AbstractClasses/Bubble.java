package AbstractClasses;

import MainGameFiles.Player;

public abstract class Bubble {
	protected String name; // the name of the bubble item
	protected int levelCast; // the level of the caster (used for calculating damage and damage needed)
	protected int minDamagePerTurn; // the base minimum damage per turn
	protected int maxDamagePerTurn; // the base maximum damage per turn
	protected int damageNeededToBreak; // the total damage needed to break the bubble
	protected int damageVariation; // the variation of the damage each turn
	protected Enemy enemyAttachedTo; // the enemy that the bubble is attached to
	protected Player playerAttachedTo; // the player that the bubble is attached to

	// note: playerAttachedTo and enemyAttachedTo cannot
	// both be referencing something;
	// it must be one or the other.

	/*
	 * GenerateRandomDamage
	 * Parameters: none
	 * Output: int, total damage
	 * Generates a random amount of damage between
	 * minDamagePerTurn and maxDamagePerTurn;
	 */
	public int GenerateRandomDamage() {
		return 0;
		// TODO: generate
	}

	/*
	 * DamageBubble(int damage)
	 * Parameters:
	 * damage (int) - Damage done to the bubble
	 * Outputs:
	 * boolean - if the bubble has broken return true
	 * else bubble is still alive, return false
	 * Damages the bubble and checks if the bubble is "broken" -
	 * AKA bubble has taken enough damage to "pop".
	 */
	public boolean DamageBubble(int damage) {
		this.damageNeededToBreak -= damage; // subtracts the damage done from the damage remaining to break
		if (this.damageNeededToBreak <= 0) // checks if the damage remaining is less then or equal to zero
			return true; // if it is, the bubble must be popped, return true
		else
			return false; // otherwise it's still there, return false
	}

	/*
	 * AttachToEnemyAndDealDamage(Enemy enemy, int levelC)
	 * Inputs:
	 * enemy (Enemy) - the enemy to attach to
	 * levelC (int) - the level the bubble was cast at
	 * Output:
	 * int - The first amount of damage done to the enemy
	 * 
	 * Attaches to an enemy and deals damage to that enemy.
	 */
	public int AttachToEnemyAndDealDamage(Enemy enemy, int levelC) {
		AttachToEnemy(enemy, levelC); // calls AttachToEnemy to attach to the enemy

		return GenerateRandomDamage(); // generates a random amount of damage and returns it
	}

	/*
	 * AttachToEnemy(Enemy enemy, int levelC)
	 * Inputs:
	 * enemy (Enemy) - the enemy to attach to
	 * levelC (int) - the level the bubble was cast at
	 * Output: None
	 * 
	 * Attaches to a enemy.
	 */
	protected void AttachToEnemy(Enemy enemy, int levelC) {
		this.enemyAttachedTo = enemy; // sets the enemy variable
		this.levelCast = levelC; // sets the levelCast variable
	}

	/*
	 * AttachToPlayerAndDealDamage(Player player, int levelC)
	 * Inputs:
	 * player (Player) - the player to attach to
	 * levelC (int) - the level the bubble was cast at
	 * Output:
	 * int - The first amount of damage done to the player
	 * 
	 * Attaches to a player and deals damage to that player.
	 */
	public int AttachToPlayerAndDealDamage(Player player, int levelC) {
		AttachToPlayer(player, levelC); // calls AttachToPlayer to attach to the player

		return GenerateRandomDamage(); // generates a random amount of damage and returns it
	}

	/*
	 * AttachToPlayer(Player player, int levelC)
	 * Inputs:
	 * player (Player) - the player to attach to
	 * levelC (int) - the level the bubble was cast at
	 * Output: None
	 * 
	 * Attaches to a player.
	 */
	protected void AttachToPlayer(Player player, int levelC) {
		this.playerAttachedTo = player; // sets the player variable
		this.levelCast = levelC; // sets the levelCast variable
	}
}