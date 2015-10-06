/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represent a user's profile pictures.
 */
@ToString
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfilePhotos {
    
    /**
     * Total number of profile pictures the target user has
     */
    private Integer total_count;
    
    /**
     * Requested profile pictures (in up to 4 sizes each)
     */
    private List<List<PhotoSize>> photos;

}
