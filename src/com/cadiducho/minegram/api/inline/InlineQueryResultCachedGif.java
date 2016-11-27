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
 * Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with optional
 * caption. Alternatively, you can provide <i>message_text</i> to send it instead of the animation.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedGif extends InlineQueryResult {
    
    /**
     * A valid URL for the GIF file. File size must not exceed 1MB
     */
    private String gif_file_id;

    /**
     * Optional. Title for the result
     */
    private String title;

    /**
     * Optional. Caption of the GIF file to be sent, 0-200 characters
     */
    private String caption;

    public InlineQueryResultCachedGif() {
        super("gif");
    }

    /**
     *
     * @param gif_file_id A valid file identifier for the GIF file
     */
    public InlineQueryResultCachedGif(String gif_file_id) {
        this();
        this.gif_file_id = gif_file_id;
    }

    /**
     *
     * @param gif_file_id A valid file identifier for the GIF file
     * @param title Optional. Title for the result
     * @param caption Optional. Caption of the GIF file to be sent, 0-200 characters
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedGif(String gif_file_id,String title, String caption, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.gif_file_id = gif_file_id;
        this.title = title;
        this.caption = caption;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
