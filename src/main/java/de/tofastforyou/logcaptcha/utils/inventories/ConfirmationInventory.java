/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package de.tofastforyou.logcaptcha.utils.inventories;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.item.ItemCreator;
import de.tofastforyou.logcaptcha.utils.Vars;
import de.tofastforyou.logcaptcha.utils.XMaterial;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ConfirmationInventory {
    private static ConfirmationInventory ConfirmationInventory = new ConfirmationInventory();

    public static ConfirmationInventory getConfirmationInventory() {
        return ConfirmationInventory;
    }

    public void openInventory(Player p) {
        ItemStack no;
        ItemStack yes;
        ItemStack filler;
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            Vars.getVars().menu = p.getServer().createInventory(null, 27, "\u00a7aAre you sure?");
            filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
            yes = ItemCreator.getItemCreator().createItem("\u00a7aYes", 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            no = ItemCreator.getItemCreator().createItem("\u00a7cNo", 1, XMaterial.RED_TERRACOTTA.parseMaterial());
            Vars.getVars().menu.setItem(0, filler);
            Vars.getVars().menu.setItem(1, filler);
            Vars.getVars().menu.setItem(2, filler);
            Vars.getVars().menu.setItem(3, filler);
            Vars.getVars().menu.setItem(4, filler);
            Vars.getVars().menu.setItem(5, filler);
            Vars.getVars().menu.setItem(6, filler);
            Vars.getVars().menu.setItem(7, filler);
            Vars.getVars().menu.setItem(8, filler);
            Vars.getVars().menu.setItem(9, filler);
            Vars.getVars().menu.setItem(10, filler);
            Vars.getVars().menu.setItem(11, filler);
            Vars.getVars().menu.setItem(12, yes);
            Vars.getVars().menu.setItem(13, filler);
            Vars.getVars().menu.setItem(14, no);
            Vars.getVars().menu.setItem(15, filler);
            Vars.getVars().menu.setItem(16, filler);
            Vars.getVars().menu.setItem(17, filler);
            Vars.getVars().menu.setItem(18, filler);
            Vars.getVars().menu.setItem(19, filler);
            Vars.getVars().menu.setItem(20, filler);
            Vars.getVars().menu.setItem(21, filler);
            Vars.getVars().menu.setItem(22, filler);
            Vars.getVars().menu.setItem(23, filler);
            Vars.getVars().menu.setItem(24, filler);
            Vars.getVars().menu.setItem(25, filler);
            Vars.getVars().menu.setItem(26, filler);
            p.openInventory(Vars.getVars().menu);
        }
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
            Vars.getVars().menu = p.getServer().createInventory(null, 27, "\u00a7aBist du dir sicher?");
            filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
            yes = ItemCreator.getItemCreator().createItem("\u00a7aJa", 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            no = ItemCreator.getItemCreator().createItem("\u00a7cNein", 1, XMaterial.RED_TERRACOTTA.parseMaterial());
            Vars.getVars().menu.setItem(0, filler);
            Vars.getVars().menu.setItem(1, filler);
            Vars.getVars().menu.setItem(2, filler);
            Vars.getVars().menu.setItem(3, filler);
            Vars.getVars().menu.setItem(4, filler);
            Vars.getVars().menu.setItem(5, filler);
            Vars.getVars().menu.setItem(6, filler);
            Vars.getVars().menu.setItem(7, filler);
            Vars.getVars().menu.setItem(8, filler);
            Vars.getVars().menu.setItem(9, filler);
            Vars.getVars().menu.setItem(10, filler);
            Vars.getVars().menu.setItem(11, filler);
            Vars.getVars().menu.setItem(12, yes);
            Vars.getVars().menu.setItem(13, filler);
            Vars.getVars().menu.setItem(14, no);
            Vars.getVars().menu.setItem(15, filler);
            Vars.getVars().menu.setItem(16, filler);
            Vars.getVars().menu.setItem(17, filler);
            Vars.getVars().menu.setItem(18, filler);
            Vars.getVars().menu.setItem(19, filler);
            Vars.getVars().menu.setItem(20, filler);
            Vars.getVars().menu.setItem(21, filler);
            Vars.getVars().menu.setItem(22, filler);
            Vars.getVars().menu.setItem(23, filler);
            Vars.getVars().menu.setItem(24, filler);
            Vars.getVars().menu.setItem(25, filler);
            Vars.getVars().menu.setItem(26, filler);
            p.openInventory(Vars.getVars().menu);
        }
    }
}

