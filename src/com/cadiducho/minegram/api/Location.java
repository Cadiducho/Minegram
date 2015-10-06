/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents a point on the map.
 */
@ToString
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
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
