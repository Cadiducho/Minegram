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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default,
 * this animated MPEG-4 file will be sent by the user with optional caption. Alternatively,
 * you can provide message_text to send it instead of the animation.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult {

    /**
     * A valid file identifier for the MP4 file
     */
    private String mpeg4_file_id;

    /**
     * Optional. Title for the result
     */
    private String title;

    /**
     * Optional. Caption of the MPEG-4 file to be sent, 0-200 characters
     */
    private String caption;

    public InlineQueryResultCachedMpeg4Gif() {
        super("mpeg4_gif");
    }

    /**
     *
     * @param mpeg4_file_id A valid file identifier for the MP4 file
     */
    public InlineQueryResultCachedMpeg4Gif(String mpeg4_file_id) {
        this();
        this.mpeg4_file_id = mpeg4_file_id;
    }

    /**
     *
     * @param mpeg4_file_id A valid URL for the MP4 file. File size must not exceed 1MB
     * @param title Optional. Title for the result
     * @param caption Optional. Caption of the MPEG-4 file to be sent, 0-200 characters
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedMpeg4Gif(String mpeg4_file_id, String title, String caption, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.mpeg4_file_id = mpeg4_file_id;
        this.title = title;
        this.caption = caption;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
