/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import com.cadiducho.minegram.api.Location;
import com.cadiducho.minegram.api.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents a result of an inline query that was chosen by the user and sent to their chat partner.
 */
@ToString
@Getter @Setter
public class ChosenInlineResult {
    
    /**
     * The unique identifier for the result that was chosen.
     */
    private String result_id;
    
    /**
     * 	The user that chose the result.
     */
    private User from;
    
    /**
     * Optional. Sender location, only for bots that require user location
     */
    private Location location;
    
    /**
     * Optional. Identifier of the sent inline message. 
     * Available only if there is an inline keyboard attached to the message. 
     * Will be also received in callback queries and can be used to edit the message.
     */
    private String inline_message_id;
    
    /**
     * 	The query that was used to obtain the result.
     */
    private String query;
    
}
