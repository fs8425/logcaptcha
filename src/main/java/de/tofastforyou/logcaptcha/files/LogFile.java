/*
 * Decompiled with CFR 0.152.
 */
package de.tofastforyou.logcaptcha.files;

import java.io.File;

public class LogFile {
    private static LogFile log_File = new LogFile();
    public File logFile = new File("plugins//logCaptcha//logCaptchaLog.txt");

    public static LogFile getLogFile() {
        return log_File;
    }
}

