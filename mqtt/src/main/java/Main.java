import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Main {
    public static void main(String[] args) throws MqttException, InterruptedException {
        String broker = "tcp://localhost:1883";
        String username = "u1001";
        String password = "123456";
        String clientid = "c00001";

        MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录,默认为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(true);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(6); // 默认30
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线,但这个方法并没有重连的机制
        options.setKeepAliveInterval(100); // 默认60
        options.setAutomaticReconnect(true);
        client.setCallback(new MqttCallbackExtended() {
            //连接成功回调，需要重新订阅主题
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
                System.out.println("----链接成功----");
                System.out.println(reconnect);
                System.out.println(serverURI);
                if (reconnect) {
                    // 重链接,要重新订阅主题
                    try {
                        client.subscribe("/v1/test/2");
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }

            // 连接丢失时被调用
            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("丢失链接: " + cause.getMessage());
            }

            // 接收到消息时被调用
            @Override
            public void messageArrived(String topic, MqttMessage message) {
                System.out.printf("接收topic: %s\tQos:%s\tMessage: %s\n", topic, message.getQos(), new String(message.getPayload()));
            }

            // 消息发送完成时被调用
            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("发送消息" + token.isComplete());
            }
        });

        client.connect(options);

        // 订阅主题
        client.subscribe("/v1/test/2");

        // 发送代码指令
        client.publish("/v1/test/3", "hello".getBytes(), 0, false);

        // // 关闭链接
        // client.disconnect();
        // // 关闭客户端
        // client.close();
    }


}
