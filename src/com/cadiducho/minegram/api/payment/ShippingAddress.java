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
 * This object represents a shipping address.
 */
@ToString
@Getter @Setter
public class ShippingAddress {
    
    /**
     * ISO 3166-1 alpha-2 country code
     */
    private String country_code;
    
    /**
     * State, if applicable
     */
    private String state;
    
    /**
     * City
     */
    private String city;
    
    /**
     * First line for the address
     */
    private String street_line1;
    
    /**
     * Second line for the address
     */
    private String street_line2;
    
    /**
     * Address post code
     */
    private String post_code;
    
}
