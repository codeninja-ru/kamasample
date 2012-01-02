package services;

import java.util.List;
import javax.inject.Inject;
import models.Task;
import models.TaskList;
import models.TaskMessage;
import models.TaskResult;
import play.modules.rabbitmq.producer.RabbitMQFirehose;
import play.modules.rabbitmq.producer.RabbitMQPublisher;

/**
 * работа с задачами
 * @author vital
 */
public class TaskService {

    protected TaskList taskList;
    
    /**
     * отправляет задачу на выполнение
     * @param task 
     */
    public void runTask(Task task) {
        int taskId = this.taskList.addTask(task);
        RabbitMQPublisher.publish("kama_task_list", new TaskMessage(task, taskId));
    }
    
    /**
     * записываем результат выполнения задачи
     * @param taskId
     * @param result 
     */
    public void setResult(int taskId, TaskResult result) {
        this.taskList.setResult(taskId, result);
    }
    
    /**
     * количество задач в очереди
     * @return 
     */
    public int getCountInQueue() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * количество выполняющихся операций
     * @return 
     */
    public int getRunningCount() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * количество выполненных заданий
     * @return 
     */
    public int getCompletedCount() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * количество зафейлиных задач
     * @return 
     */
    public int getFailedCount() {
        throw new UnsupportedOperationException();
    }
    
    public List<Task> getTasks() {
        return this.taskList.getTaskList();
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
 
    
    
    
}
