package task_server;

import com.google.gson.Gson;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Task;
import models.TaskResult;

/**
 * поток обработчик запросов на вычисления
 * @author vital
 */
public class TaskWorker extends Thread {
    
    protected ResultSender sender;

    public TaskWorker() {
        this.sender = new ResultSender();
    }
    
    

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
                
                Task task = this.decodeMsg(message);
                // вычисляем
                TaskCalculator calc = new TaskCalculator();
                TaskResult result = calc.run(task);
                // типа думаем
                Thread.sleep(5000);
                System.out.println(" [x] Calc " + task.getVal1() +" + " + task.getVal2() + " = " + result.getValue());
                
                // отпарвялем результат
                result.setTaskId(task.getTaskId());
                this.sender.send(result);
            }
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
            Logger.getLogger(TaskWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * декодируем json
     * @param msg
     * @return 
     */
    protected Task decodeMsg(String msg) {
        Gson gson = new Gson();
        return gson.fromJson(msg, Task.class);
    }
}
