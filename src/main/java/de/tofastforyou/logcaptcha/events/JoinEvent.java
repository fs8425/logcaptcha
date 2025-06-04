/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.plugin.Plugin
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.bwaves.files.BanFile;
import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.captcha.ChatCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.ClickChatCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.InventoryCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.SquareCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.SteeringCaptcha;
import de.tofastforyou.logcaptcha.files.CaptchaFile;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import de.tofastforyou.logcaptcha.utils.Log;
import de.tofastforyou.logcaptcha.utils.Updater;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class JoinEvent
implements Listener {
    private Random r = new Random();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final int CaptchaID = this.r.nextInt(21) + 1;
        int rndmNumber = this.r.nextInt(4) + 1;
        int rndmFinishNumber = this.r.nextInt(28) + 2;
        long checkCooldown = LogCaptcha.getInstance().getConfig().getInt("logCaptcha.Options.CheckCooldown") * 20;
        final int waitingTime = LogCaptcha.getInstance().getConfig().getInt("logCaptcha.Options.WaitingTime");
        int seconds = waitingTime * 20;
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
            StatisticsFile.getStatisticsFile().addPlayerJoined();
        }
        if (!TemporaryFile.getTemporaryFile().getPlayerList().contains(p.getName())) {
            TemporaryFile.getTemporaryFile().addPlayerToList(p.getName());
        }
        if (BanFile.getBanFile().isBanned(p.getName())) {
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.BannedByBWaves")));
            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.BannedByBWaves")));
            }
        }
        if (CaptchaFile.getCaptchaFile().isInList(p.getName())) {
            return;
        }
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseChatCaptcha")) {
            Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                @Override
                public void run() {
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + waitingTime + "\u00a7c seconds!");
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + waitingTime + "\u00a7c Sekungen Zeit!");
                    }
                    ChatCaptcha.getChatCaptcha().sendCaptcha(p, ChatCaptcha.getChatCaptcha().getCaptchaWord());
                    Captcha.getCaptcha().playerInChatCaptcha.add(p);
                }
            }, checkCooldown);
        } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseInventoryCaptcha")) {
            Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                @Override
                public void run() {
                    InventoryCaptcha.getInventoryCaptcha().openCaptcha(CaptchaID, p);
                    Captcha.getCaptcha().playerInCaptcha.add(p);
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + waitingTime + "\u00a7c seconds!");
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + waitingTime + "\u00a7c Sekungen Zeit!");
                    }
                }
            }, checkCooldown);
        } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseRaisingCaptcha")) {
            TemporaryFile.getTemporaryFile().setNumber(p.getName(), rndmNumber);
            TemporaryFile.getTemporaryFile().setFinishNumber(p.getName(), rndmFinishNumber);
            Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                @Override
                public void run() {
                    SteeringCaptcha.getSteeringCaptcha().openCaptcha(p);
                    Captcha.getCaptcha().playerInCaptcha.add(p);
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + waitingTime + "\u00a7c seconds!");
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + waitingTime + "\u00a7c Sekungen Zeit!");
                    }
                }
            }, checkCooldown);
        } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseClickChatCaptcha")) {
            Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                @Override
                public void run() {
                    ClickChatCaptcha.getClickChatCaptcha().sendCaptcha(p, ClickChatCaptcha.getClickChatCaptcha().getCaptchaWord());
                    Captcha.getCaptcha().playerInCaptcha.add(p);
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + waitingTime + "\u00a7c seconds!");
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + waitingTime + "\u00a7c Sekungen Zeit!");
                    }
                }
            }, checkCooldown);
        } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseSquareCaptcha")) {
            Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                @Override
                public void run() {
                    SquareCaptcha.getSquareCaptcha().openCaptcha(p);
                    Captcha.getCaptcha().playerInCaptcha.add(p);
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + waitingTime + "\u00a7c seconds!");
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + waitingTime + "\u00a7c Sekungen Zeit!");
                    }
                }
            }, checkCooldown);
        }
        Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

            @Override
            public void run() {
                if (Captcha.getCaptcha().playerInCaptcha.contains(p) || Captcha.getCaptcha().playerInChatCaptcha.contains(p)) {
                    Log.getLog().log(String.valueOf(p.getName()) + " failed to solve the captcha in time!");
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptchaInTime")));
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptchaInTime")));
                    }
                }
            }
        }, checkCooldown + (long)seconds);
    }
}

