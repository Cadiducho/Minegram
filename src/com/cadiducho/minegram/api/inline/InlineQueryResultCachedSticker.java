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
 * Represents a link to a sticker stored on the Telegram servers.
 * By default, this sticker will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the sticker.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedSticker extends InlineQueryResult {
    
    /**
     * A valid file identifier of the sticker
     */
    private String sticker_file_id;

    public InlineQueryResultCachedSticker() {
        super("sticker");
    }

    /**
     *
     * @param sticker_file_id A valid file identifier of the sticker
     */
    public InlineQueryResultCachedSticker(String sticker_file_id) {
        this();
        this.sticker_file_id = sticker_file_id;
    }
    
    /**
     *
     * @param sticker_file_id A valid file identifier of the sticker
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedSticker(String sticker_file_id, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.sticker_file_id = sticker_file_id;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
}
