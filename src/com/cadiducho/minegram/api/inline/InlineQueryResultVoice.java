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
 * Represents a link to a voice recording in an .ogg container encoded with OPUS.
 * By default, this voice recording will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the the voice message.
 */
@ToString
@Getter @Setter
public class InlineQueryResultVoice extends InlineQueryResult {

    /**
     * 	A valid URL for the voice recording
     */
    private String voice_url;

    /**
     * Recording title
     */
    private String title;

    /**
     * Optional. Caption, 0-200 characters
     */
    private String caption;

    /**
     * Optional. Recording duration in seconds
     */
    private Integer voice_duration;

    public InlineQueryResultVoice() {
        super("voice");
    }

    /**
     *
     * @param voice_url A valid URL for the voice recording
     * @param title Title
     */
    public InlineQueryResultVoice(String voice_url, String title) {
        this();
        this.voice_url = voice_url;
        this.title = title;
    }

    /**
     *
     * @param voice_url A valid URL for the voice recording
     * @param title Title
     * @param caption Optional. Caption, 0-200 characters
     * @param performer Optional. Performer
     * @param voice_duration Optional. Recording duration in seconds
     */
    public InlineQueryResultVoice(String voice_url, String title, String caption, String performer, Integer voice_duration) {
        this();
        this.voice_url = voice_url;
        this.title = title;
        this.caption = caption;
        this.voice_duration = voice_duration;
    }
    
}
