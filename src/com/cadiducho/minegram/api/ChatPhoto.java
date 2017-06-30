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
 * This object represents a point on the map.
 */
@ToString
@Getter @Setter
public class ChatPhoto {

    /**
     * Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
     */
    private String small_file_id;
    
    /**
     * Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
     */
    private String big_file_id;
}
