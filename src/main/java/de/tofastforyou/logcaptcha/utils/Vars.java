/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.inventory.Inventory
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.LogCaptcha;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.Inventory;

public class Vars {
    private static Vars vars = new Vars();
    public String pr = ChatColor.translateAlternateColorCodes((char)'&', (String)LogCaptcha.getInstance().getConfig().getString("logCaptcha.Prefix"));
    public Inventory captcha = null;
    public Inventory menu = null;

    public static Vars getVars() {
        return vars;
    }
}

