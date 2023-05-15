package to_infinity_and_beyond.AbstractClasses;

import java.util.Random;

import to_infinity_and_beyond.MainGameFiles.Player;

public abstract class Bubble
{
	protected String name;				// the name of the bubble item
	protected int levelCast;			// the level of the caster (used for calculating damage and damage needed)
	protected int minDamagePerTurn;		// the base minimum damage per turn
	protected int maxDamagePerTurn;		// the base maximum damage per turn
	protected int damageNeededToBreak;	// the total damage needed to break the bubble
	protected int damageVariation;		// the variation of the damage each turn
	protected Enemy enemyAttachedTo;	// the enemy that the bubble is attached to
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
	public int GenerateRandomDamage()
	{
		int damageAdj = this.damageVariation * this.levelCast;	// calculates total damage variation
		int adjMin = this.minDamagePerTurn + damageAdj;			// creates a new adjusted minDamage by adding damageAdj
		int adjMax = this.maxDamagePerTurn + damageAdj;			// creates a new adjusted maxDamage by adding damageAdj
		int max4RNG = adjMax - adjMin + 1;						// creates the upper limit for generating numbers
																// by subtracting the min from the max, it creates a range
																// between 0 and max4RNG where any number in that range
																// can be made to be in the range of adjMin and adjMax by
																// adding adjMin. We add 1 to include adjMax since nextInt(upperBound)
																// is exclusive to the upperBound.
		
		Random rng = new Random();								// initializing rng 
		int dmg = rng.nextInt(max4RNG) + adjMin;				// generates a random number then adjusts it to be within the range of
																// adjMin and adjMax by adding adjMin to the random number.
		
		return dmg;												// returns the damage done
	}
	
	/*
	 * An abstract SetDetails() method.
	 * Must be overridden!
	 * Sets the details of the object
	 */
	protected abstract void SetDetails();
	
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
	public boolean DamageBubble(int damage)
	{
		this.damageNeededToBreak -= damage;	// subtracts the damage done from the damage remaining to break
		if (this.damageNeededToBreak <= 0)	// checks if the damage remaining is less then or equal to zero
			return true;					// if it is, the bubble must be popped, return true
		else return false;					// otherwise it's still there, return false
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
	public int AttachToEnemyAndDealDamage(Enemy enemy, int levelC)
	{
		AttachToEnemy(enemy, levelC); 	// calls AttachToEnemy to attach to the enemy
		
		return GenerateRandomDamage();	// generates a random amount of damage and returns it
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
	protected void AttachToEnemy(Enemy enemy, int levelC)
	{
		this.enemyAttachedTo = enemy;	// sets the enemy variable
		this.levelCast = levelC;		// sets the levelCast variable
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
	public int AttachToPlayerAndDealDamage(Player player, int levelC)
	{
		AttachToPlayer(player, levelC);	// calls AttachToPlayer to attach to the player
		
		return GenerateRandomDamage();	// generates a random amount of damage and returns it
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
	protected void AttachToPlayer(Player player, int levelC)
	{
		this.playerAttachedTo = player;	// sets the player variable
		this.levelCast = levelC;		// sets the levelCast variable
	}
}