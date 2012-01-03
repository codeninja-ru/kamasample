package controllers;

import com.sun.jmx.snmp.tasks.TaskServer;
import play.*;
import play.mvc.*;

import java.util.*;

import javax.inject.Inject;
import models.*;
import org.eclipse.jdt.core.dom.ThisExpression;
import services.TaskService;

public class Application extends Controller {

    @Inject
    protected static TaskService taskService;
    /** The service. */
    private static play.modules.rabbitmq.stats.StatsService service = play.modules.rabbitmq.RabbitMQPlugin.statsService();

    /**
     * show task list
     */
    public static void index() {

        List<Task> tasks = taskService.getTasks();
        
        String queueName = "kama_task_list";
        String resultQueueName = "kama_task_result";

        long producerSuccess = service.executions(queueName, play.modules.rabbitmq.stats.StatsEvent.Type.PRODUCER, play.modules.rabbitmq.stats.StatsEvent.Status.SUCCESS);
        long producerFailed = service.executions(queueName, play.modules.rabbitmq.stats.StatsEvent.Type.PRODUCER, play.modules.rabbitmq.stats.StatsEvent.Status.ERROR);
        long consumerSuccess = service.executions(resultQueueName, play.modules.rabbitmq.stats.StatsEvent.Type.CONSUMER, play.modules.rabbitmq.stats.StatsEvent.Status.SUCCESS);
        long consumerFailed = service.executions(resultQueueName, play.modules.rabbitmq.stats.StatsEvent.Type.CONSUMER, play.modules.rabbitmq.stats.StatsEvent.Status.ERROR);
        long producerSuccessAverageTime = service.averageTime(queueName, play.modules.rabbitmq.stats.StatsEvent.Type.PRODUCER, play.modules.rabbitmq.stats.StatsEvent.Status.SUCCESS);
        long producerFailedAverageTime = service.averageTime(queueName, play.modules.rabbitmq.stats.StatsEvent.Type.PRODUCER, play.modules.rabbitmq.stats.StatsEvent.Status.ERROR);
        long consumerSuccessAverageTime = service.averageTime(resultQueueName, play.modules.rabbitmq.stats.StatsEvent.Type.CONSUMER, play.modules.rabbitmq.stats.StatsEvent.Status.SUCCESS);
        long consumerFailedAverageTime = service.averageTime(resultQueueName, play.modules.rabbitmq.stats.StatsEvent.Type.CONSUMER, play.modules.rabbitmq.stats.StatsEvent.Status.ERROR);

        render(tasks, queueName, producerSuccess, producerFailed, consumerSuccess, consumerFailed, producerSuccessAverageTime, producerFailedAverageTime, consumerSuccessAverageTime, consumerFailedAverageTime);


        //render(tasks);
    }

    public static void add_task(int val1, int val2) {
        validation.required(val1);
        validation.required(val2);

        if (validation.hasErrors()) {
            render("Application/index.html");
        } else {

            Task task = new Task(val1, val2);
            taskService.runTask(task);

            index();
        }


    }
}