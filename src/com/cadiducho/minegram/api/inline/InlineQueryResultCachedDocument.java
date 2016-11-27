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
public class InlineQueryResultCachedDocument extends InlineQueryResult {

    /**
     * Title of the result
     */
    private String title;

    /**
     * A valid file identifier for the file
     */
    private String document_file_id;
    
    /**
     * Optional. Caption, 0-200 characters
     */
    private String caption;
    
    /**
     * Optional. Short description of the result
     */
    private String description;
    

    public InlineQueryResultCachedDocument() {
        super("document");
    }

    /**
     *
     * @param document_file_id A valid file identifier for the file
     * @param title Title for the result
     */
    public InlineQueryResultCachedDocument(String document_file_id, String title) {
        this();
        this.document_file_id = document_file_id;
        this.title = title;
    }

    /**
     *
     * @param document_file_id A valid file identifier for the file
     * @param title Title for the result
     * @param caption Optional. Caption of the document to be sent, 0-200 characters
     * @param description Optional. Short description of the result
     * @param reply_markup Optional. Inline keyboard attached to the message
     * @param input_message_content Optional. Content of the message
     */
    public InlineQueryResultCachedDocument(String document_file_id, String title, String caption, String description, 
                                            InlineKeyboardMarkup reply_markup, InputMessageContent input_message_content) {
        this();
        this.document_file_id = document_file_id;
        this.title = title;
        this.caption = caption;
        this.description = description;
        this.reply_markup = reply_markup;
        this.input_message_content = input_message_content;
    }
    
}
