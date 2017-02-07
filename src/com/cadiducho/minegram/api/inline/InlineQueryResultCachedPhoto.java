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
 * Represents a link to a photo stored on the Telegram servers.
 * By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can provide <i>message_text</i> to send it instead of photo.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedPhoto extends InlineQueryResult {

    /**
     * A valid file identifier of the photo
     */
    private String photo_file_id;

    /**
     * Optional. Title for the result
     */
    private String title;

    /**
     * Optional. Short description of the result
     */
    private String description;

    /**
     * Optional. Caption of the photo to be sent, 0-200 characters
     */
    private String caption;

    public InlineQueryResultCachedPhoto() {
        super("photo");
    }

    /**
     *
     * @param photo_file_id A valid file identifier of the photo
     */
    public InlineQueryResultCachedPhoto(String photo_file_id) {
        this();
        this.photo_file_id = photo_file_id;
    }

    /**
     *
     * @param photo_file_id A valid file identifier of the photo
     * @param title Optional. Title for the result
     * @param description Optional. Short description of the result
     * @param caption Optional. Caption of the photo to be sent, 0-200 characters
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedPhoto(String photo_file_id, String title, String description, String caption, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.photo_file_id = photo_file_id;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
