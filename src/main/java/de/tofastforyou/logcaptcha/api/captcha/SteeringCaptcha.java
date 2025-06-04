/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package de.tofastforyou.logcaptcha.api.captcha;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.item.ItemCreator;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import de.tofastforyou.logcaptcha.utils.Vars;
import de.tofastforyou.logcaptcha.utils.XMaterial;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SteeringCaptcha {
    private static SteeringCaptcha sc = new SteeringCaptcha();

    public static SteeringCaptcha getSteeringCaptcha() {
        return sc;
    }

    public void openCaptcha(Player p) {
        ItemStack question;
        ArrayList<String> Lore;
        ItemStack number;
        ItemStack down;
        ItemStack up;
        ItemStack filler;
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            Vars.getVars().captcha = p.getServer().createInventory(null, 27, "\u00a7aRaise Number");
            filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
            up = ItemCreator.getItemCreator().createItem("\u00a7a+1", 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            down = ItemCreator.getItemCreator().createItem("\u00a7c-1", 1, XMaterial.RED_TERRACOTTA.parseMaterial());
            number = ItemCreator.getItemCreator().createItem("\u00a7a" + Integer.toString(TemporaryFile.getTemporaryFile().getNumber(p.getName())), 1, Material.BLACK_WOOL, (short)15);
            Lore = new ArrayList<String>();
            Lore.add("\u00a77Raise the \u00a7enumber \u00a77to \u00a7e" + Integer.toString(TemporaryFile.getTemporaryFile().getFinishNumber(p.getName())) + "\u00a77!");
            question = ItemCreator.getItemCreator().createItem("\u00a7eTask", 1, XMaterial.NAME_TAG.parseMaterial(), Lore);
            Vars.getVars().captcha.setItem(0, filler);
            Vars.getVars().captcha.setItem(1, filler);
            Vars.getVars().captcha.setItem(2, filler);
            Vars.getVars().captcha.setItem(3, filler);
            Vars.getVars().captcha.setItem(4, question);
            Vars.getVars().captcha.setItem(5, filler);
            Vars.getVars().captcha.setItem(6, filler);
            Vars.getVars().captcha.setItem(7, filler);
            Vars.getVars().captcha.setItem(8, filler);
            Vars.getVars().captcha.setItem(9, filler);
            Vars.getVars().captcha.setItem(10, filler);
            Vars.getVars().captcha.setItem(11, filler);
            Vars.getVars().captcha.setItem(12, filler);
            Vars.getVars().captcha.setItem(13, number);
            Vars.getVars().captcha.setItem(14, filler);
            Vars.getVars().captcha.setItem(15, filler);
            Vars.getVars().captcha.setItem(16, filler);
            Vars.getVars().captcha.setItem(17, filler);
            Vars.getVars().captcha.setItem(18, filler);
            Vars.getVars().captcha.setItem(19, filler);
            Vars.getVars().captcha.setItem(20, up);
            Vars.getVars().captcha.setItem(21, filler);
            Vars.getVars().captcha.setItem(22, filler);
            Vars.getVars().captcha.setItem(23, filler);
            Vars.getVars().captcha.setItem(24, down);
            Vars.getVars().captcha.setItem(25, filler);
            Vars.getVars().captcha.setItem(26, filler);
            p.openInventory(Vars.getVars().captcha);
        }
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
            Vars.getVars().captcha = p.getServer().createInventory(null, 27, "\u00a7aRaise Number");
            filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial());
            up = ItemCreator.getItemCreator().createItem("\u00a7a+1", 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            down = ItemCreator.getItemCreator().createItem("\u00a7c-1", 1, XMaterial.RED_TERRACOTTA.parseMaterial());
            number = ItemCreator.getItemCreator().createItem("\u00a7a" + Integer.toString(TemporaryFile.getTemporaryFile().getNumber(p.getName())), 1, XMaterial.BLACK_WOOL.parseMaterial());
            Lore = new ArrayList();
            Lore.add("\u00a77Erh\u00f6he die \u00a7eZahl \u00a77auf \u00a7e" + Integer.toString(TemporaryFile.getTemporaryFile().getFinishNumber(p.getName())) + "\u00a77!");
            question = ItemCreator.getItemCreator().createItem("\u00a7eAufgabe", 1, XMaterial.NAME_TAG.parseMaterial(), Lore);
            Vars.getVars().captcha.setItem(0, filler);
            Vars.getVars().captcha.setItem(1, filler);
            Vars.getVars().captcha.setItem(2, filler);
            Vars.getVars().captcha.setItem(3, filler);
            Vars.getVars().captcha.setItem(4, question);
            Vars.getVars().captcha.setItem(5, filler);
            Vars.getVars().captcha.setItem(6, filler);
            Vars.getVars().captcha.setItem(7, filler);
            Vars.getVars().captcha.setItem(8, filler);
            Vars.getVars().captcha.setItem(9, filler);
            Vars.getVars().captcha.setItem(10, filler);
            Vars.getVars().captcha.setItem(11, filler);
            Vars.getVars().captcha.setItem(12, filler);
            Vars.getVars().captcha.setItem(13, number);
            Vars.getVars().captcha.setItem(14, filler);
            Vars.getVars().captcha.setItem(15, filler);
            Vars.getVars().captcha.setItem(16, filler);
            Vars.getVars().captcha.setItem(17, filler);
            Vars.getVars().captcha.setItem(18, filler);
            Vars.getVars().captcha.setItem(19, filler);
            Vars.getVars().captcha.setItem(20, up);
            Vars.getVars().captcha.setItem(21, filler);
            Vars.getVars().captcha.setItem(22, filler);
            Vars.getVars().captcha.setItem(23, filler);
            Vars.getVars().captcha.setItem(24, down);
            Vars.getVars().captcha.setItem(25, filler);
            Vars.getVars().captcha.setItem(26, filler);
            p.openInventory(Vars.getVars().captcha);
        }
    }
}

