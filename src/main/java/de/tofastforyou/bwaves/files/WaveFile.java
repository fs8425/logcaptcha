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

public class WaveFile {
    public static WaveFile Wave_File = new WaveFile();
    public File waveFile = new File("plugins//bWaves//wave.yml");
    public YamlConfiguration waveCfg = YamlConfiguration.loadConfiguration((File)this.waveFile);

    public static WaveFile getWaveFile() {
        return Wave_File;
    }

    public void addPlayerToWave(String playerName) {
        if (!this.waveFile.exists()) {
            ArrayList<String> wave = new ArrayList<String>();
            wave.add(playerName);
            this.waveCfg.set("BanWave", wave);
            this.saveFile();
        } else {
            List wave = this.waveCfg.getStringList("BanWave");
            wave.add(playerName);
            this.waveCfg.set("BanWave", (Object)wave);
            this.saveFile();
        }
    }

    public void removePlayerFromWave(String playerName) {
        if (!this.waveFile.exists()) {
            return;
        }
        List wave = this.waveCfg.getStringList("BanWave");
        wave.remove(playerName);
        this.waveCfg.set("BanWave", (Object)wave);
        this.saveFile();
    }

    public void saveFile() {
        try {
            this.waveCfg.save(this.waveFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

