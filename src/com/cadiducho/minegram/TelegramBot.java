/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.inline.InlineKeyboardMarkup;
import com.cadiducho.minegram.api.inline.InlineQueryResult;
import com.cadiducho.minegram.api.*;
import com.cadiducho.minegram.api.exception.TelegramException;
import com.cadiducho.minegram.api.handlers.UpdatesPoller;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.plugin.Plugin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.Validate;
import org.json.JSONObject;


public class TelegramBot implements BotAPI {
    
    private final String apiUrl;
    @Getter private final Plugin bukkitPlugin;
    @Getter private final BotAPI instance;
    @Getter @Setter private Boolean updatesPolling;
    
    private final Gson gson = new Gson();
    
    public TelegramBot(String token, Plugin plugin){
        this(token, true, plugin);
    }
    
    public TelegramBot(String token, boolean pollthread, Plugin plugin){
        Validate.notNull(plugin, "Plugin cannot be null!");
        instance = (BotAPI) this;
        apiUrl = "https://api.telegram.org/bot" + token + "/";
        bukkitPlugin = plugin;
        updatesPolling = pollthread;
        UpdatesPoller updatesPoller = new UpdatesPoller(this);
        MinegramPlugin.bots.put(instance, bukkitPlugin);
    }
      
    @Override
    public User getMe() throws TelegramException {
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getMe"));

        return gson.fromJson(resultBody, User.class);
    }
    
    //handleRequest and checkReply by Rainu
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
    
    private void checkChatId(Object chatId) {
        if(chatId != null){
            if(!(   chatId instanceof String ||
                    chatId instanceof Integer ||
                    chatId instanceof Long)){

                throw new IllegalStateException("The chatId must be a String or a Number!");
            }
        }
    }
     
    private void checkReply(Object replyMarkup) {
        if(replyMarkup != null){
            if(!(   replyMarkup instanceof ReplyKeyboardHide ||
                    replyMarkup instanceof ReplyKeyboardMarkup ||
                    replyMarkup instanceof InlineKeyboardMarkup ||
                    replyMarkup instanceof ForceReply)){

                throw new IllegalStateException("The replyMarkup must be on of the following classes: " +
                    ReplyKeyboardHide.class.getName() + ", " +
                    ReplyKeyboardMarkup.class.getName() + ", " +
                    InlineKeyboardMarkup.class.getName() + ", " +
                    ForceReply.class.getName());
            }
        }
    }
    
    private Map<String, Object> safe(String str, Object obj) throws TelegramException {
        final Map<String, Object> parameters = new HashMap<>();
        
        //Check markup style if exists
        if(obj != null && str.equals("reply_markup")) {
            parameters.put("reply_markup", gson.toJson(obj));
            return parameters;
        }
        
        //Return normal values (check optionals -> null)
        if (obj != null) parameters.put(str, obj);
        
        return parameters;
    }
    //----------------
    
    @Override
    public Message sendMessage(Object chat_id, String text) throws TelegramException {
        return sendMessage(chat_id, text, null, null, false, null, null);
    }

    @Override
    public Message sendMessage(Object chat_id, String text, String parse_mode, Boolean disable_web_page_preview, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("text", text));
        par.putAll(safe("parse_mode", parse_mode));
        par.putAll(safe("disable_web_page_preview", disable_web_page_preview));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));

        final String resultBody = handleRequest(Unirest.post(apiUrl + "sendMessage").fields(par));

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message forwardMessage(Object chat_id, Integer from_chat_id, Integer message_id) throws TelegramException {
        return forwardMessage(chat_id, from_chat_id, false, null);
    }
    
    @Override
    public Message forwardMessage(Object chat_id, Integer from_chat_id, Boolean disable_notification, Integer message_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("from_chat_id", from_chat_id));
        par.putAll(safe("message_id", message_id));     
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "forwardMessage").queryString(par));

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendPhoto(Object chat_id, String photo) throws TelegramException {
        return sendPhoto(chat_id, photo, null, false, null, null);
    }
    
    @Override
    public Message sendPhoto(Object chat_id, File photo) throws TelegramException {
        return sendPhoto(chat_id, photo, null, false, null, null);
    }
    
    @Override
    public Message sendPhoto(Object chat_id, Object photo, String caption, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("caption", caption));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody;
        if (photo instanceof String) {
            par.put("photo", photo);

            resultBody = handleRequest(Unirest.post(apiUrl + "sendPhoto").fields(par));
        } else if(photo instanceof File) {
            resultBody = handleRequest(Unirest.post(apiUrl + "sendPhoto").queryString(par).field("photo", (File) photo));
        } else {
            throw new IllegalArgumentException("The photo must be a string or a file!");
        }

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendAudio(Object chat_id, String audio) throws TelegramException {
        return sendAudio(chat_id, audio, null, null,  null, null, false, null, null);
    }

    @Override
    public Message sendAudio(Object chat_id, File audio) throws TelegramException {
        return sendAudio(chat_id, audio, null, null, null, null, false, null, null);
    }

    @Override
    public Message sendAudio(Object chat_id, Object audio, String caption, Integer duration, String performer, String title, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("caption", caption));
        par.putAll(safe("duration", duration));
        par.putAll(safe("performer", performer));
        par.putAll(safe("title", title));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody;
        if (audio instanceof String) {
            par.put("audio", audio);

            resultBody = handleRequest(Unirest.post(apiUrl + "sendAudio").fields(par));
        } else if(audio instanceof File) {
            resultBody = handleRequest(Unirest.post(apiUrl + "sendAudio").queryString(par).field("audio", (File) audio));
        } else {
            throw new IllegalArgumentException("The audio must be a string or a file!");
        }

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendDocument(Object chat_id, String document) throws TelegramException {
        return sendDocument(chat_id, document, false, null, null);
    }

    @Override
    public Message sendDocument(Object chat_id, File document) throws TelegramException {
        return sendDocument(chat_id, document, false, null, null);
    }

    @Override
    public Message sendDocument(Object chat_id, Object document, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody;
        if (document instanceof String) {
            par.put("audio", document);

            resultBody = handleRequest(Unirest.post(apiUrl + "sendDocument").fields(par));
        } else if(document instanceof File) {
            resultBody = handleRequest(Unirest.post(apiUrl + "sendDocument").queryString(par).field("document", (File) document));
        } else {
            throw new IllegalArgumentException("The document must be a string or a file!");
        }

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendSticker(Object chat_id, String sticker) throws TelegramException {
        return sendSticker(chat_id, sticker, false, null, null);
    }

    @Override
    public Message sendSticker(Object chat_id, File sticker) throws TelegramException {
        return sendSticker(chat_id, sticker, false, null, null);
    }

    @Override
    public Message sendSticker(Object chat_id, Object sticker, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody;
        if (sticker instanceof String) {
            par.put("audio", sticker);

            resultBody = handleRequest(Unirest.post(apiUrl + "sendSticker").fields(par));
        } else if(sticker instanceof File) {
            resultBody = handleRequest(Unirest.post(apiUrl + "sendSticker").queryString(par).field("sticker", (File) sticker));
        } else {
            throw new IllegalArgumentException("The sticker must be a string or a file!");
        }

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendVideo(Object chat_id, String video) throws TelegramException {
        return sendVideo(chat_id, video, null, null, null, false, null, null);
    }

    @Override
    public Message sendVideo(Object chat_id, File video) throws TelegramException {
        return sendVideo(chat_id, video, null, null, null, false, null, null);
    }

    @Override
    public Message sendVideo(Object chat_id, Object video, Integer duration, String performer, String title, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("duration", duration));
        par.putAll(safe("performer", performer));
        par.putAll(safe("title", title));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody;
        if (video instanceof String) {
            par.put("video", video);

            resultBody = handleRequest(Unirest.post(apiUrl + "sendVideo").fields(par));
        } else if(video instanceof File) {
            resultBody = handleRequest(Unirest.post(apiUrl + "sendVideo").queryString(par).field("video", (File) video));
        } else {
            throw new IllegalArgumentException("The video must be a string or a file!");
        }

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendVoice(Object chat_id, String voice) throws TelegramException {
        return sendVoice(chat_id, voice, null, null, false, null, null);
    }

    @Override
    public Message sendVoice(Object chat_id, File voice) throws TelegramException {
        return sendVoice(chat_id, voice, null, null, false, null, null);
    }

    @Override
    public Message sendVoice(Object chat_id, Object voice, String caption, Integer duration, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("caption", caption));
        par.putAll(safe("duration", duration));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody;
        if (voice instanceof String) {
            par.put("voice", voice);

            resultBody = handleRequest(Unirest.post(apiUrl + "sendVoice").fields(par));
        } else if(voice instanceof File) {
            resultBody = handleRequest(Unirest.post(apiUrl + "sendVoice").queryString(par).field("voice", (File) voice));
        } else {
            throw new IllegalArgumentException("The voice must be a string or a file!");
        }

        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendLocation(Object chat_id, Float latitude, Float longitude) throws TelegramException {
        return sendLocation(chat_id, latitude, longitude, false, null, null);
    }

    @Override
    public Message sendLocation(Object chat_id, Float latitude, Float longitude, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("latitude", latitude));
        par.putAll(safe("longitude", longitude));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));

        final String resultBody = handleRequest(Unirest.post(apiUrl + "sendLocation").fields(par));
        return gson.fromJson(resultBody, Message.class);
    }
    
    @Override
    public Message sendVenue(Object chat_id, Float latitude, Float longitude, String title, String address) throws TelegramException {
        return sendVenue(chat_id, latitude, longitude, title, address, null, false, null, null);
    }

    @Override
    public Message sendVenue(Object chat_id, Float latitude, Float longitude, String title, String address, String foursquare_id, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("latitude", latitude));
        par.putAll(safe("longitude", longitude));
        par.putAll(safe("title", title));
        par.putAll(safe("address", address));
        par.putAll(safe("foursquare_id", foursquare_id));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));

        final String resultBody = handleRequest(Unirest.post(apiUrl + "sendVenue").fields(par));
        return gson.fromJson(resultBody, Message.class);
    }

    @Override
    public Message sendContact(Object chat_id, String phone_number, String first_name) throws TelegramException {
        return sendContact(chat_id, phone_number, first_name, null, false, null, null);
    }

    @Override
    public Message sendContact(Object chat_id, String phone_number, String first_name, String last_name, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException {
        checkChatId(chat_id);
        checkReply(reply_markup);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("phone_number", phone_number));
        par.putAll(safe("first_name", first_name));
        par.putAll(safe("last_name", last_name));
        par.putAll(safe("disable_notification", disable_notification));
        par.putAll(safe("reply_to_message_id", reply_to_message_id));
        par.putAll(safe("reply_markup", reply_markup));

        final String resultBody = handleRequest(Unirest.post(apiUrl + "sendContact").fields(par));
        return gson.fromJson(resultBody, Message.class);
    }
    
    @Override
    public Boolean sendChatAction(Object chat_id, ChatAction action) throws TelegramException {
        return sendChatAction(chat_id, action.name());
    }
    
    @Override
    public Boolean sendChatAction(Object chat_id, String action) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("action", action));
        
        final String resultBody = handleRequest(Unirest.post(apiUrl + "sendChatAction").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(Integer user_id) throws TelegramException {
        return getUserProfilePhotos(user_id, null, null);
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(Integer user_id, Integer offset, Integer limit) throws TelegramException {
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("user_id", user_id));
        par.putAll(safe("offset", offset));
        par.putAll(safe("limit", limit));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getUserProfilePhotos").queryString(par));
        return gson.fromJson(resultBody, UserProfilePhotos.class);
    }

    @Override
    public File getFile(String file_id) throws TelegramException {
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("file_id", file_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getFile").queryString(par));
        return gson.fromJson(resultBody, File.class);
    }
    
    @Override
    public Boolean kickChatMember(Object chat_id, Integer user_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("user_id", user_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "kickChatMember").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }
    
    @Override
    public Boolean leaveChat(Object chat_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "leaveChat").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public Boolean unbanChatMember(Object chat_id, Integer user_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("user_id", user_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "unbanChatMember").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }
    
    @Override
    public Chat getChat(Object chat_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getChat").queryString(par));
        return gson.fromJson(resultBody, Chat.class);
    }
    
    @Override
    public List<ChatMember> getChatAdministrators(Object chat_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));

        final String resultBody = handleRequest(Unirest.get(apiUrl + "getChatAdministrators").queryString(par));
        Type listType = new TypeToken<List<ChatMember>>() {}.getType();
        return gson.fromJson(resultBody, listType);
    }
    
    @Override
    public Integer getChatMembersCount(Object chat_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getChatMembersCount").queryString(par));
        return gson.fromJson(resultBody, Integer.class);
    }
    
    @Override
    public ChatMember getChatMember(Object chat_id, Integer user_id) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("user_id", user_id));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getChatMember").queryString(par));
        return gson.fromJson(resultBody, ChatMember.class);
    }
    
    @Override
    public Boolean answerCallbackQuery(String callback_query_id) throws TelegramException {
        return answerCallbackQuery(callback_query_id, null, false, null);
    }

    @Override
    public Boolean answerCallbackQuery(String callback_query_id, String text, Boolean show_alert, String url) throws TelegramException {
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("callback_query_id", callback_query_id));
        par.putAll(safe("text", text));
        par.putAll(safe("show_alert", show_alert));
        par.putAll(safe("url", url));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "answerCallbackQuery").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }
    
    @Override
    public Boolean editMessageText(Object chat_id, Integer message_id, String inline_message_id, String text, String parse_mode, Boolean disable_web_page_preview, InlineKeyboardMarkup reply_markup) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("message_id", message_id));
        par.putAll(safe("inline_message_id", inline_message_id));
        par.putAll(safe("text", text));
        par.putAll(safe("parse_mode", parse_mode));
        par.putAll(safe("disable_web_page_preview", disable_web_page_preview));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "editMessageText").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public Boolean editMessageCaption(Object chat_id, Integer message_id, String inline_message_id, String caption, InlineKeyboardMarkup reply_markup) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("message_id", message_id));
        par.putAll(safe("caption", caption));
        par.putAll(safe("inline_message_id", inline_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "editMessageText").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public Boolean editMessageReplyMarkup(Object chat_id, Integer message_id, String inline_message_id, InlineKeyboardMarkup reply_markup) throws TelegramException {
        checkChatId(chat_id);
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("chat_id", chat_id));
        par.putAll(safe("message_id", message_id));
        par.putAll(safe("inline_message_id", inline_message_id));
        par.putAll(safe("reply_markup", reply_markup));
        
        final String resultBody = handleRequest(Unirest.get(apiUrl + "editMessageText").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout) throws TelegramException {
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("offset", offset));
        par.putAll(safe("limit", limit));
        par.putAll(safe("timeout", timeout));

        final String resultBody = handleRequest(Unirest.get(apiUrl + "getUpdates").queryString(par));
        Type listType = new TypeToken<List<Update>>() {}.getType();
        return gson.fromJson(resultBody, listType);
    }
    
    @Override
    public WebhookInfo getWebhookInfo() throws TelegramException {
        final String resultBody = handleRequest(Unirest.get(apiUrl + "getWebhookInfo"));

        return gson.fromJson(resultBody, WebhookInfo.class);
    }
    

    @Override
    public Boolean setWebhook(String url, File certificate) throws TelegramException {
        final Map<String, Object> par = new HashMap<>();
        
        par.putAll(safe("url", url));
        par.putAll(safe("certificate", certificate));

        final String resultBody = handleRequest(Unirest.get(apiUrl + "setWebhook").queryString(par));
        return "True".equalsIgnoreCase(resultBody);
    }
    
    @Override
    public Boolean answerInlineQuery(String inlineQueryId, List<InlineQueryResult> results) throws TelegramException {
        return answerInlineQuery(inlineQueryId, results, null, null, null, null, null);
    }

    @Override
    public Boolean answerInlineQuery(String inlineQueryId, List<InlineQueryResult> results, Integer cache_time, Boolean is_personal, String next_offset,
            String switch_pm_text, String switch_pm_parameter) throws TelegramException {

        final Map<String, Object> par = new HashMap<>();
        par.putAll(safe("inline_query_id", inlineQueryId));

        par.put("results", gson.toJson(results));

        par.putAll(safe("cache_time", cache_time));
        par.putAll(safe("is_personal", is_personal));
        par.putAll(safe("next_offset", next_offset));
        par.putAll(safe("switch_pm_text", switch_pm_text));
        par.putAll(safe("switch_pm_parameter", switch_pm_parameter));

        final String resultBody = handleRequest(Unirest.get(apiUrl + "answerInlineQuery").queryString(par));

        return "True".equalsIgnoreCase(resultBody);
    }
}
