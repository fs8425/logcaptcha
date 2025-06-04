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

public class StatisticsFile {
    private static StatisticsFile Statistics_File = new StatisticsFile();
    public File statsFile = new File("plugins//logCaptcha//Stats//Statistics.yml");
    public YamlConfiguration statsCfg = YamlConfiguration.loadConfiguration((File)this.statsFile);

    public static StatisticsFile getStatisticsFile() {
        return Statistics_File;
    }

    public void saveFile() {
        try {
            this.statsCfg.save(this.statsFile);
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_SAVE_FAIL, this.getClass().getName(), "Could not save the Statistics.yml file.");
        }
    }

    public void addApprovedPlayer() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("ApprovedPlayer", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("ApprovedPlayer") != null) {
            this.statsCfg.set("ApprovedPlayer", (Object)(this.statsCfg.getInt("ApprovedPlayer") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("ApprovedPlayer", (Object)1);
            this.saveFile();
        }
    }

    public void addPlayerClosedInventory() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("PlayerClosedInventory", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("PlayerClosedInventory") != null) {
            this.statsCfg.set("PlayerClosedInventory", (Object)(this.statsCfg.getInt("PlayerClosedInventory") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("PlayerClosedInventory", (Object)1);
            this.saveFile();
        }
    }

    public void addFailedPlayer() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("FailedPlayer", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("FailedPlayer") != null) {
            this.statsCfg.set("FailedPlayer", (Object)(this.statsCfg.getInt("FailedPlayer") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("FailedPlayer", (Object)1);
            this.saveFile();
        }
    }

    public void doneChatCaptcha() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("ChatCaptcha", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("ChatCaptcha") != null) {
            this.statsCfg.set("ChatCaptcha", (Object)(this.statsCfg.getInt("ChatCaptcha") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("ChatCaptcha", (Object)1);
            this.saveFile();
        }
    }

    public void doneInventoryCaptcha() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("InventoryCaptcha", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("InventoryCaptcha") != null) {
            this.statsCfg.set("InventoryCaptcha", (Object)(this.statsCfg.getInt("InventoryCaptcha") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("InventoryCaptcha", (Object)1);
            this.saveFile();
        }
    }

    public void addLogEntry() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("LogEntrys", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("LogEntrys") != null) {
            this.statsCfg.set("LogEntrys", (Object)(this.statsCfg.getInt("LogEntrys") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("LogEntrys", (Object)1);
            this.saveFile();
        }
    }

    public void addPlayerJoined() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("PlayerJoined", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("PlayerJoined") != null) {
            this.statsCfg.set("PlayerJoined", (Object)(this.statsCfg.getInt("PlayerJoined") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("PlayerJoined", (Object)1);
            this.saveFile();
        }
    }

    public void addPlayerTriedCommand() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("PlayerTriedCommand", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("PlayerTriedCommand") != null) {
            this.statsCfg.set("PlayerTriedCommand", (Object)(this.statsCfg.getInt("PlayerTriedCommand") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("PlayerTriedCommand", (Object)1);
            this.saveFile();
        }
    }

    public void addPlayerTriedMove() {
        if (!this.statsFile.exists()) {
            try {
                this.statsFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create statistics file.");
            }
            this.statsCfg.set("PlayerTriedMove", (Object)1);
            this.saveFile();
        } else if ((Integer)this.statsCfg.get("PlayerTriedMove") != null) {
            this.statsCfg.set("PlayerTriedMove", (Object)(this.statsCfg.getInt("PlayerTriedMove") + 1));
            this.saveFile();
        } else {
            this.statsCfg.set("PlayerTriedMove", (Object)1);
            this.saveFile();
        }
    }

    public int getPlayerClosedInventory() {
        return this.statsCfg.getInt("PlayerClosedInventory");
    }

    public int getPlayerTriedMove() {
        return this.statsCfg.getInt("PlayerTriedMove");
    }

    public int getPlayerTriedCommand() {
        return this.statsCfg.getInt("PlayerTriedCommand");
    }

    public int getPlayerJoined() {
        return this.statsCfg.getInt("PlayerJoined");
    }

    public int getLogEntrys() {
        if (!this.statsFile.exists()) {
            return 0;
        }
        return this.statsCfg.getInt("LogEntrys");
    }

    public int getDoneChatCaptcha() {
        return this.statsCfg.getInt("ChatCaptcha");
    }

    public int getDoneInventoryCaptcha() {
        return this.statsCfg.getInt("InventoryCaptcha");
    }

    public int getFailedPlayer() {
        return this.statsCfg.getInt("FailedPlayer");
    }

    public int getApprovedPlayer() {
        return this.statsCfg.getInt("ApprovedPlayer");
    }
}

