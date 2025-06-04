/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package de.tofastforyou.logcaptcha.api.captcha;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.item.ItemCreator;
import de.tofastforyou.logcaptcha.files.CustomCaptchaFile;
import de.tofastforyou.logcaptcha.utils.Vars;
import de.tofastforyou.logcaptcha.utils.XMaterial;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryCaptcha {
    private static InventoryCaptcha ic = new InventoryCaptcha();
    Random r = new Random();
    private ArrayList<String> correctAnswerList;
    private ArrayList<String> customQuestionList;
    private int CustomCaptchaID;

    public InventoryCaptcha() {
        this.correctAnswerList = (ArrayList)CustomCaptchaFile.getCustomCaptchaFile().customCaptchaCfg.get("CorrectAnswerList");
        this.customQuestionList = (ArrayList)CustomCaptchaFile.getCustomCaptchaFile().customCaptchaCfg.get("CustomQuestionList");
        this.CustomCaptchaID = this.r.nextInt(this.customQuestionList.size() - 1) + 1;
    }

    public static InventoryCaptcha getInventoryCaptcha() {
        return ic;
    }

    public void openCaptcha(int CaptchaID, Player p) {
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.UseCustomCaptchas")) {
            Vars.getVars().captcha = p.getServer().createInventory(null, 27, String.valueOf(Vars.getVars().pr) + "\u00a7aCaptcha " + Integer.toString(this.CustomCaptchaID));
            ItemStack filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial());
            ItemStack answer_1 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordOneList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            ItemStack answer_2 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordTwoList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            ItemStack answer_3 = ItemCreator.getItemCreator().createItem(this.correctAnswerList.get(this.CustomCaptchaID), 1, XMaterial.GREEN_TERRACOTTA.parseMaterial(), (short)5);
            ItemStack answer_4 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordFourList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            ItemStack answer_5 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordFiveList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
            ArrayList<String> Lore = new ArrayList<String>();
            Lore.add(this.customQuestionList.get(this.CustomCaptchaID));
            ItemStack question = ItemCreator.getItemCreator().createItem("\u00a7eQuestion", 1, XMaterial.NAME_TAG.parseMaterial(), Lore);
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
            Vars.getVars().captcha.setItem(11, answer_5);
            Vars.getVars().captcha.setItem(12, answer_2);
            Vars.getVars().captcha.setItem(13, answer_1);
            Vars.getVars().captcha.setItem(14, answer_3);
            Vars.getVars().captcha.setItem(15, answer_4);
            Vars.getVars().captcha.setItem(16, filler);
            Vars.getVars().captcha.setItem(17, filler);
            Vars.getVars().captcha.setItem(18, filler);
            Vars.getVars().captcha.setItem(19, filler);
            Vars.getVars().captcha.setItem(20, filler);
            Vars.getVars().captcha.setItem(21, filler);
            Vars.getVars().captcha.setItem(22, filler);
            Vars.getVars().captcha.setItem(23, filler);
            Vars.getVars().captcha.setItem(24, filler);
            Vars.getVars().captcha.setItem(25, filler);
            Vars.getVars().captcha.setItem(26, filler);
            p.openInventory(Vars.getVars().captcha);
        } else {
            ItemStack question;
            ArrayList<String> Lore;
            ItemStack answer_5;
            ItemStack answer_4;
            ItemStack answer_3;
            ItemStack answer_2;
            ItemStack answer_1;
            ItemStack filler;
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                Vars.getVars().captcha = p.getServer().createInventory(null, 27, String.valueOf(Vars.getVars().pr) + "\u00a7aCaptcha " + Integer.toString(CaptchaID));
                filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
                answer_1 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordOneList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_2 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordTwoList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_3 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaSolutionList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_4 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordFourList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_5 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordFiveList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                Lore = new ArrayList<String>();
                Lore.add(Captcha.getCaptcha().invCaptchaQuestionListEN[CaptchaID]);
                question = ItemCreator.getItemCreator().createItem("\u00a7eQuestion", 1, XMaterial.NAME_TAG.parseMaterial(), Lore);
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
                Vars.getVars().captcha.setItem(11, answer_5);
                Vars.getVars().captcha.setItem(12, answer_2);
                Vars.getVars().captcha.setItem(13, answer_1);
                Vars.getVars().captcha.setItem(14, answer_3);
                Vars.getVars().captcha.setItem(15, answer_4);
                Vars.getVars().captcha.setItem(16, filler);
                Vars.getVars().captcha.setItem(17, filler);
                Vars.getVars().captcha.setItem(18, filler);
                Vars.getVars().captcha.setItem(19, filler);
                Vars.getVars().captcha.setItem(20, filler);
                Vars.getVars().captcha.setItem(21, filler);
                Vars.getVars().captcha.setItem(22, filler);
                Vars.getVars().captcha.setItem(23, filler);
                Vars.getVars().captcha.setItem(24, filler);
                Vars.getVars().captcha.setItem(25, filler);
                Vars.getVars().captcha.setItem(26, filler);
                p.openInventory(Vars.getVars().captcha);
            }
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                Vars.getVars().captcha = p.getServer().createInventory(null, 27, String.valueOf(Vars.getVars().pr) + "\u00a7aCaptcha " + Integer.toString(CaptchaID));
                filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
                answer_1 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordOneList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_2 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordTwoList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_3 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaSolutionList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_4 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordFourList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                answer_5 = ItemCreator.getItemCreator().createItem(Captcha.getCaptcha().invCaptchaWordFiveList[CaptchaID], 1, XMaterial.GREEN_TERRACOTTA.parseMaterial());
                Lore = new ArrayList();
                Lore.add(Captcha.getCaptcha().invCaptchaQuestionListDE[CaptchaID]);
                question = ItemCreator.getItemCreator().createItem("\u00a7eFrage", 1, XMaterial.NAME_TAG.parseMaterial(), Lore);
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
                Vars.getVars().captcha.setItem(11, answer_5);
                Vars.getVars().captcha.setItem(12, answer_2);
                Vars.getVars().captcha.setItem(13, answer_1);
                Vars.getVars().captcha.setItem(14, answer_3);
                Vars.getVars().captcha.setItem(15, answer_4);
                Vars.getVars().captcha.setItem(16, filler);
                Vars.getVars().captcha.setItem(17, filler);
                Vars.getVars().captcha.setItem(18, filler);
                Vars.getVars().captcha.setItem(19, filler);
                Vars.getVars().captcha.setItem(20, filler);
                Vars.getVars().captcha.setItem(21, filler);
                Vars.getVars().captcha.setItem(22, filler);
                Vars.getVars().captcha.setItem(23, filler);
                Vars.getVars().captcha.setItem(24, filler);
                Vars.getVars().captcha.setItem(25, filler);
                Vars.getVars().captcha.setItem(26, filler);
                p.openInventory(Vars.getVars().captcha);
            }
        }
    }
}

