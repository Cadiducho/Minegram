/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */
package com.cadiducho.minegram;

import com.cadiducho.minegram.api.exception.TelegramException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MinegramPlugin extends JavaPlugin {

    public static HashMap<BotAPI, Plugin> bots = new HashMap<>();
    public static MinegramPlugin instance;

    @Override
    public void onLoad() {
        log("Minegram loaded. Waiting for bots.");
    }

    @Override
    public void onEnable() {
        instance = this;
        log("Enabling Minegram " + getDescription().getVersion() + " by Cadiducho");

        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!bots.isEmpty()) {
                    bots.forEach((bot, pluginLoader) -> {
                        try {
                            log("@" + bot.getMe().getUsername() + " loaded by " + pluginLoader.getName());
                        } catch (TelegramException ex) {
                            log("Could not retrieve any info from " + pluginLoader.getName() + "'s bot:");
                            log(ex.getMessage());
                        }
                    });
                }
                log("Loaded " + bots.size() + " bots.");
            }
        }.runTaskLater(this, 1);

    }

    @Override
    public void onDisable() {
        log("Unloaded " + bots.size() + " bots.");
        if (!bots.isEmpty()) {
            bots.keySet().stream().forEach(bot -> bot.setUpdatesPolling(false));
            String botPlugins = "";
            botPlugins = bots.entrySet().stream().map(entry -> entry.getValue().getName() + ", ").reduce(botPlugins, String::concat);
            log("Bots from " + botPlugins + " will not work anymore.");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("minegram")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage(ChatColor.BLUE + "This server has loaded " + ChatColor.GREEN + bots.size() + ChatColor.BLUE + " bots:");
                    if (!bots.isEmpty()) {
                        bots.forEach((bot, pluginLoader) -> {
                            try {
                                sender.sendMessage(ChatColor.GREEN + "@" + bot.getMe().getUsername() + ChatColor.BLUE + " loaded by " + ChatColor.GREEN + pluginLoader.getName());
                            } catch (TelegramException ex) {
                                sender.sendMessage("Could not retrieve any info from " + pluginLoader.getName() + "'s bot: " + ex.getMessage());
                            }
                        });
                    }
                    return true;
                }
            }
            sender.sendMessage(ChatColor.BLUE + "This server is running Minegram " + ChatColor.GREEN + getDescription().getVersion());
        }
        return true;
    }

    public boolean isDebug() {
        return this.getConfig().getBoolean("debug");
    }

    public void debugLog(String s) {
        if (isDebug()) {
            log("[Debug] " + s);
        }
    }

    public void log(String s) {
        getLogger().log(Level.INFO, s);
    }

    public BotAPI getBot(String username) throws TelegramException {
        if (!bots.isEmpty()) {
            for (BotAPI bot : bots.keySet()) {
                if (bot.getMe().getUsername().equals(username)) {
                    return bot;
                }
            }
        }
        return null;
    }

    public BotAPI getBot(Integer id) throws TelegramException {
        if (!bots.isEmpty()) {
            for (BotAPI bot : bots.keySet()) {
                if (bot.getMe().getId().equals(id)) {
                    return bot;
                }
            }
        }
        return null;
    }

    public List<BotAPI> getBotList(Plugin pluginLoader) throws TelegramException {
        ArrayList<BotAPI> botsFounded = new ArrayList<>();
        if (!bots.isEmpty()) {
            bots.keySet().stream()
                .filter(bot -> bot.getBukkitPlugin().equals(pluginLoader))
                .forEach(bot -> botsFounded.add(bot)
            );
        }
        return botsFounded;
    }
}
