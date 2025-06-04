/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryCloseEvent
 *  org.bukkit.plugin.Plugin
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.captcha.InventoryCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.SquareCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.SteeringCaptcha;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.Plugin;

public class InventoryCloseEventListener
implements Listener {
    private Random r = new Random();

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        final Player p = (Player)e.getPlayer();
        final int CaptchaID = this.r.nextInt(21) + 1;
        if (Captcha.getCaptcha().playerInCaptcha.contains(p)) {
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                StatisticsFile.getStatisticsFile().addPlayerClosedInventory();
            }
            if (e.getView().getTitle().contains("Captcha")) {
                Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                    @Override
                    public void run() {
                        InventoryCaptcha.getInventoryCaptcha().openCaptcha(CaptchaID, p);
                    }
                }, 5L);
            } else if (e.getView().getTitle().contains("Square")) {
                Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                    @Override
                    public void run() {
                        TemporaryFile.getTemporaryFile().setProgressFinish(p.getName(), 0);
                        SquareCaptcha.getSquareCaptcha().openCaptcha(p);
                    }
                }, 5L);
            } else if (e.getView().getTitle().contains("Raise Number")) {
                Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                    @Override
                    public void run() {
                        SteeringCaptcha.getSteeringCaptcha().openCaptcha(p);
                    }
                }, 5L);
            }
        }
    }
}

