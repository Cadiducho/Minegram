/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 */
@ToString
@Getter @Setter
public class VideoNote {
    
    /**
     * Unique identifier for this file
     */
    private String file_id;
    
    /**
     * Video width and height as defined by sender
     */
    private Integer length;
    
    /**
     * Duration of the video in seconds as defined by sender
     */
    private Integer duration;
    
    /**
     * Optional. Video thumbnail
     */
    private PhotoSize thumb;

    /**
     * Optional. File size
     */
    private Integer file_size;
    
}
