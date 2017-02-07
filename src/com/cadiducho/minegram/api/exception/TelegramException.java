/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.exception;

public class TelegramException extends Exception {

    public TelegramException() {
    }

    public TelegramException(String message) {
        super(message);
    }

    public TelegramException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelegramException(Throwable cause) {
        super(cause);
    }

    public TelegramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
