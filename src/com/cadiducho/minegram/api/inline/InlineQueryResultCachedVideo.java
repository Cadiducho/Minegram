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
 * Represents a link to a video file stored on the Telegram servers.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the video.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedVideo extends InlineQueryResult {

    /**
     * A valid file identifier for the file
     */
    private String video_file_id;

    /**
     * Title for the result
     */
    private String title;

    /**
     * Optional. Short description of the result
     */
    private String description;

    public InlineQueryResultCachedVideo() {
        super("video");
    }

    /**
     *
     * @param video_file_id A valid file identifier for the file
     * @param title Title for the result
     */
    public InlineQueryResultCachedVideo(String video_file_id, String title) {
        this();
        this.video_file_id = video_file_id;
        this.title = title;
    }

    /**
     *
     * @param video_file_id A valid file identifier for the file
     * @param title Title for the result
     * @param description Optional. Short description of the result
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedVideo(String video_file_id, String title, String description, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.video_file_id = video_file_id;
        this.title = title;
        this.description = description;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
