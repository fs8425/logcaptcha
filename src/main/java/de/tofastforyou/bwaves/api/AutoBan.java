/*
 * Decompiled with CFR 0.152.
 */
package de.tofastforyou.bwaves.api;

import de.tofastforyou.bwaves.files.BanFile;
import de.tofastforyou.bwaves.files.WaveFile;

public class AutoBan {
    public static AutoBan ab = new AutoBan();

    public static AutoBan getAutoBan() {
        return ab;
    }

    public void banWave() {
        int i = 0;
        while (i < WaveFile.getWaveFile().waveCfg.getStringList("BanWave").size()) {
            BanFile.getBanFile().banPlayer((String)WaveFile.getWaveFile().waveCfg.getStringList("BanWave").get(i));
            WaveFile.getWaveFile().removePlayerFromWave((String)WaveFile.getWaveFile().waveCfg.getStringList("BanWave").get(i));
            ++i;
        }
    }
}

