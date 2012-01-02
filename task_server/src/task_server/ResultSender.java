package task_server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.TaskResult;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * отправляет результат вобратку
 * @author vital
 */
public class ResultSender {

    
    public void send(TaskResult result) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare("kama_task_result", false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", "kama_task_result", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            channel.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(ResultSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
