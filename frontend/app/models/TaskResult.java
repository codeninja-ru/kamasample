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

    public TaskResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
