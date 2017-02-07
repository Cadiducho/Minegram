/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Contains information about the current status of a webhook.
 */
@ToString
@Getter @Setter
public class WebhookInfo {
    
    /**
     * Webhook URL, may be empty if webhook is not set up
     */
    private String url;
    
    /**
     * True, if a custom certificate was provided for webhook certificate checks
     */
    private Boolean has_custom_certificate;
    
    /**
     * Number of updates awaiting delivery
     */
    private Integer pending_update_count;
    
    /**
     * Optional. Unix time for the most recent error that happened when trying to deliver an update via webhook
     */
    private Integer last_error_date;
    
    /**
     * Optional. Error message in human-readable format for the most recent error 
     * that happened when trying to deliver an update via webhook
     */
    private String last_error_message;
    
}
