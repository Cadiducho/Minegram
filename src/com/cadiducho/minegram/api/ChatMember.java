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
 * This object contains information about one member of the chat.
 * See {@link ChatMember#getChatMemberStatus()}
 */
@ToString
@Getter @Setter
public class ChatMember {
    
    /**
     * 	Information about the user
     */
    private User user;
    
    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
     */
    private String status;
    
    private void determineStatus() {
        switch (status) {
            case "creator": chatMemberStatus = ChatMemberStatus.CREATOR;
            case "administrator": chatMemberStatus = ChatMemberStatus.ADMINISTRATOR;
            case "restricted": chatMemberStatus = ChatMemberStatus.RESTRICTED;
            case "kicked": chatMemberStatus = ChatMemberStatus.KICKED;
            case "left": chatMemberStatus = ChatMemberStatus.LEFT;
            default: chatMemberStatus = ChatMemberStatus.MEMBER;
        }
    }
    
    public enum ChatMemberStatus {
        CREATOR,
        ADMINISTRATOR,
        MEMBER,
        RESTRICTED,
        LEFT,
        KICKED
    }
    
    private ChatMemberStatus chatMemberStatus;
    
    /**
     * The member's status in the chat
     * @return {@link ChatMemberStatus}
     */
    public ChatMemberStatus getChatMemberStatus() {
        if (chatMemberStatus == null) 
            determineStatus();
        return chatMemberStatus;
    }
    
    /**
     * Optional. Restictred and kicked only.
     * Date when restrictions will be lifted for this user, unix time
     */
    private Integer until_date;
    
    /**
     * Optional. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
     */
    private Boolean can_be_edited;
    
    /**
     * Optional. Administrators only. True, if the administrator can change the chat title, photo and other settings
     */
    private Boolean can_change_info;
    
    /**
     * Optional. Administrators only. True, if the administrator can post in the channel, channels only
     */
    private Boolean can_post_messages;
    
    /**
     * Optional. Administrators only. True, if the administrator can edit messages of other users, channels only
     */
    private Boolean can_edit_messages;
    
    /**
     * Optional. Administrators only. True, if the administrator can delete messages of other users
     */
    private Boolean can_delete_messages;
    
    /**
     * Optional. Administrators only. True, if the administrator can invite new users to the chat
     */
     private Boolean can_invite_users;
     
     /**
      * Optional. Administrators only. True, if the administrator can restrict, ban or unban chat members
      */
     private Boolean can_restrict_members;
     
     /**
      * Optional. Administrators only. True, if the administrator can pin messages, supergroups only
      */
     private Boolean can_pin_messages;
     
     /**
      * Optional. Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
      */
     private Boolean can_promote_members;
     
     /**
      * Optional. Restricted only. True, if the user can send text messages, contacts, locations and venues
      */
     private Boolean can_send_messages;
     
     /**
      * Optional. Restricted only. True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
      */
     private Boolean can_send_media_messages;
     
     /**
      * Optional. Restricted only. True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages
      */
     private Boolean can_send_other_messages;
     
     /**
      * Optional. Restricted only. True, if user may add web page previews to his messages, implies can_send_media_messages
      */
     private Boolean can_add_web_page_previews;
}
