package Items.Weapons;

import java.util.Random;

import AbstractClasses.Bubble;
import AbstractClasses.Enemy;
import AbstractClasses.Rarity;
import AbstractClasses.Type;
import AbstractClasses.Weapon;
import Bubbles.BlackSlimeBubble;
import MainGameFiles.Player;
import MiscClasses.PlayerType;

public final class UltimateBlackSlime extends Weapon {

	protected Bubble bubble;

	public UltimateBlackSlime() {
		SetDetails();
	}

	protected void SetDetails() {

		this.name = "Ultimate Black Slime";
		this.description = "While in the air, solid as a rock. "
				+ "However, when it comes into "
				+ "\ncontact with something, "
				+ "it immediately traps it in a slime bubble.";
		this.levelNeeded = 11;
		this.type = Type.WEAPON;
		this.rarity = Rarity.RARE;
		this.isLoot = true;

		this.minDamage = 15;
		this.maxDamage = 25;
		this.levelStatMultiplier = 1.05f;
		this.lSTModifier = 0f;
		this.critChance = 0.075f;
		this.critMultiplier = 1.5f;
		this.rng = new Random();
		this.playerType = PlayerType.MAGE;
	}

	public void CreateBubbleOn(Player player, int levelC) {
		this.bubble = new BlackSlimeBubble(player, levelC);
	}

	public void CreateBubbleOn(Enemy enemy, int levelC) {
		this.bubble = new BlackSlimeBubble(enemy, levelC);
	}

}
