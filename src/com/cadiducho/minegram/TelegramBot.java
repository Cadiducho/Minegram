/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.File;
import com.cadiducho.minegram.api.Message;
import com.cadiducho.minegram.api.Update;
import com.cadiducho.minegram.api.User;
import com.cadiducho.minegram.api.UserProfilePhotos;
import com.cadiducho.minegram.api.exception.TelegramException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import java.io.IOException;
import java.util.List;
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

    @Override
    public Message sendMessage(Integer chatId, String text) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendMessage(Integer chatId, String text, String parse_mode, Boolean disable_web_page_preview, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message forwardMessage(Integer chat_id, Integer from_chat_id, Integer message_id) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendPhoto(Integer chat_id, String photo, String caption, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendPhoto(Integer chat_id, File photo, String caption, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendAudio(Integer chat_id, String audio) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendAudio(Integer chat_id, File audio) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendAudio(Integer chat_id, String audio, Integer duration, String performer, String title, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendAudio(Integer chat_id, File audio, Integer duration, String performer, String title, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendDocument(Integer chat_id, String document) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendDocument(Integer chat_id, File document) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendDocument(Integer chat_id, String document, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendDocument(Integer chat_id, File document, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendSticker(Integer chat_id, String sticker) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendSticker(Integer chat_id, File sticker) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendSticker(Integer chat_id, String sticker, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendSticker(Integer chat_id, File sticker, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVideo(Integer chat_id, String video) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVideo(Integer chat_id, File video) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVideo(Integer chat_id, String video, Integer duration, String performer, String title, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVideo(Integer chat_id, File video, Integer duration, String performer, String title, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVoice(Integer chat_id, String voice) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVoice(Integer chat_id, String voice, Integer duration, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendVoice(Integer chat_id, File voice, Integer duration, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendLocation(Integer chat_id, Float latitude, Float longitude) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Message sendLocation(Integer chat_id, Float latitude, Float longitude, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Boolean sendChatAction(Integer chat_id, String action) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(Integer user_id) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(Integer user_id, Integer offset, Integer limit) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public File getFile(String file_id) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Boolean setWebhook(String url, File certificate) throws TelegramException {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
