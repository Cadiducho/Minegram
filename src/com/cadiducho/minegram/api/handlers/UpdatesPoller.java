/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */
package com.cadiducho.minegram.api.handlers;

import com.cadiducho.minegram.MinegramPlugin;
import com.cadiducho.minegram.TelegramBot;
import com.cadiducho.minegram.api.Update;
import com.cadiducho.minegram.api.events.UpdateRecievedEvent;
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
        plugin.getLogger().log(Level.INFO, "Updates poller creado");
        executorService = Executors.newCachedThreadPool();     
        readerThread = new ReaderThread();
        readerThread.start();
        bot = instance; 
    }
    
    private boolean running = true;
    private int lastUpdateId = 0;

    private class ReaderThread extends Thread {

        @Override
        public void run() {
            setPriority(Thread.MIN_PRIORITY);
            while (running) {
                try {
                    poll();
                } catch (TelegramException e) {
                    plugin.getLogger().log(Level.SEVERE, "An exception occurred while polling Telegram.", e);
                    running = false;
                }
            }
        }

        public void poll() throws TelegramException {
            List<Update> updates = bot.getUpdates(lastUpdateId + 1, 0, 3);
            plugin.getLogger().log(Level.INFO, "Polling...");
            if (updates.size() > 0) {
                updates.stream().forEach((update) -> {
                    if (update.getUpdate_id() > lastUpdateId) {
                        plugin.getLogger().log(Level.INFO, "Nueva update...");
                        lastUpdateId = update.getUpdate_id();
                        executorService.submit(() -> {
                            plugin.getLogger().log(Level.INFO, "Llamando evento...");
                            plugin.getServer().getPluginManager().callEvent(new UpdateRecievedEvent(update));
                        });
                    }
                });
            }    
        }
    }
}