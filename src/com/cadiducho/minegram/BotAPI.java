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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendMessage(Integer chat_id, String text, String parse_mode, Boolean disable_web_page_preview, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendPhoto(Integer chat_id, Object photo, String caption, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendAudio(Integer chat_id, Object audio, Integer duration, String performer, String title, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendDocument(Integer chat_id, Object document, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    
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
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendSticker(Integer chat_id, Object sticker, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
    
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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVideo(Integer chat_id, Object video, Integer duration, String performer, String title, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendVoice(Integer chat_id, Object voice, Integer duration, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
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
     * @param reply_to_message_id If the message is a reply, ID of the original message
     * @param reply_markup Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user. 
     *                  It can be {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardHide} or {@link ForceReply}.
     * @return {@link Message}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public Message sendLocation(Integer chat_id, Float latitude, Float longitude, Integer reply_to_message_id, Object reply_markup) throws TelegramException;
    
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
     * The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. 
     * It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile again.
     * @param file_id File identifier to get info about
     * @return {@link File}
     * @throws com.cadiducho.minegram.api.exception.TelegramException
     */
    public File getFile(String file_id) throws TelegramException;
    
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
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. 
     * Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized Update. 
     * In case of an unsuccessful request, we will give up after a reasonable amount of attempts.

     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g. https://www.example.com/<token>. 
     * Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
     * Watch more in https://core.telegram.org/bots/api#setwebhook
     * @param url HTTPS url to send updates to. Use an empty string to remove webhook integration
     * @param certificate Upload your public key certificate so that the root certificate in use can be checked
     * @return
     * @throws TelegramException 
     */
    public Boolean setWebhook(String url, File certificate) throws TelegramException;
}
