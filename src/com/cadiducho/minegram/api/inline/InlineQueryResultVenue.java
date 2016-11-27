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
 * Represents a venue. By default, the venue will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the venue.
 */
@ToString
@Getter @Setter
public class InlineQueryResultVenue extends InlineQueryResult {

    /**
     * Location title
     */
    private String title;

    /**
     * Address of the venue
     */
    private String address;
    
    /**
     * Location latitude in degrees
     */
    private Float latitude;
    
    /**
     * 	Location longitude in degrees
     */
    private Float longitude;

    /**
     * Optional. Foursquare identifier of the venue if known
     */
    private String foursquare_id;
    
    /**
     * Optional. URL of the thumbnail (jpeg only) for the file
     */
    private String thumb_url;
    
    /**
     * Optional. Thumbnail width
     */
    private Integer thumb_width;
    
    /**
     * Optional. Thumbnail height
     */
    private Integer thumb_height;

    public InlineQueryResultVenue() {
        super("venue");
    }

    /**
     *
     * @param title Location title
     * @param address Address of the venue
     * @param latitude Location latitude in degrees
     * @param longitude Location longitude in degrees
     */
    public InlineQueryResultVenue(String title, String address, Float latitude, Float longitude) {
        this();
        this.title = title;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @param title Location title
     * @param address Address of the venue
     * @param foursquare_id Optional. Foursquare identifier of the venue if known
     * @param latitude Location latitude in degrees
     * @param longitude Location longitude in degrees
     * @param thumb_url Optional. URL of the thumbnail (jpeg only) for the file
     * @param thumb_width Optional. Thumbnail width
     * @param thumb_height Optional. Thumbnail height
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultVenue(String title, String address, String foursquare_id, Float latitude, Float longitude,
                                    String thumb_url, Integer thumb_width, Integer thumb_height,
                                    InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.title = title;
        this.address = address;
        this.foursquare_id = foursquare_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.thumb_url = thumb_url;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
