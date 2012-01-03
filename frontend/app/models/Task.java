package models;

import java.io.Serializable;

/**
 * Класс сферической задачи в вакууме
 * 
 * Хранит в себе исходные данные (2 числа)
 * и результат если такой есть
 * 
 * @author vital
 */
public class Task {
    
    protected int taskId;
    
    /**
     * первое число
     */
    protected int val1;
    /**
     * второе число
     */
    protected int val2;
    
    /**
     * рузультат вычисления
     */
    protected TaskResult result;

    public Task(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public TaskResult getResult() {
        return result;
    }

    public void setResult(TaskResult result) {
        this.result = result;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
    
    /**
     * проверяет имеет ли данная задач результат
     * @return 
     */
    public boolean hasResult() {
        return this.getResult() != null;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

  
    
    
}
