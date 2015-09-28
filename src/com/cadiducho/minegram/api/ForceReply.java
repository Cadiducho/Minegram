/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to 
 * the user (act as if the user has selected the bot‘s message and tapped ’Reply'). 
 * This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 */
@ToString
@Getter @Setter
public class ForceReply {
    
    /**
     * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
     */
    private Boolean force_reply;
    
    /**
     * Optional. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned
     * in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    private Boolean selective;

}
