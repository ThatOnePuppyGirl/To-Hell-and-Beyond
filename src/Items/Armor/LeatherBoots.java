package Items.Armor;

import java.util.Random;

import AbstractClasses.Armor;
import AbstractClasses.ArmorType;
import AbstractClasses.Rarity;
import AbstractClasses.Type;

public final class LeatherBoots extends Armor {

	public LeatherBoots() {
		SetDetails();
	}

	protected void SetDetails() {
		this.name = "Leather Boots";
		this.description = "A pair of worn down leather boots.";
		this.levelNeeded = 0;
		this.type = Type.ARMOR;
		this.rarity = Rarity.COMMON;
		this.isLoot = false;

		this.rng = new Random();
		this.pctDmgBlocked = 0.05f;
		this.blockVariation = 0.01f;
		this.blockVarLevelBuff = 0.025f;
		this.armorType = ArmorType.FEET;
	}

}
