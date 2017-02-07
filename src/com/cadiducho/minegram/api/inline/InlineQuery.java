/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import com.cadiducho.minegram.api.Location;
import com.cadiducho.minegram.api.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.
 */
@ToString
@Getter @Setter
public class InlineQuery {
    
    /**
     * Unique identifier for this query
     */
    private String id;
    
    /**
     * Sender
     */
    private User from;
    
    /**
     * Optional. Sender location, only for bots that request user location
     */
    private Location location;
    
    /**
     * Text of the query
     */
    private String query;
    
    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    private String offset;
    
}
