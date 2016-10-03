/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 */
@ToString
@Getter @Setter
public class InlineKeyboardMarkup {

    /**
     * Array of button rows, each represented by an Array of {@link InlineKeyboardButton} objects
     */
    private List<List<InlineKeyboardButton>> inline_keyboard;
}
