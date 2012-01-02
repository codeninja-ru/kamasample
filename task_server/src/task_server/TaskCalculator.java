package task_server;

import models.Task;
import models.TaskResult;

/**
 * обработчик заданий
 * @author vital
 */
public class TaskCalculator {
    
    /**
     * полчаем резуьтат таска
     * @param task
     * @return 
     */
    public TaskResult run(Task task) {
        
        return new TaskResult(task.getVal1() + task.getVal2());
    }
    
    
}
