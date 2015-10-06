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
 * This object represents a voice note.
 */
@ToString
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Voice {

    /**
     * Unique identifier for this file
     */
    private String file_id;
    
    /**
     * Duration of the audio in seconds as defined by sender
     */
    private Integer duration;
    
    /**
     * Optional. MIME type of the file as defined by sender
     */
    private String mime_type;
    
    /**
     * Optional. File size
     */
    private Integer file_size;
}
