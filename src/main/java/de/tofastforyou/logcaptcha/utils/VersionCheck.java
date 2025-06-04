/*
 * Decompiled with CFR 0.152.
 */
package de.tofastforyou.logcaptcha.utils;

import java.util.Arrays;
import java.util.List;

public class VersionCheck {
    private static VersionCheck VersionCheck = new VersionCheck();

    public static VersionCheck getVersionCheck() {
        return VersionCheck;
    }

    public boolean isVersionCompatible(String version) {
        String[] unsupportedVersions = new String[]{"1.6", "1.7", "1.8", "1.9", "1.10", "1.11", "1.12", "1.14"};
        List<String> unsupportedVersionList = Arrays.asList(unsupportedVersions);
        if (version.contains("1.14") && version.contains(".1") || version.contains("1.14") && version.contains(".2") || version.contains("1.14") && version.contains(".3") || version.contains("1.14") && version.contains(".4")) {
            return true;
        }
        int i = 0;
        if (i > unsupportedVersionList.size()) {
            return !version.contains(unsupportedVersionList.get(i));
        }
        return false;
    }
}

