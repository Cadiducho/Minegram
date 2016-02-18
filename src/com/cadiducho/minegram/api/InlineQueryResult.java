/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents one result of an inline query.
 * Telegram clients currently support results of the following 5 types:
 * <ul>
 * <li>{@link InlineQueryResultArticle}</li>
 * <li>{@link InlineQueryResultPhoto}</li>
 * <li>{@link InlineQueryResultGif}</li>
 * <li>{@link InlineQueryResultMpeg4Gif}</li>
 * <li>{@link InlineQueryResultVideo}</li>
 * </ul>
 */
@ToString
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class InlineQueryResult {
    
    /**
     * Type of the result
     */
    protected final String type;

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    protected String id;

    public InlineQueryResult(String type) {
        this.type = type;
        this.id = UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", "");
    }

}
