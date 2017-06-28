/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.payment;

import com.cadiducho.minegram.api.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object contains information about an incoming pre-checkout query.
 */
@ToString
@Getter @Setter
public class PreCheckoutQuery {
    
    /**
     * Unique query identifier
     */
    private String id;
    
    /**
     * User who sent the query
     */
    private User from;
    
    /**
     * Three-letter ISO 4217 currency code
     */
    private String currency;
    
    /**
     * Total price in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in https://core.telegram.org/bots/payments/currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    private Integer total_amount;
    
    /**
     * Bot specified invoice payload
     */
    private String invoce_payload;
    
    /**
     * Optional. Identifier of the shipping option chosen by the user
     */
    private String shipping_option_id;
    
    /**
     * Optional. Order info provided by the user
     */
    private OrderInfo order_info;
    
}
