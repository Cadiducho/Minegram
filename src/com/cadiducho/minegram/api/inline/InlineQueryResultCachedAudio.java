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
 * Represents a link to an mp3 audio file stored on the Telegram servers.
 * By default, this audio file will be sent by the user. 
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the audio.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedAudio extends InlineQueryResult {
    
    /**
     * A valid file identifier for the audio file
     */
    private String audio_file_id;

    /**
     * Optional. Caption, 0-200 characters
     */
    private String caption;

    public InlineQueryResultCachedAudio() {
        super("audio");
    }

    /**
     *
     * @param audio_file_id A valid file identifier for the audio file
     */
    public InlineQueryResultCachedAudio(String audio_file_id) {
        this();
        this.audio_file_id = audio_file_id;
    }

    /**
     *
     * @param audio_file_id A valid file identifier for the audio file
     * @param caption Optional. Caption, 0-200 characters
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedAudio(String audio_file_id, String caption, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.audio_file_id = audio_file_id;
        this.caption = caption;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
