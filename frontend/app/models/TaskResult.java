package models;

import java.io.Serializable;

/**
 * Результат вычисления задачи
 * @author vital
 */
public class TaskResult implements Serializable {
    
    /**
     * собственно результат
     */
    protected int value;

    protected int taskId;

    public TaskResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
    
    
}
