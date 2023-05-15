package to_infinity_and_beyond.Items.Consumables;

import to_infinity_and_beyond.AbstractClasses.Consumable;
import to_infinity_and_beyond.AbstractClasses.Rarity;
import to_infinity_and_beyond.AbstractClasses.Type;
import to_infinity_and_beyond.MiscClasses.EffectType;

public final class NormalSlimeBall extends Consumable
{
	public NormalSlimeBall()
	{
		SetDetails();
	}
	
	
	protected void SetDetails()
	{
		this.name = "Slime Ball";
		this.description = "A slime ball. Sticky!";
		this.levelNeeded = 0;
		this.type = Type.CONSUMABLE;
		this.rarity = Rarity.COMMON;
		this.isLoot = true;
		
		this.uses = 1;
		this.effect = EffectType.INSTANT_HEALTH;
		this.durationTurns = 0;
		this.strength = 1;
	}
}
