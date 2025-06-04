/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  net.md_5.bungee.api.chat.BaseComponent
 *  net.md_5.bungee.api.chat.ClickEvent
 *  net.md_5.bungee.api.chat.ClickEvent$Action
 *  net.md_5.bungee.api.chat.ComponentBuilder
 *  net.md_5.bungee.api.chat.HoverEvent
 *  net.md_5.bungee.api.chat.HoverEvent$Action
 *  net.md_5.bungee.api.chat.TextComponent
 *  org.bukkit.entity.Player
 */
package de.tofastforyou.logcaptcha.api.captcha;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.LanguageFile;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ClickChatCaptcha {
    private static ClickChatCaptcha ccc = new ClickChatCaptcha();
    public List<String> randomWordList = new ArrayList<String>();
    public List<String> temporaryWordList = new ArrayList<String>();
    public ArrayList<Player> inClickCaptcha = new ArrayList();
    private Random r = new Random();

    public static ClickChatCaptcha getClickChatCaptcha() {
        return ccc;
    }

    public String getCaptchaWord() {
        String CaptchaWord = Integer.toHexString(this.r.nextInt(99999));
        this.randomWordList.add(CaptchaWord);
        return CaptchaWord;
    }

    public void sendCaptcha(Player p, String captchaWord) {
        this.inClickCaptcha.add(p);
        if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) {
            TextComponent tc = new TextComponent();
            tc.setText(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.ClickChatCaptchaMessage")));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("en-EN.Messages.ClickChatCaptchaHoverMessage"))).create()));
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/captchaprove " + captchaWord));
            p.spigot().sendMessage((BaseComponent)tc);
        } else if (LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) {
            TextComponent tc = new TextComponent();
            tc.setText(String.valueOf(Vars.getVars().pr) + ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.ClickChatCaptchaMessage")));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes((char)'&', (String)LanguageFile.getLanguageFile().langCfg.getString("de-DE.Messages.ClickChatCaptchaHoverMessage"))).create()));
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/captchaprove " + captchaWord));
            p.spigot().sendMessage((BaseComponent)tc);
        }
    }
}

