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

	public void CreateBubbleOn(Player player, int levelC) {
		this.bubble = new BlackSlimeBubble(player, levelC);
	}

	public void CreateBubbleOn(Enemy enemy, int levelC) {
		this.bubble = new BlackSlimeBubble(enemy, levelC);
	}

}
