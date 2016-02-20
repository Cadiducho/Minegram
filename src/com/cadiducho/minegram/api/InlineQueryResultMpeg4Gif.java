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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default,
 * this animated MPEG-4 file will be sent by the user with optional caption. Alternatively,
 * you can provide message_text to send it instead of the animation.
 */
@ToString
@Getter @Setter
public class InlineQueryResultMpeg4Gif extends InlineQueryResult {

    /**
     * A valid URL for the MP4 file. File size must not exceed 1MB
     */
    private String mpeg4_url;

    /**
     * Optional. Video width
     */
    private Integer mpeg4_width;

    /**
     * Optional. Video height
     */
    private Integer mpeg4_height;

    /**
     * URL of the static thumbnail (jpeg or gif) for the result
     */
    private String thumb_url;

    /**
     * Optional. Title for the result
     */
    private String title;

    /**
     * Optional. Caption of the MPEG-4 file to be sent, 0-200 characters
     */
    private String caption;

    /**
     * Optional. Text of a message to be sent instead of the animation, 1-512 characters
     */
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show
     * <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a> in your bot's message.
     */
    private String parse_mode;

    /**
     * Optional. Disables link previews for links in the sent message
     */
    private Boolean disable_web_page_preview;

    public InlineQueryResultMpeg4Gif() {
        super("mpeg4_gif");
    }

    /**
     *
     * @param mpeg4_url A valid URL for the MP4 file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail (jpeg or gif) for the result
     */
    public InlineQueryResultMpeg4Gif(String mpeg4_url, String thumb_url) {
        this();
        this.mpeg4_url = mpeg4_url;
        this.thumb_url = thumb_url;
    }

    /**
     *
     * @param mpeg4_url A valid URL for the MP4 file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail (jpeg or gif) for the result
     * @param mpeg4_width Optional. Video width
     * @param mpeg4_height Optional. Video height
     * @param title Optional. Title for the result
     * @param caption Optional. Caption of the MPEG-4 file to be sent, 0-200 characters
     * @param message_text Optional. Text of a message to be sent instead of the animation, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     */
    public InlineQueryResultMpeg4Gif(String mpeg4_url, String thumb_url, Integer mpeg4_width, Integer mpeg4_height,
                                     String title, String caption, String message_text, String parse_mode,
                                     Boolean disable_web_page_preview) {
        this();
        this.mpeg4_url = mpeg4_url;
        this.mpeg4_width = mpeg4_width;
        this.mpeg4_height = mpeg4_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.caption = caption;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
    }
    
}
