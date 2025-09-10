package com.xu.xupicturebackend.manager.websocket.disruptor;

import com.xu.xupicturebackend.manager.websocket.model.PictureEditRequestMessage;
import com.xu.xupicturebackend.model.entity.User;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-10
 * 图片编辑事件
 */
@Data
public class PictureEditEvent {

    /**
     * 消息
     */
    private PictureEditRequestMessage pictureEditRequestMessage;

    /**
     * 当前用户的 session
     */
    private WebSocketSession session;

    /**
     * 当前用户
     */
    private User user;

    /**
     * 图片 id
     */
    private Long pictureId;

}