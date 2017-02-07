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
 * This object represents one button of the reply keyboard. 
 * For simple text buttons String can be used instead of this object to specify text of the button. 
 * Optional fields are mutually exclusive.
 */
@ToString
@Getter @Setter
public class KeyboardButton {
    
    /**
     * Text of the button. If none of the optional fields are used, it will be sent to the bot as a message when the button is pressed
     */
    private String text;

    /**
     * Optional. If True, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
     */
    private Boolean request_contact;
    
    /**
     * Optional. If True, the user's current location will be sent when the button is pressed. Available in private chats only
     */
    private Boolean request_location;
}
