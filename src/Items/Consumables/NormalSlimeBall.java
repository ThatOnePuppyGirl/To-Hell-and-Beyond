package Items.Consumables;

import AbstractClasses.Consumable;
import AbstractClasses.Rarity;
import AbstractClasses.Type;
import MiscClasses.EffectType;

public final class NormalSlimeBall extends Consumable {
	public NormalSlimeBall() {
		SetDetails();
	}

	protected void SetDetails() {
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
