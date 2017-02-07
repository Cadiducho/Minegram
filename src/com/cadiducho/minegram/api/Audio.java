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
 * This object represents an audio file to be treated as music by the Telegram clients.
 */
@ToString
@Getter @Setter
public class Audio {

    /**
     * Unique identifier for this file
     */
    private String file_id;

    /**
     * Duration of the audio in seconds as defined by sender
     */
    private Integer duration;
    
    /**
     * Optional. Performer of the audio as defined by sender or by audio tags
     */
    private String performer;
    
    /**
     * Optional. Title of the audio as defined by sender or by audio tags
     */
    private String title;

    /**
     * Optional. MIME type of the file as defined by sender
     */
    private String mime_type;

    /**
     * Optional. File size
     */
    private Integer file_size;
}
