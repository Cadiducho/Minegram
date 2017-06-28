/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.payment;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents one shipping option.
 */
@ToString
@Getter @Setter
public class ShippingOption {
    
    /**
     * Shipping option identifier
     */
    private String id;
    
    /**
     * Option title
     */
    private String title;
    
    /**
     * List of price portions
     */
    private List<LabeledPrice> prices;
    
}
