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
 * Represents a link to a voice message stored on the Telegram servers
 * By default, this voice recording will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the the voice message.
 */
@ToString
@Getter @Setter
public class InlineQueryResultCachedVoice extends InlineQueryResult {

    /**
     * A valid file identifier for the voice message
     */
    private String voice_file_id;

    /**
     * Recording title
     */
    private String title;

    /**
     * Optional. Caption, 0-200 characters
     */
    private String caption;

    public InlineQueryResultCachedVoice() {
        super("voice");
    }

    /**
     *
     * @param voice_file_id A valid file identifier for the voice message
     * @param title Title
     */
    public InlineQueryResultCachedVoice(String voice_file_id, String title) {
        this();
        this.voice_file_id = voice_file_id;
        this.title = title;
    }

    /**
     *
     * @param voice_file_id A valid file identifier for the voice message
     * @param title Title
     * @param caption Optional. Caption, 0-200 characters
     * @param performer Optional. Performer
     */
    public InlineQueryResultCachedVoice(String voice_file_id, String title, String caption, String performer) {
        this();
        this.voice_file_id = voice_file_id;
        this.title = title;
        this.caption = caption;
    }
    
}
