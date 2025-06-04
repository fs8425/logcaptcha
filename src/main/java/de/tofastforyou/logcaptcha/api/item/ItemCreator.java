/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package de.tofastforyou.logcaptcha.api.item;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
    public static ItemCreator ic = new ItemCreator();

    public static ItemCreator getItemCreator() {
        return ic;
    }

    public ItemStack createItem(String itemName, int Amount, Material Material2) {
        ItemStack item = new ItemStack(Material2);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        item.setAmount(Amount);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createItem(int Amount, Material Material2) {
        ItemStack item = new ItemStack(Material2);
        ItemMeta itemMeta = item.getItemMeta();
        item.setAmount(Amount);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createItem(String itemName, int Amount, Material Material2, short ID) {
        ItemStack item = new ItemStack(Material2, Amount, ID);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createItem(String itemName, int Amount, Material Material2, short ID, ArrayList<String> Lore) {
        ItemStack item = new ItemStack(Material2, Amount, ID);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        itemMeta.setLore(Lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createItem(String itemName, int Amount, Material Material2, ArrayList<String> Lore) {
        ItemStack item = new ItemStack(Material2, Amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        itemMeta.setLore(Lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createItem(String itemName, int Amount, Material Material2, short Durability, short ID) {
        ItemStack item = new ItemStack(Material2, Amount, ID);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        item.setDurability(Durability);
        item.setItemMeta(itemMeta);
        return item;
    }
}

