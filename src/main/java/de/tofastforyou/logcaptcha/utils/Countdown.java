/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.plugin.Plugin
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.CaptchaFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Countdown {
    public static Countdown countdown = new Countdown();
    public int secs = 1200;

    public static Countdown getCountdown() {
        return countdown;
    }

    public void startCountdown() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)LogCaptcha.getInstance(), new Runnable(){

            @Override
            public void run() {
                Countdown.this.resetList();
                --Countdown.this.secs;
            }
        }, 20L, 20L);
    }

    private void resetList() {
        if (this.secs < 0 || this.secs == 0) {
            CaptchaFile.getCaptchaFile().captchaCfg.set("TemporaryNoCaptcha", null);
            CaptchaFile.getCaptchaFile().saveFile();
            this.secs = 1200;
        }
    }
}

