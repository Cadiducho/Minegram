/*
 * The MIT License
 *
 * Copyright 2017 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.cadiducho.minegram.api.inline.ChosenInlineResult;
import com.cadiducho.minegram.api.inline.InlineQuery;
import com.cadiducho.minegram.api.payment.PreCheckoutQuery;
import com.cadiducho.minegram.api.payment.ShippingQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object represents an incoming update.
 */
@ToString
@Getter @Setter
public class Update {
    
    /**
     * The update‘s unique identifier. 
     * Update identifiers start from a certain positive number and increase sequentially. 
     * This ID becomes especially handy if you’re using Webhooks, 
     * since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order.
     */
    private Integer update_id;
    
    /**
     * Optional. New incoming message of any kind — text, photo, sticker, etc.
     */
    private Message message;
    
    /**
     * Optional. New version of a message that is known to the bot and was edited
     */
    private Message edited_message;
    
    /**
     * Optional. New incoming channel post of any kind — text, photo, sticker, etc.
     */
    private Message channel_post;
    
    /**
     * Optional. New version of a channel post that is known to the bot and was edited
     */
    private Message edited_channel_post;
    /**
     * Optional. New incoming <a href="https://core.telegram.org/bots/api#inline-mode" >inline</a> query
     */
    private InlineQuery inline_query;
    
    /**
     * 	Optional. The result of an New incoming <a href="https://core.telegram.org/bots/api#inline-mode" >inline</a> query query that was chosen by a user and sent to their chat partner.
     */
    private ChosenInlineResult chosen_inline_result;
    
    /**
     * Optional. New incoming callback query
     */
    private CallbackQuery callback_query;
    
    /**
     * Optional. New incoming shipping query. Only for invoices with flexible price
     */
    private ShippingQuery shipping_query;
    
    /**
     * Optional. New incoming pre-checkout query. Contains full information about checkout
     */
    private PreCheckoutQuery pre_checkout_query;
    
}
