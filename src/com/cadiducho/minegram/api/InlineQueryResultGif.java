/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional
 * caption. Alternatively, you can provide <i>message_text</i> to send it instead of the animation.
 */
@ToString
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultGif extends InlineQueryResult {
    
    /**
     * A valid URL for the GIF file. File size must not exceed 1MB
     */
    private String gif_url;

    /**
     * Optional. Width of the GIF
     */
    private Integer gif_width;

    /**
     * Optional. Height of the GIF
     */
    private Integer gif_height;

    /**
     * URL of the static thumbnail for the result (jpeg or gif)
     */
    private String thumb_url;

    /**
     * Optional. Title for the result
     */
    private String title;

    /**
     * Optional. Caption of the GIF file to be sent, 0-200 characters
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

    public InlineQueryResultGif() {
        super("gif");
    }

    /**
     *
     * @param gif_url A valid URL for the GIF file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail for the result (jpeg or gif)
     */
    public InlineQueryResultGif(String gif_url, String thumb_url) {
        this();
        this.gif_url = gif_url;
        this.thumb_url = thumb_url;
    }

    /**
     *
     * @param gif_url A valid URL for the GIF file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail for the result (jpeg or gif)
     * @param gif_width Optional. Width of the GIF
     * @param gif_height Optional. Height of the GIF
     * @param title Optional. Title for the result
     * @param caption Optional. Caption of the GIF file to be sent, 0-200 characters
     * @param message_text Optional. Text of a message to be sent instead of the animation, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     */
    public InlineQueryResultGif(String gif_url, String thumb_url, Integer gif_width, Integer gif_height, String title,
                                String caption, String message_text, String parse_mode, Boolean disable_web_page_preview) {
        this();
        this.gif_url = gif_url;
        this.gif_width = gif_width;
        this.gif_height = gif_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.caption = caption;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
    }
    
}
