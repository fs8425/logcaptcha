/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.entity.Player
 */
package de.tofastforyou.logcaptcha.api.captcha;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.CustomCaptchaFile;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class ChatCaptcha {
    public static ChatCaptcha chatcaptcha = new ChatCaptcha();
    public String[] wordListEn = new String[]{"Apple", "Banana", "Truck", "Car", "House", "Wall", "Plugin", "Captcha", "Language", "Song", "Music", "Castle", "Face", "Punch", "Life", "Season", "Soccer", "Rugby", "Whisky", "Damage", "Lava", "Turtle", "Chair", "Ignorant", "Bus", "Sketch", "Husband", "History", "Bolt", "Warn", "Realism", "Think", "Passage", "Ball", "Dog", "Throw", "Access", "Patrol", "Engine", "Critic", "Cat", "Wheel", "Indoor", "Insurance", "Glory", "Expectation", "Partner", "Happen", "Evoke", "Innovation", "Facade", "Initiative"};
    public String[] wordListDe = new String[]{"Apfel", "Banane", "Truck", "Auto", "Haus", "Wand", "Plugin", "Captcha", "Sprache", "Lied", "Musik", "Burg", "Gesicht", "Schlag", "Leben", "Saison", "Fussball", "Rugby", "Whisky", "Schaden", "Lava", "Schildkr\u00f6te", "Stuhl", "Ignorant", "Bus", "Entwerfen", "Ehemann", "Geschichte", "Bolzen", "Warnen", "Realismus", "Denken", "Passage", "Ball", "Hund", "Zugriff", "Werfen", "\u00dcberwachen", "Motor", "Kritik", "Katze", "Rad", "Innen", "Versicherung", "Ruhm", "Erwartung", "Partner", "Geschehen", "Hervorrufen", "Innovation", "Fassade", "Initiative"};
    public ArrayList<String> customWordList;
    public List<String> randomWordList;
    public List<String> temporaryWordList;
    private Random r;

    public ChatCaptcha() {
        this.customWordList = (ArrayList)CustomCaptchaFile.getCustomCaptchaFile().customCaptchaCfg.get("CustomChatWordsList");
        this.randomWordList = new ArrayList<String>();
        this.temporaryWordList = new ArrayList<String>();
        this.r = new Random();
    }

    public static ChatCaptcha getChatCaptcha() {
        return chatcaptcha;
    }

    public String getCaptchaWord() {
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.UseCustomCaptchas")) {
            String CaptchaWord = this.customWordList.get(this.r.nextInt(this.customWordList.size()));
            this.temporaryWordList.add(CaptchaWord);
            return CaptchaWord;
        }
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.ChatCaptcha.UseRandomizedChars")) {
            String CaptchaWord = Integer.toHexString(this.r.nextInt(99999));
            this.randomWordList.add(CaptchaWord);
            return CaptchaWord;
        }
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            String CaptchaWord = this.wordListEn[this.r.nextInt(this.wordListEn.length)];
            this.temporaryWordList.add(CaptchaWord);
            return CaptchaWord;
        }
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
            String CaptchaWord = this.wordListDe[this.r.nextInt(this.wordListDe.length)];
            this.temporaryWordList.add(CaptchaWord);
            return CaptchaWord;
        }
        return null;
    }

    public void sendCaptcha(Player p, String captchaWord) {
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            String msg = String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)("&cType &e" + captchaWord + " &cin the &echat &cto solve the &ecaptcha&c!"));
            p.sendMessage(msg);
        } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
            String msg = String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)("&cGebe &e" + captchaWord + " \u00a7cin den &eChat &cein, um das &eCaptcha &czu l\u00f6sen!"));
            p.sendMessage(msg);
        }
    }
}

