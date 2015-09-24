/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.User;
import com.cadiducho.minegram.api.exception.TelegramException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import java.io.IOException;
import org.bukkit.plugin.Plugin;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;


public class TelegramBot implements BotAPI {
    
    private final String apiUrl;
    private final Plugin bukkitPlugin;
    
    private final ObjectMapper mapper = new ObjectMapper();

    public TelegramBot(String token, Plugin plugin){
        apiUrl = "https://api.telegram.org/bot" + token + "/";
        bukkitPlugin = plugin;
        MinegramPlugin.bots.put(this, bukkitPlugin);
    }

    @Override
    public User getMe() throws TelegramException {
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getMe"));

        try {
            return mapper.readValue(resultBody, User.class);
        } catch (IOException e) {
            throw new TelegramException("Could not deserialize response!", e);
        }
    }
    
    @Override
    public Plugin getBukkitPlugin() {
        return bukkitPlugin;
    }
    
    private String handleRequest(BaseRequest request) throws TelegramException {
        JSONObject jsonResult = null;
        try {
            jsonResult = request.asJson().getBody().getObject();
        } catch (UnirestException e) {
            throw new TelegramException("Could not get a response.", e);
        }

        if(jsonResult.get("ok").equals(false)){
            throw new TelegramException(jsonResult.getString("description"));
        }

        return jsonResult.get("result").toString();
    }
    
}
