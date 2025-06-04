/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerInteractEvent
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickEvent
implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.AntiRightclick") && (Captcha.getCaptcha().playerInCaptcha.contains(p) || Captcha.getCaptcha().playerInChatCaptcha.contains(p))) {
            e.setCancelled(true);
        }
    }
}

