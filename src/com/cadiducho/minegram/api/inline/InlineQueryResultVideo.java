/*
 * The MIT License
 *
 * Copyright 2016 Cadiducho.
 * Read more in https://github.com/Cadiducho/Minegram/blob/master/LICENSE
 */

package com.cadiducho.minegram.api.inline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a link to a video file stored on the Telegram servers.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the video.
 */
@ToString
@Getter @Setter
public class InlineQueryResultVideo extends InlineQueryResult {

    /**
     * A valid URL for the embedded video player or video file
     */
    private String video_url;

    /**
     * Mime type of the content of video url, “text/html” or “video/mp4”
     */
    private String mime_type;

    /**
     * Text of the message to be sent with the video, 1-512 characters
     */
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show
     * <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a> in your bot's message.
     */
    private String parse_mode;

    /**
     * Optional. Disables link previews for links in the sent message
     */
    private Boolean disable_web_page_preview;

    /**
     * Optional. Video width
     */
    private Integer video_width;

    /**
     * Optional. Video height
     */
    private Integer video_height;

    /**
     * Optional. Video duration in seconds
     */
    private Integer video_duration;

    /**
     * URL of the thumbnail (jpeg only) for the video
     */
    private String thumb_url;

    /**
     * Title for the result
     */
    private String title;

    /**
     * Optional. Short description of the result
     */
    private String description;

    public InlineQueryResultVideo() {
        super("video");
    }

    /**
     *
     * @param video_url A valid URL for the embedded video player or video file
     * @param mime_type Mime type of the content of video url, “text/html” or “video/mp4”
     * @param message_text Text of the message to be sent with the video, 1-512 characters
     * @param thumb_url URL of the thumbnail (jpeg only) for the video
     * @param title Title for the result
     */
    public InlineQueryResultVideo(String video_url, String mime_type, String message_text, String thumb_url, String title) {
        this();
        this.video_url = video_url;
        this.mime_type = mime_type;
        this.message_text = message_text;
        this.thumb_url = thumb_url;
        this.title = title;
    }

    /**
     *
     * @param video_url A valid URL for the embedded video player or video file
     * @param mime_type Mime type of the content of video url, “text/html” or “video/mp4”
     * @param message_text Text of the message to be sent with the video, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     * @param video_width Optional. Video width
     * @param video_height Optional. Video height
     * @param video_duration Optional. Video duration in seconds
     * @param thumb_url URL of the thumbnail (jpeg only) for the video
     * @param title Title for the result
     * @param description Optional. Short description of the result
     */
    public InlineQueryResultVideo(String video_url, String mime_type, String message_text, String parse_mode,
                                  Boolean disable_web_page_preview, Integer video_width, Integer video_height,
                                  Integer video_duration, String thumb_url, String title, String description) {
        this();
        this.video_url = video_url;
        this.mime_type = mime_type;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
        this.video_width = video_width;
        this.video_height = video_height;
        this.video_duration = video_duration;
        this.thumb_url = thumb_url;
        this.title = title;
        this.description = description;
    }
    
}
