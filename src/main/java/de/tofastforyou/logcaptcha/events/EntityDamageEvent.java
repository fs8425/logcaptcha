/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageByBlockEvent
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageEvent
implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player)e.getEntity();
        if (Captcha.getCaptcha().playerInCaptcha.contains(p) || Captcha.getCaptcha().playerInChatCaptcha.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByBlockEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player)e.getEntity();
        if (Captcha.getCaptcha().playerInCaptcha.contains(p) || Captcha.getCaptcha().playerInChatCaptcha.contains(p)) {
            e.setCancelled(true);
        }
    }
}

