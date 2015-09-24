/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.exception.TelegramException;
import java.util.HashMap;
import java.util.logging.Level;
import org.apache.commons.lang.Validate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class MinegramPlugin extends JavaPlugin {
    
    public static HashMap<BotAPI, Plugin> bots = new HashMap<>();
    public static MinegramPlugin instance;
    
    @Override
    public void onEnable() {
        instance = this;
        Validate.notNull(instance, "Plugin cannot be null!");
        this.getLogger().log(Level.INFO, "Enabling Minegram {0} by Cadiducho", getDescription().getVersion());
        
        this.getLogger().log(Level.INFO, "Loaded {0} bots.", bots.size());
        if (bots.isEmpty()) {
            bots.forEach((bot, pluginLoader) -> { 
                try {
                    getLogger().log(Level.INFO, "@{0} loaded by {1}", new Object[]{bot.getMe().getUsername(), pluginLoader.getName()});
                } catch (TelegramException ex) {
                    getLogger().log(Level.INFO, "Could not retrieve any info from Bot load from {0}: {1}", new Object[]{pluginLoader.getName(), ex.getMessage()});
                }
            });
        }
    }
    
    @Override
    public void onDisable() {
        this.getLogger().log(Level.INFO, "Unoaded {0} bots.", bots.size());
        if (bots.isEmpty()) {
            String botPlugins = "";
            botPlugins = bots.entrySet().stream().map((entry) -> entry.getValue().getName()+", ").reduce(botPlugins, String::concat);
            this.getLogger().log(Level.WARNING, "Bots from {0} will not work anymore.", botPlugins);
        }
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("minegram")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage("This server has loaded "+bots.size()+" bots:");
                    if (bots.isEmpty()) {
                        bots.forEach((bot, pluginLoader) -> { 
                            try {
                                sender.sendMessage("@"+bot.getMe().getUsername()+" loaded by "+pluginLoader.getName());
                            } catch (TelegramException ex) {
                                sender.sendMessage("Could not retrieve any info from Bot load from "+pluginLoader.getName()+": "+ex.getMessage());
                            }
                        });
                    }
                    return true;
                }
            }
            sender.sendMessage("This server is running Minegram "+getDescription().getVersion());
        }
        return true;
    }
    
}
