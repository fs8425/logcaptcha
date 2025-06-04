/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.Bukkit
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package de.tofastforyou.logcaptcha.commands;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.captcha.ChatCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.InventoryCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.SteeringCaptcha;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import de.tofastforyou.logcaptcha.utils.Log;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CaptchaCommand
implements CommandExecutor {
    private Random r = new Random();
    int CaptchaID = this.r.nextInt(21) + 1;
    int rndmNumber = this.r.nextInt(4) + 1;
    int rndmFinishNumber = this.r.nextInt(28) + 2;
    int waitingTime = LogCaptcha.getInstance().getConfig().getInt("logCaptcha.Options.WaitingTime");
    int seconds = this.waitingTime * 20;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p;
        if (cmd.getName().equalsIgnoreCase("captcha") && sender instanceof Player && (p = (Player)sender).hasPermission(LogCaptcha.getInstance().getConfig().getString("logCaptcha.Permissions.CaptchaCMD"))) {
            if (args.length > 1) {
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                    sender.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.CaptchaUsage")));
                    return true;
                }
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                    sender.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.CaptchaUsage")));
                    return true;
                }
            }
            if (args.length == 0) {
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseChatCaptcha")) {
                    Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c seconds!");
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c Sekungen Zeit!");
                            }
                            ChatCaptcha.getChatCaptcha().sendCaptcha(p, ChatCaptcha.getChatCaptcha().getCaptchaWord());
                            Captcha.getCaptcha().playerInChatCaptcha.add(p);
                        }
                    }, 20L);
                } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseInventoryCaptcha")) {
                    Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            InventoryCaptcha.getInventoryCaptcha().openCaptcha(CaptchaCommand.this.CaptchaID, p);
                            Captcha.getCaptcha().playerInCaptcha.add(p);
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c seconds!");
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c Sekungen Zeit!");
                            }
                        }
                    }, 20L);
                } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseRaisingCaptcha")) {
                    TemporaryFile.getTemporaryFile().setNumber(p.getName(), this.rndmNumber);
                    TemporaryFile.getTemporaryFile().setFinishNumber(p.getName(), this.rndmFinishNumber);
                    Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            SteeringCaptcha.getSteeringCaptcha().openCaptcha(p);
                            Captcha.getCaptcha().playerInCaptcha.add(p);
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c seconds!");
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c Sekungen Zeit!");
                            }
                        }
                    }, 20L);
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
                }, (long)this.seconds);
            }
            if (args.length == 1) {
                final Player target = Bukkit.getPlayer((String)args[0]);
                if (target == null) {
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        sender.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.PlayerNotAvailable")));
                        return true;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        sender.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.PlayerNotAvailable")));
                        return true;
                    }
                }
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseChatCaptcha")) {
                    Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c seconds!");
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c Sekungen Zeit!");
                            }
                            ChatCaptcha.getChatCaptcha().sendCaptcha(target, ChatCaptcha.getChatCaptcha().getCaptchaWord());
                            Captcha.getCaptcha().playerInChatCaptcha.add(target);
                        }
                    }, 20L);
                } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseInventoryCaptcha")) {
                    Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            InventoryCaptcha.getInventoryCaptcha().openCaptcha(CaptchaCommand.this.CaptchaID, target);
                            Captcha.getCaptcha().playerInCaptcha.add(target);
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c seconds!");
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c Sekungen Zeit!");
                            }
                        }
                    }, 20L);
                } else if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseRaisingCaptcha")) {
                    TemporaryFile.getTemporaryFile().setNumber(target.getName(), this.rndmNumber);
                    TemporaryFile.getTemporaryFile().setFinishNumber(target.getName(), this.rndmFinishNumber);
                    Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                        @Override
                        public void run() {
                            SteeringCaptcha.getSteeringCaptcha().openCaptcha(target);
                            Captcha.getCaptcha().playerInCaptcha.add(target);
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.JoinMessage")));
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYou have to do this in \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c seconds!");
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.JoinMessage")));
                                target.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDu hast daf\u00fcr \u00a7e" + CaptchaCommand.this.waitingTime + "\u00a7c Sekungen Zeit!");
                            }
                        }
                    }, 20L);
                }
                Bukkit.getScheduler().runTaskLater((Plugin)LogCaptcha.getInstance(), new Runnable(){

                    @Override
                    public void run() {
                        if (Captcha.getCaptcha().playerInCaptcha.contains(target) || Captcha.getCaptcha().playerInChatCaptcha.contains(target)) {
                            Log.getLog().log(String.valueOf(target.getName()) + " failed to solve the captcha in time!");
                            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                                target.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptchaInTime")));
                            } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                                target.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptchaInTime")));
                            }
                        }
                    }
                }, (long)this.seconds);
            }
        }
        return false;
    }
}

