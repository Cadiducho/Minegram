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
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 * Currently, only .PDF and .ZIP files can be sent using this method.
 */
@ToString
@Getter @Setter
public class InlineQueryResultDocument extends InlineQueryResult {

    /**
     * Title of the result
     */
    private String title;

    /**
     * A valid URL for the file
     */
    private String document_url;
    
    /**
     * Mime type of the content of the file, either “application/pdf” or “application/zip”
     */
    private String mime_type;
    
    /**
     * Optional. Caption, 0-200 characters
     */
    private String caption;
    
    /**
     * Optional. Short description of the result
     */
    private String description;
    
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

    public InlineQueryResultDocument() {
        super("document");
    }

    /**
     *
     * @param document_url A valid URL for the file
     * @param mime_type Mime type of the content of the file, either “application/pdf” or “application/zip”
     * @param title Title for the result
     */
    public InlineQueryResultDocument(String document_url, String title, String mime_type) {
        this();
        this.document_url = document_url;
        this.title = title;
        this.mime_type = mime_type;
    }

    /**
     *
     * @param document_url A valid URL for the file
     * @param mime_type Mime type of the content of the file, either “application/pdf” or “application/zip”
     * @param title Title for the result
     * @param caption Optional. Caption of the document to be sent, 0-200 characters
     * @param description Optional. Short description of the result
     * @param thumb_url Optional. URL of the thumbnail (jpeg only) for the file
     * @param thumb_width Optional. Thumbnail width
     * @param thumb_height Optional. Thumbnail height
     */
    public InlineQueryResultDocument(String document_url, String title, String mime_type, String caption, 
                        String description, String thumb_url, Integer thumb_width, Integer thumb_height) {
        this();
        this.document_url = document_url;
        this.title = title;
        this.mime_type = mime_type;
        this.caption = caption;
        this.description = description;
        this.thumb_url = thumb_url;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
    }
    
}
