/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.utils.ErrorTypes;
import org.bukkit.Bukkit;

public class ErrorSaver {
    public static ErrorSaver getSaveError() {
        return new ErrorSaver();
    }

    public void saveError(ErrorTypes Error, String Class2, String ErrorMessage) {
        Bukkit.getConsoleSender().sendMessage("\u00a7cWhoops! An \u00a74Error \u00a7chas appeared: \u00a74" + Error.getErrorMessage());
        Bukkit.getConsoleSender().sendMessage("\u00a7cError is in the class: \u00a74" + Class2);
        Bukkit.getConsoleSender().sendMessage("\u00a7cPlease send this error immediately to the author of this plugin!");
        Bukkit.getConsoleSender().sendMessage("\u00a7cMore information: \u00a74" + ErrorMessage);
    }
}

