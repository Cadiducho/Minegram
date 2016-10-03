/*
 * The MIT License
 *
 * Copyright 2015 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram;

import com.cadiducho.minegram.api.*;
import com.cadiducho.minegram.api.exception.*;
import java.util.List;
import org.bukkit.plugin.Plugin;

/*
 * Interface to build Telegrams Bots 
 */
public interface BotAPI {

    //---- Custom Methods ----//
    
    /**
     * Get Bukkit Plugin object. 
     * @return Plugin
     */
    public Plugin getBukkitPlugin();
    
    /**
     * Return true if updates thread is enabled, or false if not.
     * @return true or false
     */
    public Boolean getUpdatesPolling();
    
    /**
     * Enable or disable updates threa
     * @param bool True to enable or false to disable
     */
    public void setUpdatesPolling(Boolean bool);
    
    //---- Telegram Methods ----//
    
    /**
     * A simple method for testing your bot's auth token. Requires no parameters. Returns basic information about the bot in form of a {@link User} object.
     * @return {@link User}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public User getMe() throws TelegramException;
    
    /**
     * Use this method to send text messages. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param text Text of the message to be sent
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendMessage(Integer chat_id, String text) throws TelegramException;
    
    /**
     * Use this method to send text messages. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param text Text of the message to be sent
     * @param parse_mode Send Markdown, if you want Telegram apps to show bold, italic and inline URLs in your bot's message. For the moment, only Telegram for Android supports this.
     *                  See https://core.telegram.org/bots/api#using-markdown
     * @param disable_web_page_preview Disables link previews for links in this message
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendMessage(Integer chat_id, String text, String parse_mode, Boolean disable_notification, Boolean disable_web_page_preview, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to forward messages of any kind. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param message_id Unique message identifier
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */ 
    public Message forwardMessage(Integer chat_id, Integer from_chat_id, Integer message_id) throws TelegramException;
    
    /**
     * Use this method to forward messages of any kind. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param message_id Unique message identifier
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */ 
    public Message forwardMessage(Integer chat_id, Integer from_chat_id, Boolean disable_notification, Integer message_id) throws TelegramException;
    
    /**
     * Use this method to send photos. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo Photo to send. You can either pass a file_id as String to resend a photo that is already on the Telegram servers, or upload a new photo using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendPhoto(Integer chat_id, String photo) throws TelegramException;
    
    /**
     * Use this method to send photos. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo Photo to send. You can either pass a file_id as String to resend a photo that is already on the Telegram servers, or upload a new photo using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendPhoto(Integer chat_id, File photo) throws TelegramException;
    
    /**
     * Use this method to send photos. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo Photo to send. You can either pass a file_id as String to resend a photo that is already on the Telegram servers, or upload a new photo using multipart/form-data.
     * @param caption Photo caption (may also be used when resending photos by file_id).
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendPhoto(Integer chat_id, Object photo, String caption, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to send audio files, if you want Telegram clients to display them in the music player. 
     * Your audio must be in the .mp3 format. On success, the sent {@link Message} is returned. 
     * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
     * 
     * For backward compatibility, when the fields title and performer are both empty and the mime-type of the file to be sent is not audio/mpeg, 
     * the file will be sent as a playable voice message. For this to work, the audio must be in an .ogg file encoded with OPUS. 
     * This behavior will be phased out in the future. For sending voice messages, use the sendVoice method instead.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio Audio file to send. You can either pass a file_id as String to resend an audio that is already on the Telegram servers, or upload a new audio file using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendAudio(Integer chat_id, String audio) throws TelegramException;
    
    /**
     * Use this method to send audio files, if you want Telegram clients to display them in the music player. 
     * Your audio must be in the .mp3 format. On success, the sent {@link Message} is returned. 
     * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
     * 
     * For backward compatibility, when the fields title and performer are both empty and the mime-type of the file to be sent is not audio/mpeg, 
     * the file will be sent as a playable voice message. For this to work, the audio must be in an .ogg file encoded with OPUS. 
     * This behavior will be phased out in the future. For sending voice messages, use the sendVoice method instead.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio Audio file to send. You can either pass a file_id as String to resend an audio that is already on the Telegram servers, or upload a new audio file using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendAudio(Integer chat_id, File audio) throws TelegramException;
    
    /**
     * Use this method to send audio files, if you want Telegram clients to display them in the music player. 
     * Your audio must be in the .mp3 format. On success, the sent {@link Message} is returned. 
     * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
     * 
     * For backward compatibility, when the fields title and performer are both empty and the mime-type of the file to be sent is not audio/mpeg, 
     * the file will be sent as a playable voice message. For this to work, the audio must be in an .ogg file encoded with OPUS. 
     * This behavior will be phased out in the future. For sending voice messages, use the sendVoice method instead.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio Audio file to send. You can either pass a file_id as String to resend an audio that is already on the Telegram servers, or upload a new audio file using multipart/form-data.
     * @param duration Duration of the audio in seconds
     * @param performer Performer
     * @param title Track name
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendAudio(Integer chat_id, Object audio, Integer duration, String performer, String title, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned. 
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document File to send. You can either pass a file_id as String to resend a file that is already on the Telegram servers, 
     *                  or upload a new file using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendDocument(Integer chat_id, String document) throws TelegramException;
    
    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned. 
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document File to send. You can either pass a file_id as String to resend a file that is already on the Telegram servers, 
     *                  or upload a new file using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendDocument(Integer chat_id, File document) throws TelegramException;
    
    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned. 
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document File to send. You can either pass a file_id as String to resend a file that is already on the Telegram servers, 
     *                  or upload a new file using multipart/form-data.
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendDocument(Integer chat_id, Object document, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    
    /**
     * Use this method to send .webp stickers. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker Sticker to send. You can either pass a file_id as String to resend a sticker that is already on the Telegram servers, 
     *                  or upload a new sticker using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendSticker(Integer chat_id, String sticker) throws TelegramException;
    
    /**
     * Use this method to send .webp stickers. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker Sticker to send. You can either pass a file_id as String to resend a sticker that is already on the Telegram servers, 
     *                  or upload a new sticker using multipart/form-data.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendSticker(Integer chat_id, File sticker) throws TelegramException;
    
    /**
     * Use this method to send .webp stickers. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker Sticker to send. You can either pass a file_id as String to resend a sticker that is already on the Telegram servers, 
     *                  or upload a new sticker using multipart/form-data.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendSticker(Integer chat_id, Object sticker, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    
    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as {@link Document}). 
     * On success, the sent {@link Message} is returned. 
     * Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video Video to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, 
     *                  or upload a new video file using multipart/form-data.
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVideo(Integer chat_id, String video) throws TelegramException;
    
    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as {@link Document}). 
     * On success, the sent {@link Message} is returned. 
     * Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video Video to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, 
     *                  or upload a new video file using multipart/form-data.
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVideo(Integer chat_id, File video) throws TelegramException;
    
    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned. 
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video Video file to send. You can either pass a file_id as String to resend an audio that is already on the Telegram servers, or upload a new audio file using multipart/form-data.
     * @param duration Duration of the audio in seconds
     * @param performer Performer
     * @param title Track name
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVideo(Integer chat_id, Object video, Integer duration, String performer, String title, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. 
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}). 
     * On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice Audio file to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, 
     *                  or upload a new video file using multipart/form-data.
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVoice(Integer chat_id, String voice) throws TelegramException;
    
    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. 
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}). 
     * On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice Audio file to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, 
     *                  or upload a new video file using multipart/form-data.
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVoice(Integer chat_id, File voice) throws TelegramException;
    
    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. 
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}). 
     * On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice Audio file to send. You can either pass a file_id as String to resend a video that is already on the Telegram servers, 
     *                  or upload a new video file using multipart/form-data.
     * @param duration Duration of the audio in seconds
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVoice(Integer chat_id, Object voice, Integer duration, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to send point on the map. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of location
     * @param longitude Longitude of location
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendLocation(Integer chat_id, Float latitude, Float longitude) throws TelegramException;
    
    /**
     * Use this method to send point on the map. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of location
     * @param longitude Longitude of location
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendLocation(Integer chat_id, Float latitude, Float longitude, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to send information about a venue. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of the venue
     * @param longitude Longitude of the venue
     * @param title Name of the venue
     * @param address Address of the venue
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVenue(Integer chat_id, Float latitude, Float longitude, String title, String address) throws TelegramException;
    
    /**
     * Use this method to send information about a venue. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of the venue
     * @param longitude Longitude of the venue
     * @param title Name of the venue
     * @param address Address of the venue
     * @param foursquare_id Foursquare identifier of the venue
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVenue(Integer chat_id, Float latitude, Float longitude, String title, String address, String foursquare_id, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method to send phone contacts. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param phone_number Contact's phone number
     * @param first_name Contact's first name
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendContact(Integer chat_id, String phone_number, String first_name)  throws TelegramException;
    
    /**
     * Use this method to send phone contacts. On success, the sent {@link Message} is returned.
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param phone_number Contact's phone number
     * @param first_name Contact's first name
     * @param last_name Contact's last name
     * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users will receive a notification with no sound.
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws TelegramException 
     */
    public Message sendContact(Integer chat_id, String phone_number, String first_name, String last_name, Boolean disable_notification, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    /**
     * Use this method when you need to tell the user that something is happening on the bot's side. 
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
     * Watch more in https://core.telegram.org/bots/api#sendchataction
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param action Type of action to broadcast. 
     *          Choose one, depending on what the user is about to receive: typing for text messages, upload_photo for photos, 
     *          record_video or upload_video for videos, record_audio or upload_audio for audio files, upload_document for general files, 
     *          find_location for location data.
     * @return Boolean
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean sendChatAction(Integer chat_id, String action) throws TelegramException;
    
    /**
     * Types of ChatAction. Idea by Rainu
     */
    public static enum ChatAction {
        typing, upload_photo, record_video, upload_video, record_audio,
        upload_audio, upload_document, find_location;
    }
    
    /**
     * Use this method when you need to tell the user that something is happening on the bot's side. 
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
     * Watch more in https://core.telegram.org/bots/api#sendchataction
     * @param chat_id Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param action Type of action to broadcast. 
     *          Choose one, depending on what the user is about to receive: typing for text messages, upload_photo for photos, 
     *          record_video or upload_video for videos, record_audio or upload_audio for audio files, upload_document for general files, 
     *          find_location for location data.
     * @return Boolean
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean sendChatAction(Integer chat_id, ChatAction action) throws TelegramException;
    
    /**
     * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
     *
     * @param user_id Unique identifier of the target user
     * @return {@link UserProfilePhotos}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public UserProfilePhotos getUserProfilePhotos(Integer user_id) throws TelegramException;

    /**
     * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
     *
     * @param user_id Unique identifier of the target user
     * @param offset Sequential number of the first photo to be returned. By default, all photos are returned.
     * @param limit Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     * @return {@link UserProfilePhotos}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public UserProfilePhotos getUserProfilePhotos(Integer user_id, Integer offset, Integer limit) throws TelegramException;
    
    /**
     * Use this method to get basic info about a file and prepare it for downloading.
     * For the moment, bots can download files of up to 20MB in size. On success, a File object is returned.
     * The file can then be downloaded via the link https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;,
     * where &lt;file_path&gt; is taken from the response. It is guaranteed that the link will be valid for at least 1 hour.
     * When the link expires, a new one can be requested by calling getFile again.
     *
     * @param file_id
     * @return
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public File getFile(String file_id) throws TelegramException;
    
    /**
     * Use this method to kick a user from a group or a supergroup. In the case of supergroups, 
     *      the user will not be able to return to the group on their own using invite links, etc., unless unbanned first. 
     * The bot must be an administrator in the group for this to work. Returns True on success.
     * @param chat_id Unique identifier for the target group or username of the target supergroup (in the format @supergroupusername)
     * @param user_id Unique identifier of the target user
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean kickChatMember(Integer chat_id, Integer user_id) throws TelegramException;
    
    /**
     * se this method to unban a previously kicked user in a supergroup. 
     * The user will not return to the group automatically, but will be able to join via link, etc. 
     * The bot must be an administrator in the group for this to work. 
     * Returns True on success.
     * 
     * @param chat_id Unique identifier for the target group or username of the target supergroup (in the format @supergroupusername)
     * @param user_id Unique identifier of the target user
     * @return
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean unbanChatMember(Integer chat_id, Integer user_id) throws TelegramException;
    
    /**
     * Use this method to send answers to callback queries sent from inline keyboards. 
     * The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. 
     * On success, True is returned.
     * 
     * @param callback_query_id Unique identifier for the query to be answered
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean answerCallbackQuery(String callback_query_id) throws TelegramException;
    
    /**
     * Use this method to send answers to callback queries sent from inline keyboards. 
     * The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. 
     * On success, True is returned.
     * 
     * @param callback_query_id Unique identifier for the query to be answered
     * @param text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
     * @param show_alert If true, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to false.
     * @return 
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean answerCallbackQuery(String callback_query_id, String text, Boolean show_alert) throws TelegramException;
    
    /**
     * Use this method to receive incoming updates using long polling (wiki). An Array of {@link Update} objects is returned.
     * @param offset Identifier of the first update to be returned. 
     *              Must be greater by one than the highest among the identifiers of previously received updates. 
     *              By default, updates starting with the earliest unconfirmed update are returned.
     *              An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id.
     * Watch more in https://core.telegram.org/bots/api#getupdates
     * @param limit Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100
     * @param timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling
     * @return
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout) throws TelegramException;
    
    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an
     * update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized Update.
     * In case of an unsuccessful request, we will give up after a reasonable amount of attempts.
     * 
     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL,
     * e.g. https://www.example.com/&lt;token&gt;. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
     * 
     * <b>Notes</b>
     * <ul>
     * <li>You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.ǘ
     * <li>We currently do not support self-signed certificates.</li>
     * <li>Ports currently supported for Webhooks: 443, 80, 88, 8443.</li>
     * </ul>
     *
     * @param url         HTTPS url to send updates to. Use an empty string to remove webhook integration
     * @param certificate Upload your public key certificate so that the root certificate in use can be checked.
     *                    See our <a href="https://core.telegram.org/bots/self-signed">self-signed guide</a> for details.
     * @return
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean setWebhook(String url, File certificate) throws TelegramException;
    
    /**
     * Use this method to send answers to an inline query. On success, True is returned.
     * No more than <b>50</b> results per query are allowed.
     *
     * @param inlineQueryId Unique identifier for the answered query
     * @param results       A JSON-serialized array of results for the inline query
     * @return
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean answerInlineQuery(String inlineQueryId, List<InlineQueryResult> results) throws TelegramException;

    /**
     * Use this method to send answers to an inline query. On success, True is returned.
     * No more than <b>50</b> results per query are allowed.
     *
     * @param inlineQueryId Unique identifier for the answered query
     * @param results       A JSON-serialized array of results for the inline query
     * @param cacheTime     The maximum amount of time in seconds that the result of the inline query may be cached on
     *                      the server. Defaults to 300.
     * @param isPersonal    Pass <i>True</i>, if results may be cached on the server side only for the user that sent
     *                      the query. By default, results may be returned to any user who sends the same query
     * @param nextOffset    Pass the offset that a client should send in the next query with the same text to receive
     *                      more results. Pass an empty string if there are no more results or if you don‘t support
     *                      pagination. Offset length can’t exceed 64 bytes.
     * @return
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Boolean answerInlineQuery(String inlineQueryId, List<InlineQueryResult> results, Integer cacheTime, Boolean isPersonal, String nextOffset) throws TelegramException;
}
