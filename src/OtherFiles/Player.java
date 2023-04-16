package OtherFiles;

import java.util.ArrayList;
import java.util.HashMap;

import OtherFiles.ItemClasses.ItemStack;

public final class Player {
    private int level;
    private double health;
    private double mana; // ! might become stamina
    private double experiencePoints;
    // private PlayerTypeEnum playerType;
    private HashMap<String, HashMap<Integer, ItemStack>> inventory = new HashMap<>();
    // private Weapon currentWeapon;
    /*
     * "Armor" - armor
     * "Buffs" - permanent buff items
     * "InventoryStackable" - general inventory
     * "InventoryNonStackable" - non stackable inventory
     * 
     * 
     */

    public Player(String[] args, int[] argsInt, boolean[] argsBool) {
    }

}