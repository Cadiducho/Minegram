/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a location on a map. By default, the location will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the location.
 */
@ToString
@Getter @Setter
public class InlineQueryResultContact extends InlineQueryResult {

    /**
     * Contact's phone number
     */
    private String phone_number;
    
    /**
     * 	Contact's first name
     */
    private String first_name;
    
    /**
     * Optional. Contact's last name
     */
    private String last_name;
    
    /**
     * Optional. URL of the thumbnail (jpeg only) for the file
     */
    private String thumb_url;
    
    /**
     * Optional. Thumbnail width
     */
    private Integer thumb_width;
    
    /**
     * Optional. Thumbnail height
     */
    private Integer thumb_height;

    public InlineQueryResultContact() {
        super("contact");
    }

    /**
     *
     * @param phone_number Contact's phone number
     * @param first_name Contact's first name
     */
    public InlineQueryResultContact(String phone_number, String first_name) {
        this();
        this.phone_number = phone_number;
        this.first_name = first_name;
    }

    /**
     *
     * @param phone_number Contact's phone number
     * @param first_name Contact's first name
     * @param last_name Optional. Contact's last name
     * @param thumb_url Optional. URL of the thumbnail (jpeg only) for the file
     * @param thumb_width Optional. Thumbnail width
     * @param thumb_height Optional. Thumbnail height
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultContact(String phone_number, String first_name, String last_name, 
                                    String thumb_url, Integer thumb_width, Integer thumb_height,
                                    InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.thumb_url = thumb_url;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
