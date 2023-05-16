package Items.Weapons;

import AbstractClasses.Bubble;
import AbstractClasses.Enemy;
import AbstractClasses.Weapon;
import Bubbles.BlackSlimeBubble;
import MainGameFiles.Player;

public final class UltimateBlackSlime extends Weapon {
	protected Bubble bubble;

	public void CreateBubbleOn(Player player, int levelC) {
		this.bubble = new BlackSlimeBubble(player, levelC);
	}

	public void CreateBubbleOn(Enemy enemy, int levelC) {
		this.bubble = new BlackSlimeBubble(enemy, levelC);
	}

}
