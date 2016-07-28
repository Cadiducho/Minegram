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
 * This object represents a venue.
 */
@ToString
@Getter @Setter
public class Venue {
    
    /**
     * Venue location
     */
    private Location location;
    
    /**
     * Name of the venue
     */
    private String title;
    
    /**
     * pAdress of the venue
     */
    private String adress;
    
    /**
     * Optional. Foursquare identifier of the venue
     */
    private String foursquare_id;
    
}
