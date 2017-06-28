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
 * This object represents information about an order.
 */
@ToString
@Getter @Setter
public class OrderInfo {
    
    /**
     * Optional. User name
     */
    private String name;
    
    /**
     * Optional. User's phone number
     */
    private String phone_number;
    
    /**
     * Optional. User email
     */
    private String email;
    
    /**
     * Optional. User shipping address
     */
    private ShippingAddress shipping_address;
    
}
