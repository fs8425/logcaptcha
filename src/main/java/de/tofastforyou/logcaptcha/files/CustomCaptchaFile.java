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

public class CustomCaptchaFile {
    private static CustomCaptchaFile ccf = new CustomCaptchaFile();
    public File customCaptchaFile = new File("plugins//logCaptcha//customCaptcha.yml");
    public YamlConfiguration customCaptchaCfg = YamlConfiguration.loadConfiguration((File)this.customCaptchaFile);

    public static CustomCaptchaFile getCustomCaptchaFile() {
        return ccf;
    }

    public void saveFile() {
        try {
            this.customCaptchaCfg.save(this.customCaptchaFile);
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_SAVE_FAIL, this.getClass().getName(), "Could not save the customCaptcha.yml file.");
        }
    }

    public void loadDefault() {
        String[] defaultCorrectAnswerList = new String[]{"&aSample1", "&aSample2"};
        String[] defaultCustomQuestionList = new String[]{"&7Question for &esample1", "&7Question for &esample2"};
        String[] defaultCustomWordsList = new String[]{"Sample1", "Sample2"};
        this.customCaptchaCfg.addDefault("CorrectAnswerList", (Object)defaultCorrectAnswerList);
        this.customCaptchaCfg.addDefault("CustomQuestionList", (Object)defaultCustomQuestionList);
        this.customCaptchaCfg.addDefault("CustomChatWordsList", (Object)defaultCustomWordsList);
        this.customCaptchaCfg.options().copyDefaults(true);
        this.saveFile();
    }
}

