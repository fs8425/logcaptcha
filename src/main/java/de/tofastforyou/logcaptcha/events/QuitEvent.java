/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerQuitEvent
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent
implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseSquareCaptcha")) {
            TemporaryFile.getTemporaryFile().setProgressFinish(p.getName(), 0);
            TemporaryFile.getTemporaryFile().setProgress(p.getName(), 0);
        } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseRaisingCaptcha")) {
            TemporaryFile.getTemporaryFile().setNumber(p.getName(), 0);
            TemporaryFile.getTemporaryFile().setFinishNumber(p.getName(), 0);
        }
    }
}

