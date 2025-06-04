/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package de.tofastforyou.bwaves.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;

public class BanFile {
    public static BanFile Ban_File = new BanFile();
    public File banFile = new File("plugins//bWaves//bans.yml");
    public YamlConfiguration banCfg = YamlConfiguration.loadConfiguration((File)this.banFile);

    public static BanFile getBanFile() {
        return Ban_File;
    }

    public void banPlayer(String playerName) {
        if (!this.banFile.exists()) {
            ArrayList<String> bans = new ArrayList<String>();
            bans.add(playerName);
            this.banCfg.set("BannedPlayers", bans);
            this.saveFile();
        } else {
            List bans = this.banCfg.getStringList("BannedPlayers");
            bans.add(playerName);
            this.banCfg.set("BannedPlayers", (Object)bans);
            this.saveFile();
        }
    }

    public boolean isBanned(String playerName) {
        if (this.banFile.exists()) {
            return this.banCfg.getStringList("BannedPlayers").contains(playerName);
        }
        return false;
    }

    public void saveFile() {
        try {
            this.banCfg.save(this.banFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

