/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.*;
import com.cadiducho.minegram.api.exception.*;
import org.bukkit.plugin.Plugin;

/*
 * Interface to build Telegrams Bots 
 */
public interface BotAPI {

    /**
     * Simple method to get Bot's User instance and handle simple information from {@link User}.
     * @return User
     * @throws TelegramException
     */
    public User getMe() throws TelegramException;
    
    /**
     * Get Bukkit Plugin object. 
     * @return Plugin
     */
    public Plugin getBukkitPlugin();
    
}
