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
public class PhotoSize {

    /**
     * Unique identifier for this file
     */
    private String file_id;

    /**
     * Photo width
     */
    private Integer width;
    
    /**
     * Photo height
     */
    private Integer height;
    
    /**
     * Optional. File size
     */
    private Integer file_size;
}
