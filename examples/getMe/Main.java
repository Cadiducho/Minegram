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
			User user = telegramBot.getMe();
			this.getLogger.info("Hello! Im @"+user.getUsername());
		} catch(TelegramException e) {
			System.out.println("Could'nt get bot instance!");
		}
		this.getLogger.info("Test plugin 1 enabled");
	}
    
    @Override
    public void onDisable() {}
}