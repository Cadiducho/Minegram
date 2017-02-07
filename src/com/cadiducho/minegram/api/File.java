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
 * This object represents a file ready to be downloaded. 
 * The file can be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>. 
 * It is guaranteed that the link will be valid for at least 1 hour. 
 * When the link expires, a new one can be requested by calling getFile.
 */
@ToString
@Getter @Setter
public class File {

    /**
     * Unique identifier for this file
     */
    private String file_id;
    
    /**
     * Optional. File size, if known
     */
    private Integer file_size;
    
    /**
     * Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
     */
    private String file_path;
}
