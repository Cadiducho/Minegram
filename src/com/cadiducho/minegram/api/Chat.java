/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

/**
 * Represents a chat.
 * This might be a chat with a {@link User} or a {@link GroupChat}
 */
@ToString
@Getter @Setter
public class Chat {
    
    /**
     * Unique identifier for this user or bot
     */
    private Integer id;
    
    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    private String type;
    
    /**
     * Optional. Title, for channels and group chats
     */
    private String title;
    
    /**
     * Optional. Username, for private chats and channels if available
     */
    private String username;
    
    /**
     * Optional. First name of the other party in a private chat
     */
    private String first_name;
    
    /**
     * Optional. Last name of the other party in a private chat
     */
    private String last_name; 
    
    /**
     * Type of chat, can be either private, group, supergroup or channel
     */
    private ChatType chatType;
    
    public ChatType getChatType() {
        if (chatType == null) 
            determineChatType();
        return chatType;
    }
    
    private void determineChatType() {
        switch (type) {
            case "private": chatType = ChatType.PRIVATE;
            case "group": chatType = ChatType.GROUP;
            case "supergroup": chatType = ChatType.SUPERGROUP;
            case "channel": chatType = ChatType.CHANNEL;
            default: chatType = ChatType.UNKNOWN;
        }
    }
    
    public enum ChatType {
        PRIVATE,
        GROUP,
        SUPERGROUP,
        CHANNEL,
        UNKNOWN
    }
    
    /**
     * @return Whether this is a chat with a {@link User}
     */
    public boolean isUser() {
        return title == null;
    }
    
    /**
     * @return Whether this is a {@link GroupChat}
     */
    public boolean isGroupChat() {
        return !isUser();
    }
    
    /**
     * Returns this chat as a {@link User}.
     * Before invoking, check whether this chat is actually a chat with a user
     * by calling {@link Chat#isUser()}.
     *
     * @return This chat as a {@link User} object
     */
    public User asUser() {
        final Map<String, Object> par = new HashMap<>();
        par.put("id", id);
        par.put("first_name", first_name);
        par.put("last_name", last_name);
        par.put("username", username);
        
        JSONObject obj = new JSONObject(par);
        return new Gson().fromJson(obj.toString(), User.class);
    }
}
