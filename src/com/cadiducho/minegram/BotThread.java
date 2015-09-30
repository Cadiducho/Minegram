/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.Update;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class BotThread extends Thread {
    
    private final Set<BotListener> _listeners = ConcurrentHashMap.newKeySet();

    private int _currentOffset = 0;
    private final TelegramBot _bot;
    private final int _limit;
    private final int _timeout;
	
    /**
     * Initializes new BotThread that will handle the message receiving 
     * @param limit   Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100
     * @param timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling
     * @param bot
     */
    public BotThread(int limit, int timeout, TelegramBot bot) {
        super("Bot Thread");
	_limit = limit;
	_timeout = timeout;
	_bot = bot;
	start();
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                try {
                    final List<Update> updates = _bot.getUpdates(_currentOffset, _limit, _timeout);
                    for (Update update : updates) {
                        _currentOffset = update.getUpdate_id() + 1;
			_listeners.forEach(listener -> listener.onMessageReceived(_bot, update.getMessage()));
                    }
		} catch (Exception e) {
                    _listeners.forEach(listener -> listener.onExceptionCaught(_bot, e));
		}

                try {
                    Thread.sleep(100);
		} catch (Exception e) {}
            }
        } catch (Exception e) {
            _listeners.forEach(listener -> listener.onExceptionCaught(_bot, e));
	}
    }

    /**
     * Attaches listener that will be used to notify upon new message received
     * 
     * @param listener
     */
    public void addListener(BotListener listener) {
        _listeners.add(listener);
    }

    /**
     * Removes attached listener
     * 
     * @param listener
     */
    public void removeListener(BotListener listener) {
        _listeners.remove(listener);
    }

    /**
     * Interrupts the thread and stops the thread
     */
    public void shutdown() {
        interrupt();
    }
}
