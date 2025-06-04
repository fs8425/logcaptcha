/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package de.tofastforyou.logcaptcha.files;

import de.tofastforyou.logcaptcha.utils.ErrorSaver;
import de.tofastforyou.logcaptcha.utils.ErrorTypes;
import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public class LanguageFile {
    public static LanguageFile languagefile = new LanguageFile();
    public File langFile = new File("plugins//logCaptcha//Languages//Languages.yml");
    public YamlConfiguration langCfg = YamlConfiguration.loadConfiguration((File)this.langFile);

    public static LanguageFile getLanguageFile() {
        return languagefile;
    }

    public void saveFile() {
        try {
            this.langCfg.save(this.langFile);
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_SAVE_FAIL, this.getClass().getName(), "Could not save the Languages.yml file.");
        }
    }

    public void loadDefaultLanguages() {
        this.langCfg.addDefault("en-EN.Messages.FailedCaptcha", (Object)"&cYou failed the &ecaptcha&c!");
        this.langCfg.addDefault("en-EN.Messages.SuccessCaptcha", (Object)"&aYou successed the &ecaptcha&a!");
        this.langCfg.addDefault("en-EN.Messages.CaptchaUsage", (Object)"&cUsage: &4/captcha [Playername] - Checks a player manually");
        this.langCfg.addDefault("en-EN.Messages.JoinMessage", (Object)"&cPass the &ecaptcha&c!");
        this.langCfg.addDefault("en-EN.Messages.MoveMessage", (Object)"&cYou cant move until you passed the &ecaptcha&c!");
        this.langCfg.addDefault("en-EN.Messages.FailedCaptchaInTime", (Object)"&cYou needed to much time to solve the &ecaptcha&c!");
        this.langCfg.addDefault("en-EN.Messages.BannedByBWaves", (Object)"&cYou are banned for failing the &ecaptchas &cmore than &45 &ctimes!");
        this.langCfg.addDefault("en-EN.Messages.PlayerNotAvailable", (Object)"&cThis player is not online!");
        this.langCfg.addDefault("en-EN.Messages.OpenManagementGUI", (Object)"&7Opening &eManagement-GUI&7...");
        this.langCfg.addDefault("en-EN.Messages.LogBanUsage", (Object)"&cUsage: /logban <Player>");
        this.langCfg.addDefault("en-EN.Messages.PlayerBanned", (Object)"&cYou added the player to the &ebWaves \u00a7cbans!");
        this.langCfg.addDefault("en-EN.Messages.ResetList", (Object)"&7You reset the &eAlreadyDoneList&7!");
        this.langCfg.addDefault("en-EN.Messages.ResetConfig", (Object)"&7You reset the &econfig file&7!");
        this.langCfg.addDefault("en-EN.Messages.ClickChatCaptchaMessage", (Object)"&c&lClick on &e&lthis &c&ltext to &e&lprove &c&lthat you're &c&lnot a &4&lbot&c&l!");
        this.langCfg.addDefault("en-EN.Messages.ClickChatCaptchaHoverMessage", (Object)"&cClick on &ethis &ctext to &eprove &cthat you're not a &4bot&c!");
        this.langCfg.addDefault("de-DE.Messages.FailedCaptcha", (Object)"&cDu hast das &eCaptcha &cnicht bestanden!");
        this.langCfg.addDefault("de-DE.Messages.SuccessCaptcha", (Object)"&aDu hast das &eCaptcha &abestanden!");
        this.langCfg.addDefault("de-DE.Messages.CaptchaUsage", (Object)"&cBenutze: &4/captcha [Playername] - Checkt einen Spieler manuell");
        this.langCfg.addDefault("de-DE.Messages.JoinMessage", (Object)"&cBestehe zuerst das &cCaptcha&c!");
        this.langCfg.addDefault("de-DE.Messages.MoveMessage", (Object)"&cDu kannst dich nicht bewegen bis du das &eCaptcha &cbestanden hast!");
        this.langCfg.addDefault("de-DE.Messages.FailedCaptchaInTime", (Object)"&cDu hast zu viel Zeit f\u00fcr das &eCaptcha &cgebraucht!");
        this.langCfg.addDefault("de-DE.Messages.BannedByBWaves", (Object)"&cDu wurdest gebannt, weil du mehr als &45 &cMal ein &eCaptcha &cnicht bestanden hast!");
        this.langCfg.addDefault("de-DE.Messages.PlayerNotAvailable", (Object)"\u00a7cDieser Spieler ist nicht online!");
        this.langCfg.addDefault("de-DE.Messages.OpenManagementGUI", (Object)"&7\u00d6ffne &eManagement-GUI&7...");
        this.langCfg.addDefault("de-DE.Messages.LogBanUsage", (Object)"&cBenutze: /logban <Spieler>");
        this.langCfg.addDefault("de-DE.Messages.PlayerBanned", (Object)"&cDu hast den Spieler zu den &ebWaves &cbans hinzugef\u00fcgt!");
        this.langCfg.addDefault("de-DE.Messages.ResetList", (Object)"&7Du hast die &eAlreadyDone-Liste &7zur\u00fcckgesetzt!");
        this.langCfg.addDefault("de-DE.Messages.ResetConfig", (Object)"&7Du hast die &eConfig Datei &7zur\u00fcckgesetzt!");
        this.langCfg.addDefault("de-DE.Messages.ClickChatCaptchaMessage", (Object)"&c&lKlicke &e&lhier &c&lum zu beweisen, dass du kein &4&lBot &c&lbist!");
        this.langCfg.addDefault("de-DE.Messages.ClickChatCaptchaHoverMessage", (Object)"&cKlicke &ehier &cum zu beweisen, dass du kein &4Bot &cbist!");
        this.langCfg.addDefault("Ver", (Object)"1.1");
        this.langCfg.options().copyDefaults(true);
        this.saveFile();
    }

    public String getVersion() {
        return this.langCfg.getString("Ver");
    }
}

