/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 */
@ToString
@Getter @Setter
public class InlineKeyboardButton {

    /**
     * Label text on the button
     */
    private String text;
    
    /**
     * Optional. HTTP url to be opened when button is pressed
     */
    private String url;
    
    /**
     * 	Optional. Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     */
    private String callback_data;
    
    /**
     * Optional. If set, pressing the button will prompt the user to select one of their chats, 
     * open that chat and insert the bot‘s username and the specified inline query in the input field. 
     * Can be empty, in which case just the bot’s username will be inserted.
     * 
     * Note: This offers an easy way for users to start using your bot in inline mode when they are currently in a private chat with it. 
     * Especially useful when combined with switch_pm… actions – in this case the user will be automatically returned to the chat they switched from, 
     * skipping the chat selection screen.
     */
    private String switch_inline_query;
    
    private String switch_inline_query_current_chat;
}
