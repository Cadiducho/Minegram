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
 * This object contains basic information about a successful payment.
 */
@ToString
@Getter @Setter
public class SuccessfulPayment {
    
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
    
    /**
     * Telegram payment identifier
     */
    private String telegram_payment_charge_id;
    
    /**
     * Provider payment identifier
     */
    private String provider_payment_charge_id;
    
}
