package OtherFiles;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.ArrayList;

import OtherFiles.ItemClasses.ItemStack;

public final class Player {
    private enum PlayerInventoryEnum {
        ARMOR, BUFFS, INVSTACK, INVNOSTACK
    }

    private int level;
    private double health;
    private double mana; // ! might become stamina
    private double experiencePoints;
    private int gold;
    private ArrayList<Quest> questList;

    // private PlayerTypeEnum playerType;
    private EnumMap<PlayerInventoryEnum, HashMap<Integer, ItemStack>> inventory = new EnumMap<>(
            PlayerInventoryEnum.class);

    // private Weapon currentWeapon;

    public Player() {
        for (PlayerInventoryEnum e : PlayerInventoryEnum.values())
            inventory.put(e, new HashMap<>());
    }

}