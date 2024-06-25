package com.univ.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 生理周期由web容器管理，但又要存储会话，因此sessionList必须定义成static的
 * @author univ
 * date 2024/6/25
 */
@ServerEndpoint("/websocket/{param}")
public class UnivWebSocketServer {

    public final static List<Session> sessionList = new ArrayList<Session>();
    @OnOpen
    public void onOpen(Session session, @PathParam("param") String param) {
        sessionList.add(session);
        System.out.println("onOpen this: " + this);
        System.out.println("onOpen session: " + session);
        System.out.println("请求入参: " + param);
        System.out.println("收到websocket连接了，sessionId: " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose this: " + this);
        System.out.println("onClose session: " + session);
        System.out.println("websocket关闭了，sessionId: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("onError this: " + this);
        System.out.println("onError session: " + session);
        System.out.println("websocket关闭了，sessionId: " + session.getId());
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        System.out.println("onMessage this: " + this);
        System.out.println("onMessage session: " + session);
        System.out.println("websocket收到消息了，sessionId: " + session.getId() + " msg: " + msg);
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMsg(final String msg) {
        for (Session session : sessionList) {
            try {
                if (session.isOpen()) {
                    session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
