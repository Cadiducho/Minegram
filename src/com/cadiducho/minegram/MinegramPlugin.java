/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.exception.TelegramException;
import java.util.HashMap;
import java.util.logging.Level;
import org.apache.commons.lang.Validate;
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
    public void onEnable() {
        instance = this;
        Validate.notNull(instance, "Plugin cannot be null!");
        getLogger().log(Level.INFO, "Enabling Minegram {0} by Cadiducho", getDescription().getVersion());
        
        new BukkitRunnable() {    
            @Override
            public void run() {
                if (!bots.isEmpty()) {
                    bots.forEach((bot, pluginLoader) -> { 
                        try {
                            getLogger().log(Level.INFO, "@{0} loaded by {1}", new Object[]{bot.getMe().getUsername(), pluginLoader.getName()});
                        } catch (TelegramException ex) {
                            getLogger().log(Level.INFO, "Could not retrieve any info from {0}'s bot: {1}", new Object[]{pluginLoader.getName(), ex.getMessage()});
                        }
                    });
                }
                MinegramPlugin.instance.getLogger().log(Level.INFO, "Loaded {0} bots.", bots.size());
            }
        }.runTaskLater(this, 1);
        
    }
    
    @Override
    public void onDisable() {
        this.getLogger().log(Level.INFO, "Unoaded {0} bots.", bots.size());
        if (!bots.isEmpty()) {
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
                    sender.sendMessage(ChatColor.BLUE+"This server has loaded "+ChatColor.GREEN+bots.size()+ChatColor.BLUE+" bots:");
                    if (!bots.isEmpty()) {
                        bots.forEach((bot, pluginLoader) -> { 
                            try {
                                sender.sendMessage(ChatColor.GREEN+"@"+bot.getMe().getUsername()+ChatColor.BLUE+" loaded by "+ChatColor.GREEN+pluginLoader.getName());
                            } catch (TelegramException ex) {
                                sender.sendMessage("Could not retrieve any info from "+pluginLoader.getName()+"'s bot: "+ex.getMessage());
                            }
                        });
                    }
                    return true;
                }
            }
            sender.sendMessage(ChatColor.BLUE+"This server is running Minegram "+ChatColor.GREEN+getDescription().getVersion());
        }
        return true;
    }
    
}
