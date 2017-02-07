/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents one result of an inline query.
 * Telegram clients currently support results of the following 5 types:
 * <ul>
 * <li>{@link InlineQueryResultCachedAudio}</li>
 * <li>{@link InlineQueryResultCachedDocument}</li>
 * <li>{@link InlineQueryResultCachedGif}</li>
 * <li>{@link InlineQueryResultCachedMpeg4Gif}</li>
 * <li>{@link InlineQueryResultCachedPhoto}</li>
 * <li>{@link InlineQueryResultCachedSticker}</li>
 * <li>{@link InlineQueryResultCachedVideo}</li>
 * <li>{@link InlineQueryResultCachedVoice}</li>
 * <li>{@link InlineQueryResultArticle}</li>
 * <li>{@link InlineQueryResultAudio}</li>
 * <li>{@link InlineQueryResultContact}</li>
 * <li>{@link InlineQueryResultDocument}</li>
 * <li>{@link InlineQueryResultGif}</li>
 * <li>{@link InlineQueryResultLocation}</li>
 * <li>{@link InlineQueryResultMpeg4Gif}</li>
 * <li>{@link InlineQueryResultPhoto}</li>
 * <li>{@link InlineQueryResultVenue}</li>
 * <li>{@link InlineQueryResultVideo}</li>
 * <li>{@link InlineQueryResultVoice}</li> 
 * </ul>
 */
@ToString
@Getter @Setter
public abstract class InlineQueryResult {
    
    /**
     * Type of the result
     */
    protected final String type;

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    protected String id;
    
    /**
     * Optional. Inline keyboard attached to the message
     */
    protected InlineKeyboardMarkup reply_markup;
    
    /**
     * Optional. Content of the message to be sent instead of the file
     */
    protected InputMessageContent input_message_content;

    public InlineQueryResult(String type) {
        this.type = type;
        this.id = UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", "");
    }

}
