/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 *  org.bukkit.plugin.Plugin
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.bwaves.files.BanFile;
import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.captcha.ChatCaptcha;
import de.tofastforyou.logcaptcha.files.CaptchaFile;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import de.tofastforyou.logcaptcha.utils.Log;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class ChatEvent
implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseChatCaptcha") && Captcha.getCaptcha().playerInChatCaptcha.contains(p)) {
            e.setCancelled(true);
            if (ChatCaptcha.getChatCaptcha().temporaryWordList.contains(e.getMessage()) || ChatCaptcha.getChatCaptcha().randomWordList.contains(e.getMessage()) || Arrays.asList(ChatCaptcha.getChatCaptcha().customWordList).contains(e.getMessage())) {
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                }
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
                    CaptchaFile.getCaptchaFile().addNameToList(p.getName());
                }
                Captcha.getCaptcha().playerInChatCaptcha.remove(p);
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                ChatCaptcha.getChatCaptcha().randomWordList.remove(e.getMessage());
                ChatCaptcha.getChatCaptcha().temporaryWordList.remove(e.getMessage());
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                    StatisticsFile.getStatisticsFile().addApprovedPlayer();
                    StatisticsFile.getStatisticsFile().doneChatCaptcha();
                }
                return;
            }
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                StatisticsFile.getStatisticsFile().addFailedPlayer();
            }
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseBWaves")) {
                if (TemporaryFile.getTemporaryFile().getFails(p.getName()) > 5) {
                    BanFile.getBanFile().banPlayer(p.getName());
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptcha")));
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptcha")));
                        return;
                    }
                } else {
                    TemporaryFile.getTemporaryFile().addFail(p.getName());
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptcha")));
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptcha")));
                        return;
                    }
                }
            } else {
                Log.getLog().log(String.valueOf(p.getName()) + " failed the captcha!");
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                    Bukkit.getScheduler().runTask((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptcha")));
                        }
                    });
                } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                    Bukkit.getScheduler().runTask((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptcha")));
                        }
                    });
                }
            }
        }
        if (Captcha.getCaptcha().playerInCaptcha.contains(p)) {
            e.setCancelled(true);
        }
    }
}

