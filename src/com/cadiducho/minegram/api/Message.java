/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class Message {

    /**
     * Unique message identifier
     */
    private Integer message_id;
         
    /**
     * Sender
     */
    private User from;
    
    /**
     * Date the message was sent in Unix time
     */
    private Integer date;
    
    /**
     * Conversation the message belongs to — user in case of a private message, GroupChat in case of a group. User or GroupChat.
     */
    private Object chat;
    
    /**
     * Optional. For forwarded messages, sender of the original message
     */
    private User forward_from;
    
    /**
     * Optional. For forwarded messages, date the original message was sent in Unix time
     */
    private Integer forward_date;
    
    /**
     * Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    private Message reply_to_message;
    
    /**
     * Optional. For text messages, the actual UTF-8 text of the message
     */
    private String text;
    
    /**
     * Optional. Message is an audio file, information about the file
     */
    private Audio audio;
    
    /**
     * Optional. Message is a general file, information about the file
     */
    private Document document;
    
    /**
     * Optional. Message is a photo, available sizes of the photo
     */
    private List<PhotoSize> photo;
    
    /**
     * Optional. Message is a sticker, information about the sticker
     */
    private Sticker sticker;
    
    /**
     * Optional. Message is a video, information about the video
     */
    private Video video;
    
    /**
     * Optional. Message is a voice message, information about the file
     */
    private Voice voice;
    
    /**
     * Optional. Caption for the photo or video
     */
    private String caption;
    
    /**
     * Optional. Message is a shared contact, information about the contact
     */
    private Contact contact;

    /**
     * Optional. A new member was added to the group, information about them (this member may be bot itself)
     */
    private User new_chat_participant;
    
    /**
     * Optional. A member was removed from the group, information about them (this member may be bot itself)
     */
    private User left_chat_participant;
    
    /**
     * Optional. Message is a shared location, information about the location
     */
    private String new_chat_title;
    
    /**
     * Optional. A group photo was change to this value
     */
    private List<PhotoSize> new_chat_photo;
    
    /**
     * Optional. Informs that the group photo was deleted
     */
    private Boolean delete_chat_photo; 
    
    /**
     * Optional. Informs that the group has been created
     */
    private Boolean group_chat_created;

}
