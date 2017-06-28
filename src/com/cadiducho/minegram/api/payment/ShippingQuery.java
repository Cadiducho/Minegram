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
 * This object contains information about an incoming shipping query.
 */
@ToString
@Getter @Setter
public class ShippingQuery {
    
    /**
     * Unique query identifier
     */
    private String id;
    
    /**
     * User who sent the query
     */
    private User from;
    
    /**
     * Bot specified invoice payload
     */
    private String invoice_payload;
    
    /**
     * User specified shipping address
     */
    private ShippingAddress shipping_address;
    
}
