package models;

/**
 * Результат вычисления задачи
 * @author vital
 */
public class TaskResult {
    
    /**
     * собственно результат
     */
    protected Integer value;

    public TaskResult(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
}
