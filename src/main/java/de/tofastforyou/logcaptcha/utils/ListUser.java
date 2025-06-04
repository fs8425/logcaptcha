/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.chat.BaseComponent
 *  net.md_5.bungee.api.chat.ClickEvent
 *  net.md_5.bungee.api.chat.ClickEvent$Action
 *  net.md_5.bungee.api.chat.ComponentBuilder
 *  net.md_5.bungee.api.chat.HoverEvent
 *  net.md_5.bungee.api.chat.HoverEvent$Action
 *  net.md_5.bungee.api.chat.TextComponent
 *  org.bukkit.entity.Player
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.TemporaryFile;
import de.tofastforyou.logcaptcha.utils.ErrorSaver;
import de.tofastforyou.logcaptcha.utils.ErrorTypes;
import de.tofastforyou.logcaptcha.utils.Vars;
import java.util.concurrent.TimeUnit;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ListUser {
    private static ListUser listUser = new ListUser();

    public static ListUser getListUser() {
        return listUser;
    }

    public void listAllUser(Player p) {
        block11: {
            block10: {
                if (!LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("en-EN")) break block10;
                p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Loading \u00a7eplayer list\u00a77...");
                try {
                    TimeUnit.SECONDS.sleep(2L);
                }
                catch (InterruptedException e) {
                    ErrorSaver.getSaveError().saveError(ErrorTypes.UNKNOWN_ERROR, this.toString(), "Could not sleep thread.");
                }
                int i = 0;
                while (i < TemporaryFile.getTemporaryFile().getPlayerList().size()) {
                    TextComponent tc = new TextComponent();
                    tc.setText("\u00a77- \u00a7e" + TemporaryFile.getTemporaryFile().getPlayerList().get(i));
                    tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/logban " + TemporaryFile.getTemporaryFile().getPlayerList().get(i)));
                    tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("\u00a77Click \u00a7ehere \u00a77to add \u00a7e" + TemporaryFile.getTemporaryFile().getPlayerList().get(i) + "\u00a77 to the \u00a7ebWaves \u00a7cBanlist\u00a77!").create()));
                    String[] listAllUserMessage = new String[]{String.valueOf(Vars.getVars().pr) + "\u00a77List of all \u00a7eUsers\u00a77:"};
                    p.sendMessage(listAllUserMessage);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1500L);
                    }
                    catch (InterruptedException e) {
                        ErrorSaver.getSaveError().saveError(ErrorTypes.UNKNOWN_ERROR, this.toString(), "Could not sleep thread.");
                    }
                    p.spigot().sendMessage((BaseComponent)tc);
                    ++i;
                }
                break block11;
            }
            if (!LogCaptcha.getInstance().getConfig().getString("logCaptcha.Language").equals("de-DE")) break block11;
            p.sendMessage(String.valueOf(Vars.getVars().pr) + "\u00a77Lade \u00a7eSpieler Liste\u00a77...");
            try {
                TimeUnit.SECONDS.sleep(2L);
            }
            catch (InterruptedException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.UNKNOWN_ERROR, this.toString(), "Could not sleep thread.");
            }
            int i = 0;
            while (i < TemporaryFile.getTemporaryFile().getPlayerList().size()) {
                TextComponent tc = new TextComponent();
                tc.setText("\u00a77- \u00a7e" + TemporaryFile.getTemporaryFile().getPlayerList().get(i));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/logban " + TemporaryFile.getTemporaryFile().getPlayerList().get(i)));
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("\u00a77Klicke \u00a7ehier \u00a77um \u00a7e" + TemporaryFile.getTemporaryFile().getPlayerList().get(i) + "\u00a77 zur \u00a7ebWaves \u00a7cBanliste \u00a77hinzuzuf\u00fcgen!").create()));
                String[] listAllUserMessage = new String[]{String.valueOf(Vars.getVars().pr) + "\u00a77Liste aller \u00a7eSpieler\u00a77:"};
                p.sendMessage(listAllUserMessage);
                try {
                    TimeUnit.MILLISECONDS.sleep(1500L);
                }
                catch (InterruptedException e) {
                    ErrorSaver.getSaveError().saveError(ErrorTypes.UNKNOWN_ERROR, this.toString(), "Could not sleep thread.");
                }
                p.spigot().sendMessage((BaseComponent)tc);
                ++i;
            }
        }
    }
}

