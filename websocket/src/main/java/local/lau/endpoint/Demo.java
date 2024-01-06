package local.lau.endpoint;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import local.lau.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;

@Component
@ServerEndpoint("/ws/{id}")
// 运行时的 WebSocket 连接对象，也就是端点实例，是由服务器创建，而不是 Spring，所以不能使用自动装配
// 可以使用 Spring 的 ApplicationContextAware 接口，在应用启动时获取到 ApplicationContext 并且保存在全局静态变量中
public class Demo implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);
    private Session session;

    private UserService userService;

    private static ApplicationContext applicationContext;

    // 收到消息
    @OnMessage
    public void onMessage(String message) throws IOException {

        LOGGER.info("[websocket] 收到消息：id={}，message={}", this.session.getId(), message);

        userService.doWork();
        if (message.equalsIgnoreCase("bye")) {
            // 由服务器主动关闭连接。状态码为 NORMAL_CLOSURE（正常关闭）。
            this.session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Bye"));
            return;
        }


        this.session.getAsyncRemote().sendText("[" + Instant.now().toEpochMilli() + "] Hello " + message);
    }

    // 连接打开
    @OnOpen
    public void onOpen(Session session, @PathParam("id") Long id, EndpointConfig endpointConfig) {
        UserService userService = Demo.applicationContext.getBean(UserService.class);
        this.userService = userService;
        // 保存 session 到对象
        this.session = session;
        System.out.println("uid=" + id);
        LOGGER.info("[websocket] 新的连接：id={}", this.session.getId());
    }

    // 连接关闭
    @OnClose
    public void onClose(CloseReason closeReason) {
        LOGGER.info("[websocket] 连接断开：id={}，reason={}", this.session.getId(), closeReason);
    }

    // 连接异常
    @OnError
    public void onError(Throwable throwable) throws IOException {

        LOGGER.info("[websocket] 连接异常：id={}，throwable={}", this.session.getId(), throwable.getMessage());

        // 关闭连接。状态码为 UNEXPECTED_CONDITION（意料之外的异常）
        this.session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, throwable.getMessage()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Demo.applicationContext = applicationContext;
    }
}