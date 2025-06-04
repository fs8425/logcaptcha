/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerMoveEvent
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.utils.Vars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent
implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (Captcha.getCaptcha().playerInCaptcha.contains(p) || Captcha.getCaptcha().playerInChatCaptcha.contains(p)) {
            p.teleport(e.getFrom());
            e.setCancelled(true);
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                StatisticsFile.getStatisticsFile().addPlayerTriedMove();
            }
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.MoveMessage")));
            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.MoveMessage")));
            }
        }
    }
}

