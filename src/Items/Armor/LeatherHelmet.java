package Items.Armor;

import java.util.Random;

import AbstractClasses.Armor;
import AbstractClasses.ArmorType;
import AbstractClasses.Rarity;
import AbstractClasses.Type;

public final class LeatherHelmet extends Armor {
	public LeatherHelmet() {
		SetDetails();
	}

	protected void SetDetails() {
		this.name = "Leather Helmet";
		this.description = "A worn down leather helmet. Found on the ground.";
		this.levelNeeded = 0;
		this.type = Type.ARMOR;
		this.rarity = Rarity.COMMON;
		this.isLoot = false;

		this.rng = new Random();
		this.pctDmgBlocked = 0.05f;
		this.blockVariation = 0.01f;
		this.blockVarLevelBuff = 0.025f;
		this.armorType = ArmorType.HEAD;
	}

}
