/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Chat {
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Unique identifier for this user or bot
     */
    private Integer id;
    
    /**
     * User‘s or bot’s first name
     */
    private String first_name;
    
    /**
     * Optional. User‘s or bot’s last name
     */
    private String last_name;
    
    /**
     * Optional. User‘s or bot’s username
     */
    private String username;
    
    /**
     * Group name
     */
    private String title;
    
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
     * @throws java.io.IOException
     */
    public User asUser() throws IOException {
        final Map<String, Object> par = new HashMap<>();
        par.put("id", id);
        par.put("first_name", first_name);
        par.put("last_name", last_name);
        par.put("username", username);
        
        JSONObject obj = new JSONObject(par);
        return mapper.readValue(obj.toString(), User.class);
    }
    
    /**
     * Returns this chat as a {@link GroupChat}.
     * Before invoking this method, check whether this chat is actually a group chat
     * by calling {@link Chat#isGroupChat()}.
     *
     * @return This chat as a {@link GroupChat} object
     * @throws java.io.IOException
     */
    public GroupChat asGroupChat() throws IOException {
        final Map<String, Object> par = new HashMap<>();
        par.put("id", id);
        par.put("title", title);
        
        JSONObject obj = new JSONObject(par);
        return mapper.readValue(obj.toString(), GroupChat.class);
    }
}
