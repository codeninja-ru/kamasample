/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.inject.Inject;
import models.TaskResult;
import play.jobs.OnApplicationStart;
import play.modules.rabbitmq.consumer.RabbitMQConsumer;
import play.modules.spring.Spring;

/**
 *
 * @author vital
 */
@OnApplicationStart(async = true)
public class ResultConsumer extends RabbitMQConsumer<TaskResult> {
    
    //@Inject
    protected TaskService taskService;

    public ResultConsumer() {
        taskService = (TaskService) Spring.getBean("taskService");
    }
    
    

    @Override
    protected void consume(TaskResult result) {
        System.out.println("Message Consumed. taskId = " + result.getTaskId() + " result = " + result.getValue());
        taskService.setResult(result.getTaskId(), result);
    }

    @Override
    protected Class getMessageType() {
        return TaskResult.class;
    }

    @Override
    protected String queue() {
        return "kama_task_result";
    }

 
}
