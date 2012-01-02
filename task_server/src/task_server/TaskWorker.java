package task_server;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * поток обработчик запросов на вычисления
 * @author vital
 */
public class TaskWorker extends Thread {

    @Override
    public void run() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setVirtualHost("/");
            
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("kama_task_list", true, false, false, null);

            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume("kama_task_list", true, consumer);

            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println(" [x] Received '" + message + "'");
            }
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
            Logger.getLogger(TaskWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
