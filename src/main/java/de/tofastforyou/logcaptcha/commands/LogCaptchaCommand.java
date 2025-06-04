/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Sound
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package de.tofastforyou.logcaptcha.commands;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.CaptchaFile;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.utils.Countdown;
import de.tofastforyou.logcaptcha.utils.Statistics;
import de.tofastforyou.logcaptcha.utils.Updater;
import de.tofastforyou.logcaptcha.utils.Vars;
import de.tofastforyou.logcaptcha.utils.VersionCheck;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LogCaptchaCommand
implements CommandExecutor {
    private int solvedCaptcha = StatisticsFile.getStatisticsFile().getApprovedPlayer();
    private int failedCaptcha = StatisticsFile.getStatisticsFile().getFailedPlayer();
    private int doneChatCaptcha = StatisticsFile.getStatisticsFile().getDoneChatCaptcha();
    private int doneInvCaptcha = StatisticsFile.getStatisticsFile().getDoneInventoryCaptcha();
    private int triedToMove = StatisticsFile.getStatisticsFile().getPlayerTriedMove();
    private int triedCommand = StatisticsFile.getStatisticsFile().getPlayerTriedCommand();
    private int closedInventory = StatisticsFile.getStatisticsFile().getPlayerClosedInventory();

    /*
     * Enabled aggressive block sorting
     */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("logcaptcha")) return false;
        if (!(sender instanceof Player)) return false;
        Player p = (Player)sender;
        if (args.length == 0 || args.length > 1) {
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00a7lInformation:");
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Plugin version: \u00a7e" + LogCaptcha.getInstance().getDescription().getVersion());
                //p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Is update available: \u00a7e" + Boolean.toString(Updater.getUpdater().isUpdate(LogCaptcha.getInstance().getResourceID())));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Build Number: \u00a7e" + Integer.toString(LogCaptcha.getInstance().getConfig().getInt("logCaptcha.Build")));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Plugin language: \u00a7e" + LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language"));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Server version: \u00a7e" + Bukkit.getServer().getBukkitVersion());
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Is version compatible: \u00a7e" + Boolean.toString(VersionCheck.getVersionCheck().isVersionCompatible(Bukkit.getServer().getBukkitVersion())));
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.ResetAlreadyDoneList")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Current reset list countdown: \u00a7e" + Integer.toString(Countdown.getCountdown().secs));
                }
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77This plugin uses \u00a7ebStats\u00a77!");
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Thanks for downloading!");
                return false;
            }
            if (!LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) return false;
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00a7lInformation:");
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Plugin Version: \u00a7e" + LogCaptcha.getInstance().getDescription().getVersion());
            //p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Ist ein Update verf\u00fcgbar: \u00a7e" + Boolean.toString(Updater.getUpdater().isUpdate(LogCaptcha.getInstance().getResourceID())));
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Buildnummer: \u00a7e" + Integer.toString(LogCaptcha.getInstance().getConfig().getInt("logCaptcha.Build")));
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Plugin Sprache: \u00a7e" + LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language"));
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Server Version: \u00a7e" + Bukkit.getServer().getBukkitVersion());
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Ist die Version kompatibel: \u00a7e" + Boolean.toString(VersionCheck.getVersionCheck().isVersionCompatible(Bukkit.getServer().getBukkitVersion())));
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.ResetAlreadyDoneList")) {
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Momentaner reset list Countdown: \u00a7e" + Integer.toString(Countdown.getCountdown().secs));
            }
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Dieses Plugin benutzt \u00a7ebStats\u00a77!");
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Vielen Dank f\u00fcr das downloaden!");
            return false;
        }
        if (args.length == 1 && args[0].equals("stats")) {
            if (!LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cThe stats are \u00a74disabled \u00a7cin the \u00a7econfig\u00a7c!");
                return true;
            }
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.ShowStatisticsInPercent")) {
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00a7lStats:");
                    p.sendMessage("\u00a7c\u00a7lAttention:");
                    p.sendMessage("\u00a7cAll percentages are rounded and may vary by approximately 1.");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Players in AlreadyDoneList: \u00a7e" + CaptchaFile.getCaptchaFile().captchaCfg.getStringList("TemporaryNoCaptcha").size());
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Solved captcha percentage: \u00a7e" + Float.toString(Statistics.getStats().getSolvedCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Failed captcha percentage: \u00a7e" + Float.toString(Statistics.getStats().getFailedCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Used chat captcha percentage: \u00a7e" + Float.toString(Statistics.getStats().getDoneChatCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Used inventory captcha percentage: \u00a7e" + Float.toString(Statistics.getStats().getDoneInvCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Tried command percentage: \u00a7e" + Float.toString(Statistics.getStats().getTriedCommandPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Tried to move percentage: \u00a7e" + Float.toString(Statistics.getStats().getTriedMovePercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Closed inventory in captcha percentage: \u00a7e" + Float.toString(Statistics.getStats().getClosedInventoryPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Log entrys: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getLogEntrys()));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Times players joined: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getPlayerJoined()));
                    return false;
                }
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00a7lStats:");
                    p.sendMessage("\u00a7c\u00a7lAchtung:");
                    p.sendMessage("\u00a7cAlle Prozentangaben sind gerundet und k\u00f6nnen um 1 abweichen.");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler in AlreadyDoneList: \u00a7e" + CaptchaFile.getCaptchaFile().captchaCfg.getStringList("TemporaryNoCaptcha").size());
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Captcha bestanden haben: \u00a7e" + Float.toString(Statistics.getStats().getSolvedCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Captcha nicht bestanden haben: \u00a7e" + Float.toString(Statistics.getStats().getFailedCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Chat Captcha benutzt haben: \u00a7e" + Float.toString(Statistics.getStats().getDoneChatCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Inventory Captcha benutzt haben: \u00a7e" + Float.toString(Statistics.getStats().getDoneInvCaptchaPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die versucht haben einen Command zu nutzen: \u00a7e" + Float.toString(Statistics.getStats().getTriedCommandPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die versucht haben sich zu bewegen: \u00a7e" + Float.toString(Statistics.getStats().getTriedMovePercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Inventar im Captcha geschlossen haben: \u00a7e" + Float.toString(Statistics.getStats().getClosedInventoryPercentage()) + "% ");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Log Eintr\u00e4ge: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getLogEntrys()));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Aufgezeichnete Spieler Joins: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getPlayerJoined()));
                    return false;
                }
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDie Statistiken sind in der \u00a7eConfig \u00a74deaktiviert\u00a7c!");
                return true;
            }
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00a7lStats:");
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Players in AlreadyDoneList: \u00a7e" + CaptchaFile.getCaptchaFile().captchaCfg.getStringList("TemporaryNoCaptcha").size());
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Solved captcha: \u00a7e" + Integer.toString(this.solvedCaptcha));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Failed captcha: \u00a7e" + Integer.toString(this.failedCaptcha));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Used chat captcha: \u00a7e" + Integer.toString(this.doneChatCaptcha));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Used inventory captcha: \u00a7e" + Integer.toString(this.doneInvCaptcha));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Closed inventory in captcha: \u00a7e" + Integer.toString(this.closedInventory));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Tried command: \u00a7e" + Integer.toString(this.triedCommand));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Tried to move: \u00a7e" + Integer.toString(this.triedToMove));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Log entrys: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getLogEntrys()));
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Times players joined: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getPlayerJoined()));
                    return false;
                }
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cThe stats are \u00a74disabled \u00a7cin the \u00a7econfig\u00a7c!");
                return true;
            }
            if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00a7lStats:");
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler in AlreadyDoneList: \u00a7e" + CaptchaFile.getCaptchaFile().captchaCfg.getStringList("TemporaryNoCaptcha").size());
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Captcha bestanden haben: \u00a7e" + Integer.toString(this.solvedCaptcha));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Captcha nicht bestanden haben: \u00a7e" + Integer.toString(this.failedCaptcha));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Chat Captcha benutzt haben: \u00a7e" + Integer.toString(this.doneChatCaptcha));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Inventory Captcha benutzt haben: \u00a7e" + Integer.toString(this.doneInvCaptcha));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die versucht haben einen Command zu nutzen: \u00a7e" + Integer.toString(this.triedCommand));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die versucht haben sich zu bewegen: \u00a7e" + Integer.toString(this.triedToMove));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Spieler, die das Inventar im Captcha geschlossen haben: \u00a7e" + Integer.toString(this.closedInventory));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Log Eintr\u00e4ge: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getLogEntrys()));
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Aufgezeichnete Spieler Joins: \u00a7e" + Integer.toString(StatisticsFile.getStatisticsFile().getPlayerJoined()));
                return false;
            }
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7cDie Statistiken sind in der \u00a7eConfig \u00a74deaktiviert\u00a7c!");
            return true;
        }
        if (args.length != 1) return false;
        if (!args[0].equalsIgnoreCase("update")) return false;
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Checking for updates...");
            if (Updater.getUpdater().isUpdate(LogCaptcha.getInstance().getResourceID())) {
                Updater.getUpdater().sendUpdateMessage(p);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
                return false;
            }
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7aYour version of \u00a7elogCaptcha \u00a7ais up to date!");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
            return false;
        }
        if (!LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) return false;
        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77\u00dcberpr\u00fcfe auf Updates...");
        if (Updater.getUpdater().isUpdate(LogCaptcha.getInstance().getResourceID())) {
            Updater.getUpdater().sendUpdateMessage(p);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
            return false;
        }
        p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a7aDeine Version von \u00a7elogCaptcha \u00a7aist auf dem neuesten Stand!");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        return false;
    }
}

