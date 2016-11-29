/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
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
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “left” or “kicked”
     */
    private String status;
    
    private void determineStatus() {
        switch (status) {
            case "creator": chatMemberStatus = ChatMemberStatus.CREATOR;
            case "administrator": chatMemberStatus = ChatMemberStatus.ADMINISTRATOR;
            case "kicked": chatMemberStatus = ChatMemberStatus.KICKED;
            case "left": chatMemberStatus = ChatMemberStatus.LEFT;
            default: chatMemberStatus = ChatMemberStatus.MEMBER;
        }
    }
    
    public enum ChatMemberStatus {
        CREATOR,
        ADMINISTRATOR,
        MEMBER,
        LEFT,
        KICKED
    }
    
    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “left” or “kicked”
     */
    private ChatMemberStatus chatMemberStatus;
    
    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “left” or “kicked”
     * @return {@link ChatMemberStatus}
     */
    public ChatMemberStatus getChatMemberStatus() {
        if (chatMemberStatus == null) 
            determineStatus();
        return chatMemberStatus;
    }
}
