/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard. 
 * If the button that originated the query was attached to a message sent by the bot, the field message will be present. 
 * If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be present. 
 * Exactly one of the fields data or game_short_name will be present.
 */
@ToString
@Getter @Setter
public class CallbackQuery {

    /**
     * 	Unique identifier for this query
     */
    private String id;
    
    /**
     * Sender
     */
    private User from;
    
    /**
     * Optional. Message with the callback button that originated the query. 
     * Note that message content and message date will not be available if the message is too old
     */
    private Message message;
    
    /**
     * Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    private String inline_message_id;
    
    /**
     * Optional. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    private String data;
}
