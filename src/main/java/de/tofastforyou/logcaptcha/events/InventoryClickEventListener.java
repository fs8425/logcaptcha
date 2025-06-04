/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Sound
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.ItemStack
 */
package de.tofastforyou.logcaptcha.events;

import de.tofastforyou.bwaves.files.BanFile;
import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.api.captcha.Captcha;
import de.tofastforyou.logcaptcha.api.item.ItemCreator;
import de.tofastforyou.logcaptcha.files.CaptchaFile;
import de.tofastforyou.logcaptcha.files.CustomCaptchaFile;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import de.tofastforyou.logcaptcha.utils.ListUser;
import de.tofastforyou.logcaptcha.utils.Log;
import de.tofastforyou.logcaptcha.utils.Vars;
import de.tofastforyou.logcaptcha.utils.XMaterial;
import de.tofastforyou.logcaptcha.utils.inventories.ConfirmationInventory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEventListener
implements Listener {
    private ArrayList<String> correctAnswerList;

    public InventoryClickEventListener() {
        this.correctAnswerList = (ArrayList)CustomCaptchaFile.getCustomCaptchaFile().customCaptchaCfg.get("CorrectAnswerList");
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (e.getView().getTitle().contains("Captcha")) {
            e.setCancelled(true);
            if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.UseCustomCaptchas")) {
                if (this.correctAnswerList.contains(e.getCurrentItem().getItemMeta().getDisplayName())) {
                    Captcha.getCaptcha().playerInCaptcha.remove(p);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                        StatisticsFile.getStatisticsFile().addApprovedPlayer();
                        StatisticsFile.getStatisticsFile().doneInventoryCaptcha();
                    }
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
                        CaptchaFile.getCaptchaFile().addNameToList(p.getName());
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                } else if ((e.getCurrentItem().getType().equals((Object)XMaterial.BLACK_STAINED_GLASS_PANE.parseItem()) || e.getCurrentItem().getType().equals((Object)XMaterial.SIGN.parseItem())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a70") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7eQuestion") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7eFrage"))) {
                    e.setCancelled(true);
                } else {
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
                            p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptcha")));
                            return;
                        }
                        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                            p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptcha")));
                            return;
                        }
                    }
                }
            } else if (Arrays.asList(Captcha.getCaptcha().invCaptchaSolutionList).contains(e.getCurrentItem().getItemMeta().getDisplayName())) {
                Captcha.getCaptcha().playerInCaptcha.remove(p);
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                    StatisticsFile.getStatisticsFile().addApprovedPlayer();
                    StatisticsFile.getStatisticsFile().doneInventoryCaptcha();
                }
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
                    CaptchaFile.getCaptchaFile().addNameToList(p.getName());
                }
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                    p.closeInventory();
                    return;
                }
                if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                    p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                    p.closeInventory();
                    return;
                }
            } else if ((e.getCurrentItem().getType().equals((Object)XMaterial.BLACK_STAINED_GLASS_PANE.parseItem()) || e.getCurrentItem().getType().equals((Object)XMaterial.SIGN.parseItem())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a70") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7eQuestion") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7eFrage"))) {
                e.setCancelled(true);
            } else {
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
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptcha")));
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptcha")));
                        return;
                    }
                }
            }
        } else if (e.getView().getTitle().contains("Raise")) {
            ItemStack number;
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7a+1")) {
                if (TemporaryFile.getTemporaryFile().getNumber(p.getName()) > TemporaryFile.getTemporaryFile().getFinishNumber(p.getName()) - 1 || TemporaryFile.getTemporaryFile().getNumber(p.getName()) == TemporaryFile.getTemporaryFile().getFinishNumber(p.getName()) - 1) {
                    TemporaryFile.getTemporaryFile().setNumber(p.getName(), 0);
                    Captcha.getCaptcha().playerInCaptcha.remove(p);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                        StatisticsFile.getStatisticsFile().addApprovedPlayer();
                    }
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
                        CaptchaFile.getCaptchaFile().addNameToList(p.getName());
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                }
                TemporaryFile.getTemporaryFile().setNumber(p.getName(), TemporaryFile.getTemporaryFile().getNumber(p.getName()) + 1);
                number = ItemCreator.getItemCreator().createItem("\u00a7a" + Integer.toString(TemporaryFile.getTemporaryFile().getNumber(p.getName())), 1, XMaterial.BLACK_WOOL.parseMaterial());
                e.getInventory().setItem(13, number);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7c-1")) {
                if (TemporaryFile.getTemporaryFile().getNumber(p.getName()) > TemporaryFile.getTemporaryFile().getFinishNumber(p.getName()) - 1 || TemporaryFile.getTemporaryFile().getNumber(p.getName()) == TemporaryFile.getTemporaryFile().getFinishNumber(p.getName()) - 1) {
                    TemporaryFile.getTemporaryFile().setNumber(p.getName(), 0);
                    Captcha.getCaptcha().playerInCaptcha.remove(p);
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                        StatisticsFile.getStatisticsFile().addApprovedPlayer();
                    }
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
                        CaptchaFile.getCaptchaFile().addNameToList(p.getName());
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                }
                TemporaryFile.getTemporaryFile().setNumber(p.getName(), TemporaryFile.getTemporaryFile().getNumber(p.getName()) - 1);
                number = ItemCreator.getItemCreator().createItem("\u00a7a" + Integer.toString(TemporaryFile.getTemporaryFile().getNumber(p.getName())), 1, XMaterial.BLACK_WOOL.parseMaterial());
                e.getInventory().setItem(13, number);
            }
        } else if (e.getView().getTitle().equals("\u00a7aSquare")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("\u00a7a")) {
                if (TemporaryFile.getTemporaryFile().getProgress(p.getName()) == TemporaryFile.getTemporaryFile().getProgressFinish(p.getName()) - 1) {
                    Captcha.getCaptcha().playerInCaptcha.remove(p);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                    TemporaryFile.getTemporaryFile().setProgressFinish(p.getName(), 0);
                    TemporaryFile.getTemporaryFile().setProgress(p.getName(), 0);
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                        StatisticsFile.getStatisticsFile().addApprovedPlayer();
                        StatisticsFile.getStatisticsFile().doneInventoryCaptcha();
                    }
                    if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.SaveAlreadyDone")) {
                        CaptchaFile.getCaptchaFile().addNameToList(p.getName());
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.SuccessCaptcha")));
                        p.closeInventory();
                        return;
                    }
                } else {
                    TemporaryFile.getTemporaryFile().addProgress(p.getName());
                    if (e.getRawSlot() == -999) {
                        return;
                    }
                    ItemStack wrong = ItemCreator.getItemCreator().createItem("\u00a7c", 1, XMaterial.RED_TERRACOTTA.parseMaterial());
                    e.getInventory().setItem(e.getRawSlot(), wrong);
                }
            } else {
                TemporaryFile.getTemporaryFile().setProgress(p.getName(), 0);
                TemporaryFile.getTemporaryFile().setProgressFinish(p.getName(), 0);
                if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
                    StatisticsFile.getStatisticsFile().addFailedPlayer();
                    Log.getLog().log(String.valueOf(p.getName()) + " failed the captcha!");
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.FailedCaptcha")));
                        return;
                    }
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.kickPlayer(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.FailedCaptcha")));
                        return;
                    }
                }
            }
        } else if (e.getView().getTitle().equals("\u00a7aMenu") || e.getView().getTitle().equals("\u00a7aMen\u00fc")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7cReset AlradyDoneList") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7cSetze die AlreadyDoneList zur\u00fcck")) {
                TemporaryFile.getTemporaryFile().setAction(p.getName(), "resetList");
                ConfirmationInventory.getConfirmationInventory().openInventory(p);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a77List all \u00a7euser") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a77Liste alle \u00a7eSpieler \u00a77auf")) {
                p.closeInventory();
                ListUser.getListUser().listAllUser(p);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a74Reset config file") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a74Setze die Config Datei zur\u00fcck")) {
                TemporaryFile.getTemporaryFile().setAction(p.getName(), "resetConfig");
                ConfirmationInventory.getConfirmationInventory().openInventory(p);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a77Check for \u00a7eUpdates") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a77\u00dcberpr\u00fcfe auf \u00a7eUpdates")) {
                p.closeInventory();
                Bukkit.dispatchCommand((CommandSender)p, (String)"logcaptcha update");
            }
        } else if (e.getView().getTitle().equals("\u00a7aAre you sure?") || e.getView().getTitle().equals("\u00a7aBist du dir sicher?")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7aYes") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7aJa")) {
                p.closeInventory();
                if (TemporaryFile.getTemporaryFile().getAction(p.getName()).equals("resetList")) {
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.ResetList")));
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.ResetList")));
                    }
                    CaptchaFile.getCaptchaFile().captchaCfg.set("TemporaryNoCaptcha", null);
                    CaptchaFile.getCaptchaFile().saveFile();
                } else if (TemporaryFile.getTemporaryFile().getAction(p.getName()).equals("resetConfig")) {
                    p.closeInventory();
                    if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.ResetConfig")));
                    } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
                        p.sendMessage(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.ResetConfig")));
                    }
                    File cfg = new File(LogCaptcha.getInstance().getDataFolder(), "config.yml");
                    cfg.delete();
                    LogCaptcha.getInstance().saveDefaultConfig();
                    LogCaptcha.getInstance().reloadConfig();
                    Bukkit.getConsoleSender().sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a74WARNING: Config resetted!");
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7cNo") || e.getCurrentItem().getItemMeta().getDisplayName().equals("\u00a7cNein")) {
                p.closeInventory();
            }
        }
    }
}

