/*
 * Decompiled with CFR 0.152.
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.LogCaptcha;
import de.tofastforyou.logcaptcha.files.LogFile;
import de.tofastforyou.logcaptcha.files.StatisticsFile;
import de.tofastforyou.logcaptcha.utils.ErrorSaver;
import de.tofastforyou.logcaptcha.utils.ErrorTypes;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static Log log = new Log();

    public static Log getLog() {
        return log;
    }

    public void log(String logEntry) {
        if (!LogFile.getLogFile().logFile.exists()) {
            try {
                LogFile.getLogFile().logFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.getClass().getName(), "Could not create the logCaptchaLog.txt file.");
            }
        }
        try {
            FileWriter fw = new FileWriter(LogFile.getLogFile().logFile, true);
            PrintWriter pw = new PrintWriter(fw);
            if (!logEntry.startsWith("\n")) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd | HH:mm:ss");
                Date date = new Date();
                pw.write("[" + dateFormat.format(date) + "] ");
            }
            pw.write(String.valueOf(logEntry) + "\n");
            pw.close();
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_WRITE_FAIL, this.getClass().getName(), "Could not write in the logCaptchaLog.txt file.");
        }
        if (LogCaptcha.getInstance().getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
            StatisticsFile.getStatisticsFile().addLogEntry();
        }
    }
}

