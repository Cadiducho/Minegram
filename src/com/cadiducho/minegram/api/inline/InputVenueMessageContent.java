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
 * Represents the content of a venue message to be sent as the result of an inline query.
 */
@ToString
@Getter @Setter
public class InputVenueMessageContent extends InputMessageContent {
    
    /**
     * Latitude of the location in degrees
     */
    private Float latitude;
    
    /**
     * Longitude of the location in degrees
     */
    private Float longitude;
    
    /**
     * Name of the venue
     */
    private String title;
    
    /**
     * Adress of the veune
     */
    private String address;
    
    /**
     * 	Optional. Foursquare identifier of the venue, if known
     */
    private String foursquare_id;
}
