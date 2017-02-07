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
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 */
@ToString
@Getter @Setter
public class MessageEntity {
    
    /**
     * Type of the entity. Can be mention (@username), hashtag, bot_command, url, email, bold (bold text), 
     *      italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs), 
     *      text_mention (for users without usernames)
     */
    private String type;
    
    /**
     * Offset in UTF-16 code units to the start of the entity
     */
    private Integer offset;
    
    /**
     * Length of the entity in UTF-16 code units
     */
    private Integer lenght;
    
    /**
     * Optional. For “text_link” only, url that will be opened after user taps on the text
     */
    private String url;
    
    /**
     * Optional. For “text_mention” only, the mentioned user
     */
    private User user;
    
}
