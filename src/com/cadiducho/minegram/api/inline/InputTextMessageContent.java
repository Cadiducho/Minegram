
/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 */
@ToString
@Getter @Setter
public class InputTextMessageContent extends InputMessageContent {
    
    /**
     * Text of the message to be sent, 1-4096 characters
     */
    private String message_text;
    
    /**
     * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, 
     * fixed-width text or inline URLs in your bot's message.
     */
    private String parse_mode;
    
    /**
     * Optional. Disables link previews for links in the sent message
     */
    private Boolean disable_web_page_preview;
}
