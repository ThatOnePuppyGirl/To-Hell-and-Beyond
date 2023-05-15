package MainGameFiles;

import AbstractClasses.ItemStack;
import AbstractClasses.Quest;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.ArrayList;

public final class Player {
    private enum PlayerInventoryEnum {
        ARMOR, BUFFS, INVSTACK, INVNOSTACK
    }

    private enum PlayerTypeEnum {
        MAGE, WARRIOR, RANGE,
    }

    private int level = 0;
    private double health = 0.0;
    private double mana = 0.0; // ! might become stamina
    private double experiencePoints = 0.0;
    private int gold = 0;
    private final ArrayList<Quest> questList = new ArrayList<>();
    private final PlayerTypeEnum playerType;
    private final String name;
    private EnumMap<PlayerInventoryEnum, HashMap<Integer, ItemStack>> inventory = new EnumMap<>(
            PlayerInventoryEnum.class);

    // private Weapon currentWeapon;

    public Player(String newName, PlayerTypeEnum newPTE) {
        for (PlayerInventoryEnum e : PlayerInventoryEnum.values())
            inventory.put(e, new HashMap<>());
        this.name = newName;
        this.playerType = newPTE;
    }

}