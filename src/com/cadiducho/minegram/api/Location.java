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

@ToString
@Getter @Setter
public class Location {

    /**
     * Longitude as defined by sender
     */
    private Float longitude;
    
    /**
     * Latitude as defined by sender
     */
    private Float latitude;
}
