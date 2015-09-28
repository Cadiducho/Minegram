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

/**
 * This object represents a sticker.
 */
@ToString
@Getter @Setter
public class Sticker {
    
    /**
     * Unique identifier for this file
     */
    private String file_id;
    
    /**
     * Sticker width
     */
    private Integer width;
    
    /**
     * Sticker height
     */
    private Integer height;
    
    /**
     * Optional. Sticker thumbnail in .webp or .jpg format
     */
    private PhotoSize thumb;
    
    /**
     * Optional. File size
     */
    private Integer file_size;

}
