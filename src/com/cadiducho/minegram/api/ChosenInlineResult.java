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
     * 	The query that was used to obtain the result.
     */
    private String query;
    
}
