package Items.Weapons;

import java.util.Random;

import AbstractClasses.Rarity;
import AbstractClasses.Type;
import AbstractClasses.Weapon;
import MiscClasses.PlayerType;

public final class RubberDagger extends Weapon {

	public RubberDagger() {
		SetDetails();
	}

	protected void SetDetails() {
		this.name = "Rubber Dagger";
		this.description = "A toy Medieval weapon used by young knights.";
		this.levelNeeded = 0;
		this.type = Type.WEAPON; // Medieval
		this.rarity = Rarity.COMMON;
		this.isLoot = false;

		this.rng = new Random();
		this.minDamage = 1;
		this.maxDamage = 5;
		this.levelStatMultiplier = 1;
		this.lSTModifier = 0.05f;
		this.critChance = 0.01f;
		this.critMultiplier = 2;
		this.playerType = PlayerType.KNIGHT;
	}

}
