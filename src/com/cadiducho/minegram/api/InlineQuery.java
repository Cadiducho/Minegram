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
     * Text of the query
     */
    private String query;
    
    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    private String offset;
    
}
