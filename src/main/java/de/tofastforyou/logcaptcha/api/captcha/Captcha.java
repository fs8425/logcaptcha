/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package de.tofastforyou.logcaptcha.api.captcha;

import java.util.ArrayList;
import org.bukkit.entity.Player;

public class Captcha {
    public static Captcha captcha = new Captcha();
    public ArrayList<Player> playerInCaptcha = new ArrayList();
    public ArrayList<Player> playerInChatCaptcha = new ArrayList();
    public String[] invCaptchaWordOneList = new String[]{"\u00a7a20", "\u00a7aSheep", "\u00a7a152", "\u00a7aQueen-Elizabeth", "\u00a7a24", "\u00a7aCar", "\u00a7a130", "\u00a7aComputer", "\u00a7a163", "\u00a7aHouse", "\u00a7a36", "\u00a7aHouse", "\u00a7aPotato", "\u00a7a130", "\u00a7aWindow", "\u00a7aLog", "\u00a7a10", "\u00a7a21", "\u00a7a11", "\u00a7a40", "\u00a7aBasketball", "\u00a7aDown"};
    public String[] invCaptchaWordTwoList = new String[]{"\u00a7a30", "\u00a7aCow", "\u00a7a192", "\u00a7aKing-George", "\u00a7a22", "\u00a7aRoller", "\u00a7a139", "\u00a7aConsole", "\u00a7a154", "\u00a7aVillage", "\u00a7a40", "\u00a7aApple", "\u00a7aRaw Beef", "\u00a7a193", "\u00a7aDoor", "\u00a7aWood", "\u00a7a32", "\u00a7a32", "\u00a7a17", "\u00a7a31", "\u00a7aFootball", "\u00a7aUp"};
    public String[] invCaptchaSolutionList = new String[]{"\u00a7aBlock", "\u00a7aFish", "\u00a7aApple", "\u00a7aChicken", "\u00a7aItem", "\u00a7aLegend", "\u00a7aSupport", "\u00a7aChat", "\u00a7aCaptcha", "\u00a7aList", "\u00a7aTomato", "\u00a7aMessage", "\u00a7aSpy", "\u00a7aFile", "\u00a7aWave", "\u00a7aTable", "\u00a7aAddon", "\u00a7aUtility", "\u00a7aEvent", "\u00a7aMetal", "\u00a7aLog", "\u00a7aSpider"};
    public String[] invCaptchaWordFourList = new String[]{"\u00a7a22", "\u00a7aFish", "\u00a7a130", "\u00a7aJohnny", "\u00a7a13", "\u00a7aShip", "\u00a7a113", "\u00a7aKeyboard", "\u00a7a135", "\u00a7aTown", "\u00a7a56", "\u00a7aCoconut", "\u00a7aChicken", "\u00a7a213", "\u00a7aChair", "\u00a7aPlank", "\u00a7a14", "\u00a7a20", "\u00a7a15", "\u00a7a43", "\u00a7aSoccer", "\u00a7aLeft"};
    public String[] invCaptchaWordFiveList = new String[]{"\u00a7a16", "\u00a7aDog", "\u00a7a174", "\u00a7aMarvin", "\u00a7a19", "\u00a7aAirplane", "\u00a7a143", "\u00a7aTelevision", "\u00a7a162", "\u00a7aBungalow", "\u00a7a29", "\u00a7aKiwi", "\u00a7aCordon Bleu", "\u00a7a169", "\u00a7aTable", "\u00a7aCobblestone", "\u00a7a15", "\u00a7a17", "\u00a7a19", "\u00a7a49", "\u00a7aCricket", "\u00a7aMiddle"};
    public String[] invCaptchaQuestionListEN = new String[]{"\u00a77Click on the \u00a7ablock \u00a77named \u00a7aBlock", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aFish", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aApple", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aChicken", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aItem", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aLegend", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aSupport", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aChat", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aCaptcha", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aList", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aTomato", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aMessage", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aSpy", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aFile", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aWave", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aTable", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aAddon", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aUtility", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aEvent", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aMetal", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aLog", "\u00a77Click on the \u00a7ablock \u00a77named \u00a7aSpider"};
    public String[] invCaptchaQuestionListDE = new String[]{"\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aBlock", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aFish", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aApple", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aChicken", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aItem", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aLegend", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aSupport", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aChat", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aCaptcha", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens aList", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aTomato", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aMessage", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aSpy", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aFile", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aWave", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aTable", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aAddon", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aUtility", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aEvent", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aMetal", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aLog", "\u00a77Klicke auf den \u00a7aBlock \u00a77namens \u00a7aSpider"};

    public static Captcha getCaptcha() {
        return captcha;
    }
}

