/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SquareCaptcha {
    private static SquareCaptcha sc = new SquareCaptcha();
    private int redBlocks = 0;

    public static SquareCaptcha getSquareCaptcha() {
        return sc;
    }

    private ItemStack getRandomBlock(Player p) {
        int random = new Random().nextInt(19) + 1;
        if (this.redBlocks > 7) {
            ItemStack right = ItemCreator.getItemCreator().createItem("\u00a7a", 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            TemporaryFile.getTemporaryFile().addProgressFinish(p.getName());
            return right;
        }
        if (random > 10) {
            ItemStack right = ItemCreator.getItemCreator().createItem("\u00a7a", 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            TemporaryFile.getTemporaryFile().addProgressFinish(p.getName());
            return right;
        }
        ItemStack wrong = ItemCreator.getItemCreator().createItem("\u00a7c", 1, XMaterial.RED_TERRACOTTA.parseMaterial());
        ++this.redBlocks;
        return wrong;
    }

    public void openCaptcha(Player p) {
        ItemStack question;
        ArrayList<String> Lore;
        ItemStack filler;
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            Vars.getVars().captcha = p.getServer().createInventory(null, 45, "\u00a7aSquare");
            filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial());
            Lore = new ArrayList<String>();
            Lore.add("\u00a77Click on all \u00a7agreen \u00a7eblocks \u00a77to get through the \u00a7ecaptcha\u00a77!");
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
            Vars.getVars().captcha.setItem(12, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(13, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(14, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(15, filler);
            Vars.getVars().captcha.setItem(16, filler);
            Vars.getVars().captcha.setItem(17, filler);
            Vars.getVars().captcha.setItem(18, filler);
            Vars.getVars().captcha.setItem(19, filler);
            Vars.getVars().captcha.setItem(20, filler);
            Vars.getVars().captcha.setItem(21, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(22, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(23, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(24, filler);
            Vars.getVars().captcha.setItem(25, filler);
            Vars.getVars().captcha.setItem(26, filler);
            Vars.getVars().captcha.setItem(27, filler);
            Vars.getVars().captcha.setItem(28, filler);
            Vars.getVars().captcha.setItem(29, filler);
            Vars.getVars().captcha.setItem(30, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(31, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(32, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(33, filler);
            Vars.getVars().captcha.setItem(34, filler);
            Vars.getVars().captcha.setItem(35, filler);
            Vars.getVars().captcha.setItem(36, filler);
            Vars.getVars().captcha.setItem(37, filler);
            Vars.getVars().captcha.setItem(38, filler);
            Vars.getVars().captcha.setItem(39, filler);
            Vars.getVars().captcha.setItem(40, filler);
            Vars.getVars().captcha.setItem(41, filler);
            Vars.getVars().captcha.setItem(42, filler);
            Vars.getVars().captcha.setItem(43, filler);
            Vars.getVars().captcha.setItem(44, filler);
            p.openInventory(Vars.getVars().captcha);
            this.redBlocks = 0;
        }
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
            Vars.getVars().captcha = p.getServer().createInventory(null, 45, "\u00a7aSquare");
            filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
            Lore = new ArrayList();
            Lore.add("\u00a77Klicke auf die \u00a7aGr\u00fcnen \u00a7eBl\u00f6cke \u00a77um das \u00a7eCaptcha \u00a77zu bestehen!");
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
            Vars.getVars().captcha.setItem(12, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(13, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(14, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(15, filler);
            Vars.getVars().captcha.setItem(16, filler);
            Vars.getVars().captcha.setItem(17, filler);
            Vars.getVars().captcha.setItem(18, filler);
            Vars.getVars().captcha.setItem(19, filler);
            Vars.getVars().captcha.setItem(20, filler);
            Vars.getVars().captcha.setItem(21, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(22, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(23, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(24, filler);
            Vars.getVars().captcha.setItem(25, filler);
            Vars.getVars().captcha.setItem(26, filler);
            Vars.getVars().captcha.setItem(27, filler);
            Vars.getVars().captcha.setItem(28, filler);
            Vars.getVars().captcha.setItem(29, filler);
            Vars.getVars().captcha.setItem(30, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(31, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(32, this.getRandomBlock(p));
            Vars.getVars().captcha.setItem(33, filler);
            Vars.getVars().captcha.setItem(34, filler);
            Vars.getVars().captcha.setItem(35, filler);
            Vars.getVars().captcha.setItem(36, filler);
            Vars.getVars().captcha.setItem(37, filler);
            Vars.getVars().captcha.setItem(38, filler);
            Vars.getVars().captcha.setItem(39, filler);
            Vars.getVars().captcha.setItem(40, filler);
            Vars.getVars().captcha.setItem(41, filler);
            Vars.getVars().captcha.setItem(42, filler);
            Vars.getVars().captcha.setItem(43, filler);
            Vars.getVars().captcha.setItem(44, filler);
            p.openInventory(Vars.getVars().captcha);
            this.redBlocks = 0;
        }
    }
}

