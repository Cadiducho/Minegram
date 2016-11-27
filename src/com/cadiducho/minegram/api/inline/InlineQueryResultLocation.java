/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a location on a map. By default, the location will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the location.
 */
@ToString
@Getter @Setter
public class InlineQueryResultLocation extends InlineQueryResult {

    /**
     * Location title
     */
    private String title;

    /**
     * Location latitude in degrees
     */
    private Float latitude;
    
    /**
     * 	Location longitude in degrees
     */
    private Float longitude;

    /**
     * Optional. URL of the thumbnail (jpeg only) for the file
     */
    private String thumb_url;
    
    /**
     * Optional. Thumbnail width
     */
    private Integer thumb_width;
    
    /**
     * Optional. Thumbnail height
     */
    private Integer thumb_height;

    public InlineQueryResultLocation() {
        super("location");
    }

    /**
     *
     * @param title Location title
     * @param latitude Location latitude in degrees
     * @param longitude Location longitude in degrees
     */
    public InlineQueryResultLocation(String title, Float latitude, Float longitude) {
        this();
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @param title Location title
     * @param latitude Location latitude in degrees
     * @param longitude Location longitude in degrees
     * @param thumb_url Optional. URL of the thumbnail (jpeg only) for the file
     * @param thumb_width Optional. Thumbnail width
     * @param thumb_height Optional. Thumbnail height
     */
    public InlineQueryResultLocation(String title, Float latitude, Float longitude, String thumb_url, Integer thumb_width, Integer thumb_height) {
        this();
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.thumb_url = thumb_url;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
    }
    
}
