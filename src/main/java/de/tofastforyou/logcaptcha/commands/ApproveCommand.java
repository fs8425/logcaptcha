/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package de.tofastforyou.logcaptcha.commands;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.captcha.ClickChatCaptcha;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.utils.Vars;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ApproveCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("captchaprove")) {
            Player p = (Player)sender;
            if (ClickChatCaptcha.getClickChatCaptcha().inClickCaptcha.contains(p)) {
                if (args.length > 1) {
                    p.sendMessage("\u00a7cUnknown command syntax!");
                    return true;
                }
                if (args.length == 1) {
                    if (ClickChatCaptcha.getClickChatCaptcha().randomWordList.contains(args[0])) {
                        Captcha.getCaptcha().playerInCaptcha.remove(p);
                        ClickChatCaptcha.getClickChatCaptcha().inClickCaptcha.remove(p);
                        ClickChatCaptcha.getClickChatCaptcha().randomWordList.remove(args[0]);
                        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                            p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                            return true;
                        }
                        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                            p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                            return true;
                        }
                    } else {
                        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cYour code is incorrect!");
                            return true;
                        }
                        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDein Code ist nicht korrekt!");
                            return true;
                        }
                    }
                }
                if (args.length < 1) {
                    p.sendMessage("\u00a7cUnknown command syntax!");
                    return true;
                }
            } else {
                p.sendMessage("\u00a7cYou're not in captcha!");
                return true;
            }
        }
        return false;
    }
}

