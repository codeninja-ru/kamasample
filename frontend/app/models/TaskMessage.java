package models;

import java.io.Serializable;

/**
 * сообщение для передачи на вычисление
 * @author vital
 */
public class TaskMessage implements Serializable {
    private Task task;
    
    /**
     * идентификатор задачи
     */
    protected int taskId;

    public TaskMessage(Task task, int taskId) {
        this.task = task;
        this.taskId = taskId;
    }

    public TaskMessage(int taskId, int val1, int val2) {
        this.task = new Task(val1, val2);
        this.taskId = taskId;
    }

    public void setVal2(int val2) {
        task.setVal2(val2);
    }

    public void setVal1(int val1) {
        task.setVal1(val1);
    }

    public int getVal2() {
        return task.getVal2();
    }

    public int getVal1() {
        return task.getVal1();
    }

    /*public Task getTask() {
        return task;
    }*/

    public void setTask(Task task) {
        this.task = task;
    }
    
    
    
    /*@Override
    public String toString() {
        return "Task [field1=" + task.getVal1() + ", field2=" + task.getVal2() + "]";
    }*/

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
    
}
