/*
 * Decompiled with CFR 0.152.
 */
package de.tofastforyou.logcaptcha.utils;

import de.tofastforyou.logcaptcha.files.StatisticsFile;

public class Statistics {
    public static Statistics stats = new Statistics();
    private int solvedCaptcha = StatisticsFile.getStatisticsFile().getApprovedPlayer();
    private int failedCaptcha = StatisticsFile.getStatisticsFile().getFailedPlayer();
    private int doneChatCaptcha = StatisticsFile.getStatisticsFile().getDoneChatCaptcha();
    private int doneInvCaptcha = StatisticsFile.getStatisticsFile().getDoneInventoryCaptcha();
    private int triedCommand = StatisticsFile.getStatisticsFile().getPlayerTriedCommand();
    private int triedMove = StatisticsFile.getStatisticsFile().getPlayerTriedMove();
    private int allJoins = StatisticsFile.getStatisticsFile().getPlayerJoined();
    private int closedInventory = StatisticsFile.getStatisticsFile().getPlayerClosedInventory();

    public static Statistics getStats() {
        return stats;
    }

    public float getSolvedCaptchaPercentage() {
        float percentage = this.solvedCaptcha * 100 / this.allJoins;
        return percentage;
    }

    public float getFailedCaptchaPercentage() {
        float percentage = this.failedCaptcha * 100 / this.allJoins;
        return percentage;
    }

    public float getDoneChatCaptchaPercentage() {
        float percentage = this.doneChatCaptcha * 100 / this.allJoins;
        return percentage;
    }

    public float getDoneInvCaptchaPercentage() {
        float percentage = this.doneInvCaptcha * 100 / this.allJoins;
        return percentage;
    }

    public float getTriedCommandPercentage() {
        float percentage = this.triedCommand * 100 / this.allJoins;
        return percentage;
    }

    public float getTriedMovePercentage() {
        float percentage = this.triedMove * 100 / this.allJoins;
        return percentage;
    }

    public float getClosedInventoryPercentage() {
        float percentage = this.closedInventory * 100 / this.allJoins;
        return percentage;
    }

    public float getPercentage(int number, int maxAmount) {
        float percentage = number * 100 / maxAmount;
        return percentage;
    }
}

