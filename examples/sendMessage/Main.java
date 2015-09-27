package com.cadiducho.tutorialbukkit;

import com.cadiducho.minegram.BotAPI;
import com.cadiducho.minegram.TelegramBot;
import com.cadiducho.minegram.api.exception.TelegramException;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    static BotAPI telegramBot;
    
	@Override
    public void onEnable() {
		telegramBot = new TelegramBot("to:kken", this); //this, or your Bukkit Plugin instance
	
		try {
			telegramBot.sendMessage(Your_chat_id, "Hi! This is a test onEnable");
		} catch(TelegramException e) {
			System.out.println("Could'nt send any message!");
		}
		this.getLogger.info("Test plugin 2 enabled");
	}
    
    @Override
    public void onDisable() {}
}