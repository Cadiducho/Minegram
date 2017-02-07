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
 * This object represents a phone contact.
 */
@ToString
@Getter @Setter
public class Contact {
    
    /**
     * Contact's phone number
     */
    private String phone_number;
    
    /**
     * Contact's first name
     */
    private String first_name;
    
    /**
     * Optional. Contact's last name
     */
    private String last_name;
    
    /**
     * Optional. Contact's user identifier in Telegram
     */
    private Integer user_id;
}
