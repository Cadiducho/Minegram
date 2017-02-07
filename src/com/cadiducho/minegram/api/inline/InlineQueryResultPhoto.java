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
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultPhoto(String photo_url, String thumb_url, Integer photo_width, Integer photo_height,
                                  String title, String description, String caption, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.photo_url = photo_url;
        this.photo_width = photo_width;
        this.photo_height = photo_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
