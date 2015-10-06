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

/*
 * Telegram User or Telegram Bot
 */
@ToString
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    
    /**
     * Unique identifier for this user or bot
     */
    private Integer id;
    
    /**
     * User‘s or bot’s first name
     */
    private String first_name;
    
    /**
     * Optional. User‘s or bot’s last name
     */
    private String last_name;
    
    /**
     * Optional. User‘s or bot’s username
     */
    private String username;
}
