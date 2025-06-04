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
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;

public class CaptchaFile {
    private static CaptchaFile Captcha_File = new CaptchaFile();
    public File captchaFile = new File("plugins//logCaptcha//Captcha.yml");
    public YamlConfiguration captchaCfg = YamlConfiguration.loadConfiguration((File)this.captchaFile);

    public static CaptchaFile getCaptchaFile() {
        return Captcha_File;
    }

    public void addNameToList(String playerName) {
        if (!this.captchaFile.exists()) {
            if (this.captchaCfg.getStringList("TemporaryNoCaptcha") != null) {
                ArrayList<String> names = new ArrayList<String>();
                names.add(playerName);
                this.captchaCfg.set("TemporaryNoCaptcha", names);
                this.saveFile();
            }
        } else {
            List names = this.captchaCfg.getStringList("TemporaryNoCaptcha");
            names.add(playerName);
            this.captchaCfg.set("TemporaryNoCaptcha", (Object)names);
            this.saveFile();
        }
    }

    public boolean isInList(String playerName) {
        if (this.captchaFile.exists()) {
            List names = this.captchaCfg.getStringList("TemporaryNoCaptcha");
            return names.contains(playerName);
        }
        return false;
    }

    public void deleteList() {
        if (!this.captchaFile.exists()) {
            return;
        }
        this.captchaFile.delete();
    }

    public void saveFile() {
        try {
            this.captchaCfg.save(this.captchaFile);
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_SAVE_FAIL, this.getClass().getName(), "Could not save the captcha.yml file.");
        }
    }
}

