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
 * Represents a link to an article or web page.
 */
@ToString
@Getter @Setter
public class InlineQueryResultArticle extends InlineQueryResult {
    
    /**
     * Title of the result
     */
    private String title;

    /**
     * Text of the message to be sent
     */
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show bold, italic and inline URLs in your bot's message.
     */ 
    private String parse_mode;

    /**
     * Optional. Disables link previews for links in the sent message
     */  
    private Boolean disable_web_page_preview;

    /**
     * Optional. URL of the result
     */   
    private String url;

    /**
     * Optional. Pass True, if you don't want the URL to be shown in the message
     */    
    private Boolean hide_url;

    /**
     * Optional. Short description of the result
     */  
    private String description;

    /**
     * Optional. Url of the thumbnail for the result
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

    public InlineQueryResultArticle() {
        super("article");
    }

    /**
     *
     * @param title Title of the result
     * @param message_text Text of the message to be sent
     */
    public InlineQueryResultArticle(String title, String message_text) {
        this();
        this.title = title;
        this.message_text = message_text;
    }

    /**
     *
     * @param title Title of the result
     * @param message_text Text of the message to be sent
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show bold, italic and inline URLs in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     * @param url Optional. URL of the result
     * @param hide_url Optional. Pass True, if you don't want the URL to be shown in the message
     * @param description Optional. Short description of the result
     * @param thumb_url Optional. Url of the thumbnail for the result
     * @param thumb_width Optional. Thumbnail width
     * @param thumb_height Optional. Thumbnail height
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message to be sent
     */
    public InlineQueryResultArticle(String title, String message_text, String parse_mode,
                                    Boolean disable_web_page_preview, String url, Boolean hide_url, String description,
                                    String thumb_url, Integer thumb_width, Integer thumb_height, InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.title = title;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
        this.url = url;
        this.hide_url = hide_url;
        this.description = description;
        this.thumb_url = thumb_url;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
