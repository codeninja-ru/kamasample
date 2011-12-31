package models;

/**
 * Результат вычисления задачи
 * @author vital
 */
public class TaskResult {
    
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
