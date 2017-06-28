/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents a portion of the price for goods or services.
 */
@ToString
@Getter @Setter
public class LabeledPrice {
    
    /**
     * Portion label
     */
    private String label;
    
    /**
     * Price of the product in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in https://core.telegram.org/bots/payments/currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    private Integer amount;
    
}
