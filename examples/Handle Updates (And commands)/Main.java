package com.cadiducho.tutorialbukkit;

import com.cadiducho.minegram.BotAPI;
import com.cadiducho.minegram.TelegramBot;
import com.cadiducho.minegram.api.Update;
import com.cadiducho.minegram.api.User;
import com.cadiducho.minegram.api.events.*;
import com.cadiducho.minegram.api.exception.TelegramException;
import java.util.logging.Level;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    
    static BotAPI telegramBot;

    @Override
    public void onEnable() {
	telegramBot = new TelegramBot("to:kken", true, this); //true for handle updates. Use this, or your Bukkit Plugin instance
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @Override
    public void onDisable() {}
    
    @EventHandler
    public void onUpdate(TelegramUpdateEvent e) {
        Update update = e.getUpdate();
        User u = update.getMessage().getFrom();
        getLogger().log(Level.INFO, "Update from @{0}: ", u.getUsername());
        getLogger().info(update.getMessage().getText());
    }
    
    @EventHandler
    public void onCommandTlg(TelegramCommandEvent e) {
        Update update = e.getUpdate();
        User u = update.getMessage().getFrom();
        getLogger().log(Level.INFO, "Comando de @{0}: ", u.getUsername());
        String cmd = update.getMessage().getText().substring(1);
        try {
            switch (cmd) {
                case "hello":
                    telegramBot.sendMessage(update.getMessage().getFrom().getId(), "Good bye!");
                    break;
                default:
                    //Help message or whatever, maybe nothing.
                    break;
            }    
        } catch (TelegramException ignored) {}
    }
}