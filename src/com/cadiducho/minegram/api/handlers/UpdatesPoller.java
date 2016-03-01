/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */
package com.cadiducho.minegram.api.handlers;

import com.cadiducho.minegram.MinegramPlugin;
import com.cadiducho.minegram.TelegramBot;
import com.cadiducho.minegram.api.Message;
import com.cadiducho.minegram.api.Update;
import com.cadiducho.minegram.api.events.*;
import com.cadiducho.minegram.api.exception.TelegramException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public class UpdatesPoller {

    private final ReaderThread readerThread;
    private final TelegramBot bot;
    private final ExecutorService executorService;
    private final MinegramPlugin plugin;
    
    public UpdatesPoller(TelegramBot instance) {
        plugin = MinegramPlugin.instance;
        plugin.debugLog("Updates Poller created");
        executorService = Executors.newCachedThreadPool();     
        readerThread = new ReaderThread();
        readerThread.start();
        plugin.debugLog("Reader Thread started");
        bot = instance;
    }
    
    private int lastUpdateId = 0;

    private class ReaderThread extends Thread {

        @Override
        public void run() {
            setPriority(Thread.MIN_PRIORITY);
            while (bot.getUpdatesPolling()) {
                try {
                    poll();
                } catch (TelegramException e) {
                    plugin.getLogger().log(Level.SEVERE, "An exception occurred while polling Telegram.", e);
                    bot.setUpdatesPolling(false);
                }
            }
        }

        private void poll() throws TelegramException {
            List<Update> updates = bot.getUpdates(lastUpdateId + 1, 0, 3);
            if (updates.size() > 0) {
                updates.stream().forEach((update) -> {
                    if (update.getUpdate_id() > lastUpdateId) {
                        plugin.debugLog("New update found");
                        lastUpdateId = update.getUpdate_id();
                        executorService.submit(() -> {
                            shortUpdates(update);
                        });
                    }
                });
            }    
        }
        
        private void shortUpdates(Update update) {
            if (update.getMessage().getType().equals(Message.Type.TEXT) && update.getMessage().getText().startsWith("/")) {
                plugin.debugLog("Calling commands event");
                plugin.getServer().getPluginManager().callEvent(new TelegramCommandEvent(update)); //It's a command
                return;
            }
            plugin.debugLog("Calling default event");
            plugin.getServer().getPluginManager().callEvent(new TelegramUpdateEvent(update)); //default response event
        }
    }
}