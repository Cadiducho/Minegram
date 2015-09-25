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
public class Video {
    
    /**
     * Unique identifier for this file
     */
    private String file_id;
    
    /**
     * Video width as defined by sender
     */
    private Integer width;
    
    /**
     * Video height as defined by sender
     */
    private Integer height;
    
    /**
     * Duration of the video in seconds as defined by sender
     */
    private Integer duration;
    
    /**
     * Optional. Video thumbnail
     */
    private PhotoSize thumb;
    
    /**
     * Optional. Mime type of a file as defined by sender
     */
    private String mime_type;
    
    /**
     * Optional. File size
     */
    private Integer file_size;

}
