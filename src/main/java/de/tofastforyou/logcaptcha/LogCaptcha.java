package de.tofastforyou.logcaptcha;

import de.tofastforyou.logcaptcha.commands.*;
import de.tofastforyou.logcaptcha.events.*;
import de.tofastforyou.logcaptcha.files.*;
import de.tofastforyou.logcaptcha.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class LogCaptcha extends JavaPlugin {

    private static LogCaptcha instance;
    private final String configVersion = "1.1.3";
    private final String languageVersion = "1.1";

    @Override
    public void onEnable() {
        instance = this;
        ConsoleCommandSender console = Bukkit.getConsoleSender();

        console.sendMessage("Loading logCaptcha...");
        loadPlugin(console);
        initialize();
    }

    private void initialize() {
        if (getConfig().getBoolean("logCaptcha.Options.ResetAlreadyDoneList")) {
            Countdown.getCountdown().startCountdown();
        }
    }

    public static LogCaptcha getInstance() {
        return instance;
    }

    public int getResourceID() {
        return 64279;
    }

    private void loadPlugin(ConsoleCommandSender console) {
        console.sendMessage("Loading config...");
        saveDefaultConfig();
        checkAndUpdateConfig();

        console.sendMessage("Loading captchas...");
        if (getConfig().getBoolean("logCaptcha.UseCustomCaptchas")) {
            CustomCaptchaFile customFile = CustomCaptchaFile.getCustomCaptchaFile();
            customFile.saveFile();
            customFile.loadDefault();
        }

        console.sendMessage("Loading languages...");
        LanguageFile.getLanguageFile().loadDefaultLanguages();

        console.sendMessage("Checking files...");
        checkAndUpdateLanguageFile();
        CaptchaFile.getCaptchaFile().saveFile();
        LanguageFile.getLanguageFile().saveFile();

        if (getConfig().getBoolean("logCaptcha.Options.UseStatistics")) {
            StatisticsFile.getStatisticsFile().saveFile();
        }

        TemporaryFile tempFile = TemporaryFile.getTemporaryFile();
        tempFile.saveFile();
        tempFile.loadPlayerList();

        if (getConfig().getBoolean("logCaptcha.UseCustomCaptchas")) {
            CustomCaptchaFile.getCustomCaptchaFile().saveFile();
        }

        console.sendMessage("Checking version...");
        //checkVersionCompatibility();

        console.sendMessage("Checking options...");
        console.sendMessage(Vars.getVars().pr + "§cThis plugin uses §ebStats§c!");
        console.sendMessage(Vars.getVars().pr + "§cThis plugin uses §eXMaterial§c by §eHex_27§c!");
        if (getConfig().getBoolean("logCaptcha.Options.UseBWaves")) {
            console.sendMessage(Vars.getVars().pr + "§cThe auto-ban system was provided by §ebWaves§c!");
        }

        console.sendMessage("Searching for updates...");
        // Uncomment when update logic is safe
        // if (Updater.getUpdater().isUpdate(getResourceID())) {
        //     console.sendMessage(Vars.getVars().pr + "§4You're running an old version of §elogCaptcha§c!");
        //     console.sendMessage(Vars.getVars().pr + "§4Your version: §e" + getDescription().getVersion() +
        //             "§4 New version: §e" + Updater.getUpdater().getVersion(getResourceID()));
        // }

        console.sendMessage("Registering listeners...");
        registerEvents();

        console.sendMessage("Registering commands...");
        registerCommands();

        console.sendMessage("logCaptcha is fully loaded!");
    }

    private void checkVersionCompatibility() {
        if (!VersionCheck.getVersionCheck().isVersionCompatible(Bukkit.getBukkitVersion())) {
            String prefix = Vars.getVars().pr;
            Bukkit.getConsoleSender().sendMessage(new String[]{
                prefix + "§4Your server version is incompatible with some plugin functions!",
                prefix + "§4Only chat captchas will work.",
                prefix + "§4To use all features, switch to one of: §e1.13.x, 1.14.1, 1.14.2, 1.14.3, 1.14.4"
            });

            if (!getConfig().getBoolean("logCaptcha.Options.UseChatCaptcha")) {
                getConfig().set("logCaptcha.Options.UseChatCaptcha", true);
                getConfig().set("logCaptcha.Options.UseSquareCaptcha", false);
                saveConfig();
            }
        }
    }

    private void checkAndUpdateConfig() {
        String currentVersion = getConfig().getString("logCaptcha.Version");
        if (!configVersion.equals(currentVersion)) {
            File configFile = new File(getDataFolder(), "config.yml");
            configFile.delete();
            saveDefaultConfig();
            reloadConfig();
            Bukkit.getConsoleSender().sendMessage(Vars.getVars().pr + "§4WARNING: Config file reset to defaults!");
        }
    }

    private void checkAndUpdateLanguageFile() {
        LanguageFile langFile = LanguageFile.getLanguageFile();
        if (!languageVersion.equals(langFile.getVersion())) {
            langFile.langFile.delete();
            langFile.loadDefaultLanguages();
            Bukkit.getConsoleSender().sendMessage(Vars.getVars().pr + "§4WARNING: Language file reset to defaults!");
        }
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        JavaPlugin plugin = LogCaptcha.getInstance();

        pm.registerEvents(new JoinEvent(), plugin);
        pm.registerEvents(new InventoryClickEventListener(), plugin);
        pm.registerEvents(new ChatEvent(), plugin);
        pm.registerEvents(new EntityDamageEvent(), plugin);
        pm.registerEvents(new FoodLevelChangeEventListener(), plugin);
        pm.registerEvents(new MoveEvent(), plugin);
        pm.registerEvents(new QuitEvent(), plugin);
        pm.registerEvents(new InventoryCloseEventListener(), plugin);
        pm.registerEvents(new RightClickEvent(), plugin);
    }

    private void registerCommands() {
        getCommand("captcha").setExecutor(new CaptchaCommand());
        getCommand("logcaptcha").setExecutor(new LogCaptchaCommand());
        getCommand("captchaprove").setExecutor(new ApproveCommand());
        getCommand("logcaptchaadmin").setExecutor(new LogCaptchaAdminCommand());
        getCommand("logban").setExecutor(new LogBanCommand());
    }
}
