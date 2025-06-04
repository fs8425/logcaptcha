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
import java.util.ArrayList;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ManagementMenuInventory {
    private static ManagementMenuInventory ManagementMenuInventory = new ManagementMenuInventory();

    public static ManagementMenuInventory getManagementMenuInventory() {
        return ManagementMenuInventory;
    }

    public void openInventory(Player p) {
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
            ItemStack checkForUpdate;
            ArrayList<String> loreFourList;
            ItemStack resetConfig;
            ArrayList<String> loreThreeList;
            ItemStack listAllUser;
            ArrayList<String> loreTwoList;
            ItemStack resetAlreadyDone;
            ArrayList<String> loreOneList;
            ItemStack filler;
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                Vars.getVars().menu = p.getServer().createInventory(null, 27, "\u00a7aMenu");
                filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
                loreOneList = new ArrayList<String>();
                loreOneList.add("\u00a77If you click this,");
                loreOneList.add("\u00a77you will \u00a7creset \u00a77the");
                loreOneList.add("\u00a7eAlreadyDoneList \u00a77and create a new one.");
                resetAlreadyDone = ItemCreator.getItemCreator().createItem("\u00a7cReset AlradyDoneList", 1, XMaterial.BARRIER.parseMaterial(), loreOneList);
                loreTwoList = new ArrayList<String>();
                loreTwoList.add("\u00a77If you click this,");
                loreTwoList.add("\u00a77you will get a message");
                loreTwoList.add("\u00a77with all registered \u00a7eusers\u00a77.");
                listAllUser = ItemCreator.getItemCreator().createItem("\u00a77List all \u00a7euser", 1, XMaterial.PAPER.parseMaterial(), loreTwoList);
                loreThreeList = new ArrayList<String>();
                loreThreeList.add("\u00a77If you click this,");
                loreThreeList.add("\u00a77you will \u00a7creset \u00a77the");
                loreThreeList.add("\u00a7econfig.yml \u00a77file.");
                resetConfig = ItemCreator.getItemCreator().createItem("\u00a74Reset config file", 1, XMaterial.BARRIER.parseMaterial(), loreThreeList);
                loreFourList = new ArrayList<String>();
                loreFourList.add("\u00a77If you click this,");
                loreFourList.add("\u00a77you will \u00a7echeck \u00a77for new");
                loreFourList.add("\u00a7eupdates \u00a77for \u00a7elogCaptcha\u00a77.");
                checkForUpdate = ItemCreator.getItemCreator().createItem("\u00a77Check for \u00a7eUpdates", 1, XMaterial.PAPER.parseMaterial(), loreFourList);
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
                Vars.getVars().menu.setItem(10, resetAlreadyDone);
                Vars.getVars().menu.setItem(11, filler);
                Vars.getVars().menu.setItem(12, listAllUser);
                Vars.getVars().menu.setItem(13, filler);
                Vars.getVars().menu.setItem(14, resetConfig);
                Vars.getVars().menu.setItem(15, filler);
                Vars.getVars().menu.setItem(16, checkForUpdate);
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
                Vars.getVars().menu = p.getServer().createInventory(null, 27, "\u00a7aMen\u00fc");
                filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
                loreOneList = new ArrayList();
                loreOneList.add("\u00a77Setzt die \u00a7eAlreadyDoneList\u00a77 \u00a7czur\u00fcck\u00a77,");
                loreOneList.add("\u00a77sodass alle \u00a7eSpieler \u00a77erneut ein");
                loreOneList.add("\u00a7eCaptcha \u00a77machen \u00a7cm\u00fcssen\u00a77.");
                resetAlreadyDone = ItemCreator.getItemCreator().createItem("\u00a7cSetze die AlreadyDoneList zur\u00fcck", 1, XMaterial.BARRIER.parseMaterial(), loreOneList);
                loreTwoList = new ArrayList();
                loreTwoList.add("\u00a77Listet alle registrierten \u00a7eSpieler \u00a77auf");
                loreTwoList.add("\u00a77und sendet dir eine \u00a7eNachricht \u00a77mit der \u00a7eListe\u00a77.");
                loreTwoList.add("\u00a77In der \u00a7eListe \u00a77gibt es weitere \u00a7eOptionen\u00a77.");
                listAllUser = ItemCreator.getItemCreator().createItem("\u00a77Liste alle \u00a7eSpieler \u00a77auf", 1, XMaterial.PAPER.parseMaterial(), loreTwoList);
                loreThreeList = new ArrayList();
                loreThreeList.add("\u00a77Setzt die \u00a7eConfig Datei\u00a77 \u00a7czur\u00fcck\u00a77,");
                loreThreeList.add("\u00a77sodass alle \u00a7eEinstellungen \u00a77auf den");
                loreThreeList.add("\u00a7eStandard \u00a77gesetzt werden.");
                resetConfig = ItemCreator.getItemCreator().createItem("\u00a74Setze die Config Datei zur\u00fcck", 1, XMaterial.BARRIER.parseMaterial(), loreThreeList);
                loreFourList = new ArrayList();
                loreFourList.add("\u00a77\u00dcberpr\u00fcft, ob ein \u00a7eUpdate \u00a77f\u00fcr");
                loreFourList.add("\u00a7elogCaptcha \u00a77vorhanden ist.");
                checkForUpdate = ItemCreator.getItemCreator().createItem("\u00a77\u00dcberpr\u00fcfe auf \u00a7eUpdates", 1, XMaterial.PAPER.parseMaterial(), loreFourList);
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
                Vars.getVars().menu.setItem(10, resetAlreadyDone);
                Vars.getVars().menu.setItem(11, filler);
                Vars.getVars().menu.setItem(12, listAllUser);
                Vars.getVars().menu.setItem(13, filler);
                Vars.getVars().menu.setItem(14, resetConfig);
                Vars.getVars().menu.setItem(15, filler);
                Vars.getVars().menu.setItem(16, checkForUpdate);
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
        } else {
            ItemStack checkForUpdate;
            ArrayList<String> loreFourList;
            ItemStack resetConfig;
            ArrayList<String> loreThreeList;
            ItemStack listAllUser;
            ArrayList<String> loreTwoList;
            ItemStack filler;
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                Vars.getVars().menu = p.getServer().createInventory(null, 27, "\u00a7aMenu");
                filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
                loreTwoList = new ArrayList<String>();
                loreTwoList.add("\u00a77If you click this,");
                loreTwoList.add("\u00a77you will get a message");
                loreTwoList.add("\u00a77with all registered \u00a7eusers\u00a77.");
                listAllUser = ItemCreator.getItemCreator().createItem("\u00a77List all \u00a7euser", 1, XMaterial.PAPER.parseMaterial(), loreTwoList);
                loreThreeList = new ArrayList<String>();
                loreThreeList.add("\u00a77If you click this,");
                loreThreeList.add("\u00a77you will \u00a7creset \u00a77the");
                loreThreeList.add("\u00a7econfig.yml \u00a77file.");
                resetConfig = ItemCreator.getItemCreator().createItem("\u00a74Reset config file", 1, XMaterial.BARRIER.parseMaterial(), loreThreeList);
                loreFourList = new ArrayList<String>();
                loreFourList.add("\u00a77If you click this,");
                loreFourList.add("\u00a77you will \u00a7echeck \u00a77for new");
                loreFourList.add("\u00a7eupdates \u00a77for \u00a7elogCaptcha\u00a77.");
                checkForUpdate = ItemCreator.getItemCreator().createItem("\u00a77Check for \u00a7eUpdates", 1, XMaterial.PAPER.parseMaterial(), loreFourList);
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
                Vars.getVars().menu.setItem(11, listAllUser);
                Vars.getVars().menu.setItem(12, filler);
                Vars.getVars().menu.setItem(13, resetConfig);
                Vars.getVars().menu.setItem(14, filler);
                Vars.getVars().menu.setItem(15, checkForUpdate);
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
                Vars.getVars().menu = p.getServer().createInventory(null, 27, "\u00a7aMen\u00fc");
                filler = ItemCreator.getItemCreator().createItem("\u00a70", 1, XMaterial.BLACK_STAINED_GLASS_PANE.parseMaterial(), (short)7);
                loreTwoList = new ArrayList();
                loreTwoList.add("\u00a77Listet alle registrierten \u00a7eSpieler \u00a77auf");
                loreTwoList.add("\u00a77und sendet dir eine \u00a7eNachricht \u00a77mit der \u00a7eListe\u00a77.");
                loreTwoList.add("\u00a77In der \u00a7eListe \u00a77gibt es weitere \u00a7eOptionen\u00a77.");
                listAllUser = ItemCreator.getItemCreator().createItem("\u00a77Liste alle \u00a7eSpieler \u00a77auf", 1, XMaterial.PAPER.parseMaterial(), loreTwoList);
                loreThreeList = new ArrayList();
                loreThreeList.add("\u00a77Setzt die \u00a7eConfig Datei\u00a77 \u00a7czur\u00fcck\u00a77,");
                loreThreeList.add("\u00a77sodass alle \u00a7eEinstellungen \u00a77auf den");
                loreThreeList.add("\u00a7eStandard \u00a77gesetzt werden.");
                resetConfig = ItemCreator.getItemCreator().createItem("\u00a74Setze die Config Datei zur\u00fcck", 1, XMaterial.BARRIER.parseMaterial(), loreThreeList);
                loreFourList = new ArrayList();
                loreFourList.add("\u00a77\u00dcberpr\u00fcft, ob ein \u00a7eUpdate \u00a77f\u00fcr");
                loreFourList.add("\u00a7elogCaptcha \u00a77vorhanden ist.");
                checkForUpdate = ItemCreator.getItemCreator().createItem("\u00a77\u00dcberpr\u00fcfe auf \u00a7eUpdates", 1, XMaterial.PAPER.parseMaterial(), loreFourList);
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
                Vars.getVars().menu.setItem(11, listAllUser);
                Vars.getVars().menu.setItem(12, filler);
                Vars.getVars().menu.setItem(13, resetConfig);
                Vars.getVars().menu.setItem(14, filler);
                Vars.getVars().menu.setItem(15, checkForUpdate);
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
}

