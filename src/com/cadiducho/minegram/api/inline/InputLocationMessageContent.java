/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 */
@ToString
@Getter @Setter
public class InputLocationMessageContent extends InputMessageContent {
    
    /**
     * Latitude of the location in degrees
     */
    private Float latitude;
    
    /**
     * Longitude of the location in degrees
     */
    private Float longitude;
}
