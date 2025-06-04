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
import org.bukkit.configuration.file.YamlConfiguration;

public class TemporaryFile {
    private static TemporaryFile Temporary_File = new TemporaryFile();
    public File temporaryFile = new File("plugins//logCaptcha//Temp.yml");
    public YamlConfiguration temporaryCfg = YamlConfiguration.loadConfiguration((File)this.temporaryFile);

    public static TemporaryFile getTemporaryFile() {
        return Temporary_File;
    }

    public void addFail(String playerName) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".Fails", (Object)1);
            this.saveFile();
        } else if ((Integer)this.temporaryCfg.get(String.valueOf(playerName) + ".Fails") != null) {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Fails", (Object)(this.temporaryCfg.getInt(String.valueOf(playerName) + ".Fails") + 1));
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Fails", (Object)1);
            this.saveFile();
        }
    }

    public int getFails(String playerName) {
        return this.temporaryCfg.getInt(String.valueOf(playerName) + ".Fails");
    }

    public void setAction(String playerName, String action) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".Action", (Object)action);
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Action", (Object)action);
            this.saveFile();
        }
    }

    public String getAction(String playerName) {
        return this.temporaryCfg.getString(String.valueOf(playerName) + ".Action");
    }

    public void loadPlayerList() {
        if (this.temporaryCfg.getList("Players") != null) {
            return;
        }
        ArrayList players = new ArrayList();
        this.temporaryCfg.set("Players", players);
        this.saveFile();
    }

    public void addPlayerToList(String playerName) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            ArrayList<String> players = new ArrayList<String>();
            players.add(playerName);
            this.temporaryCfg.set("Players", players);
            this.saveFile();
        } else {
            ArrayList players = (ArrayList)this.temporaryCfg.getList("Players");
            players.add(playerName);
            this.temporaryCfg.set("Players", (Object)players);
            this.saveFile();
        }
    }

    public ArrayList<String> getPlayerList() {
        return (ArrayList)this.temporaryCfg.getList("Players");
    }

    public void setNumber(String playerName, int number) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".Number", (Object)number);
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Number", (Object)number);
            this.saveFile();
        }
    }

    public int getNumber(String playerName) {
        return this.temporaryCfg.getInt(String.valueOf(playerName) + ".Number");
    }

    public void setFinishNumber(String playerName, int number) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".FinishNumber", (Object)number);
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".FinishNumber", (Object)number);
            this.saveFile();
        }
    }

    public int getFinishNumber(String playerName) {
        return this.temporaryCfg.getInt(String.valueOf(playerName) + ".FinishNumber");
    }

    public void addProgress(String playerName) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".Progress", (Object)1);
            this.saveFile();
        } else if ((Integer)this.temporaryCfg.get(String.valueOf(playerName) + ".Progress") != null) {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Progress", (Object)(this.temporaryCfg.getInt(String.valueOf(playerName) + ".Progress") + 1));
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Progress", (Object)1);
            this.saveFile();
        }
    }

    public void setProgress(String playerName, int number) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".Progress", (Object)number);
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".Progress", (Object)number);
            this.saveFile();
        }
    }

    public void addProgressFinish(String playerName) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".ProgressFinish", (Object)1);
            this.saveFile();
        } else if ((Integer)this.temporaryCfg.get(String.valueOf(playerName) + ".ProgressFinish") != null) {
            this.temporaryCfg.set(String.valueOf(playerName) + ".ProgressFinish", (Object)(this.temporaryCfg.getInt(String.valueOf(playerName) + ".ProgressFinish") + 1));
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".ProgressFinish", (Object)1);
            this.saveFile();
        }
    }

    public void setProgressFinish(String playerName, int number) {
        if (!this.temporaryFile.exists()) {
            try {
                this.temporaryFile.createNewFile();
            }
            catch (IOException e) {
                ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_CREATION_FAIL, this.toString(), "Could not create temporary file.");
            }
            this.temporaryCfg.set(String.valueOf(playerName) + ".ProgressFinish", (Object)number);
            this.saveFile();
        } else {
            this.temporaryCfg.set(String.valueOf(playerName) + ".ProgressFinish", (Object)number);
            this.saveFile();
        }
    }

    public int getProgressFinish(String playerName) {
        return this.temporaryCfg.getInt(String.valueOf(playerName) + ".ProgressFinish");
    }

    public int getProgress(String playerName) {
        return this.temporaryCfg.getInt(String.valueOf(playerName) + ".Progress");
    }

    public void saveFile() {
        try {
            this.temporaryCfg.save(this.temporaryFile);
        }
        catch (IOException e) {
            ErrorSaver.getSaveError().saveError(ErrorTypes.FILE_SAVE_FAIL, this.getClass().getName(), "Could not save the Temp.yml file.");
        }
    }
}

