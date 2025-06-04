/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.chat.BaseComponent
 *  net.md_5.bungee.api.chat.ClickEvent
 *  net.md_5.bungee.api.chat.ClickEvent$Action
 *  net.md_5.bungee.api.chat.ComponentBuilder
 *  net.md_5.bungee.api.chat.HoverEvent
 *  net.md_5.bungee.api.chat.HoverEvent$Action
 *  net.md_5.bungee.api.chat.TextComponent
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.utils.ErrorSaver;
import de.tofastforyou.logcaptcha.utils.ErrorTypes;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Updater {
    private static Updater updater = new Updater();

    public static Updater getUpdater() {
        return updater;
    }

    public String getVersion(int id) {
        try {
            HttpURLConnection con = (HttpURLConnection)new URL("https://api.spigotmc.org/legacy/update.php?resource=" + Integer.toString(id)).openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.getOutputStream().write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + Integer.toString(id)).getBytes("UTF-8"));
            String version = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
            return version;
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.UNKNOWN_ERROR, this.getClass().getName(), "Can't connect to SpigotMC!");
            return null;
        }
    }

    public boolean isUpdate(int id) {
        return !this.getVersion(id).equals(LogCaptcha.getInstance().getDescription().getVersion());
    }

    public void sendUpdateMessage(final Player p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)LogCaptcha.getInstance(), new Runnable(){

            @Override
            public void run() {
                TextComponent tc = new TextComponent();
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a74You're running an old version of \u00a7elogCaptcha\u00a7c!");
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a74Your version: \u00a7e" + LogCaptcha.getInstance().getDescription().getVersion() + "\u00a74 New version: \u00a7e" + Updater.getUpdater().getVersion(LogCaptcha.getInstance().getResourceID()));
                tc.setText(String.valueOf(Vars.getVars().pr) + "\u00a74I recommend it to download the new version \u00a7ehere\u00a74!");
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/logcaptcha-bot-protection-create-your-own-captchas.64279/"));
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("\u00a7cClick \u00a7ehere \u00a7cto download the new \u00a7eupdate\u00a7c!").create()));
                p.spigot().sendMessage((BaseComponent)tc);
            }
        }, 60L, 24000L);
    }
}

