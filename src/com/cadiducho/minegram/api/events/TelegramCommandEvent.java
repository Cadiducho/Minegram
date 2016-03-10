/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */
package com.cadiducho.minegram.api.events;

import com.cadiducho.minegram.api.Update;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter @Setter
public class TelegramCommandEvent extends Event {
    private Update update;
    
    public TelegramCommandEvent(Update update) {
        this.update = update;
    }

    private static final HandlerList handlers = new HandlerList();
         
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
         
    public static HandlerList getHandlerList() {
        return handlers;
    }
 
}
 
