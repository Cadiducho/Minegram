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
 * Represents a link to a photo.
 * By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can provide <i>message_text</i> to send it instead of photo.
 */
@ToString
@Getter @Setter
public class InlineQueryResultPhoto extends InlineQueryResult {

    /**
     * A valid URL of the photo. Photo must be in <b>jpeg</b> format. Photo size must not exceed 5MB
     */
    private String photo_url;

    /**
     * Optional. Width of the photo
     */
    private Integer photo_width;

    /**
     * Optional. Height of the photo
     */
    private Integer photo_height;

    /**
     * URL of the thumbnail for the photo
     */
    private String thumb_url;

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

    /**
     * Optional. Text of a message to be sent instead of the photo, 1-512 characters
     */
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show
     * <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     * in your bot's message.
     */
    private String parse_mode;

    public InlineQueryResultPhoto() {
        super("photo");
    }

    /**
     *
     * @param photo_url A valid URL of the photo. Photo must be in <b>jpeg</b> format. Photo size must not exceed 5MB
     * @param thumb_url URL of the thumbnail for the photo
     */
    public InlineQueryResultPhoto(String photo_url, String thumb_url) {
        this();
        this.photo_url = photo_url;
        this.thumb_url = thumb_url;
    }

    /**
     *
     * @param photo_url A valid URL of the photo. Photo must be in <b>jpeg</b> format. Photo size must not exceed 5MB
     * @param thumb_url URL of the thumbnail for the photo
     * @param photo_width Optional. Width of the photo
     * @param photo_height Optional. Height of the photo
     * @param title Optional. Title for the result
     * @param description Optional. Short description of the result
     * @param caption Optional. Caption of the photo to be sent, 0-200 characters
     * @param message_text Optional. Text of a message to be sent instead of the photo, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     */
    public InlineQueryResultPhoto(String photo_url, String thumb_url, Integer photo_width, Integer photo_height,
                                  String title, String description, String caption, String message_text,
                                  String parse_mode) {
        this();
        this.photo_url = photo_url;
        this.photo_width = photo_width;
        this.photo_height = photo_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
    }
    
}
