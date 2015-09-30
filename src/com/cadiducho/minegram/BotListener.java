/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.Message;

/**
 * Simple Interface to handle all BotListeners
 */
public interface BotListener {

    public void onMessageReceived(TelegramBot _bot, Message message);

    public void onExceptionCaught(TelegramBot _bot, Exception e);
}
