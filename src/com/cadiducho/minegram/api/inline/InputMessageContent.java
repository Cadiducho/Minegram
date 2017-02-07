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
 * This object represents the content of a message to be sent as a result of an inline query. 
 * Telegram clients currently support the following 4 types:
 * <ul>
 * <li>{@link InputTextMessageContent}</li>
 * <li>{@link InputLocationMessageContent}</li>
 * <li>{@link InputVenueMessageContent}</li>
 * <li>{@link InputContactMessageContent}</li>
 * </ul>
 */
@ToString
@Getter @Setter
public abstract class InputMessageContent {
}
