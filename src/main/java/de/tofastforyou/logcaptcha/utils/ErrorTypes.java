/*
 * Decompiled with CFR 0.152.
 */
package de.tofastforyou.logcaptcha.utils;

public enum ErrorTypes {
    FILE_SAVE_FAIL("Could not write into the file!"),
    UNKNOWN_ERROR("Unknown Error!"),
    FILE_CREATION_FAIL("Could not create file!"),
    FILE_WRITE_FAIL("Could not write in file!");

    String ErrorMessage = "";

    private ErrorTypes(String Error) {
        this.ErrorMessage = Error;
    }

    public String getErrorMessage() {
        return this.ErrorMessage;
    }
}

