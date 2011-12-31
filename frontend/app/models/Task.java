package models;

/**
 * Класс сферической задачи в вакууме
 * 
 * Хранит в себе исходные данные (2 числа)
 * и результат если такой есть
 * 
 * @author vital
 */
public class Task {
    
    /**
     * первое число
     */
    protected Integer val1;
    /**
     * второе число
     */
    protected Integer val2;
    
    /**
     * рузультат вычисления
     */
    protected TaskResult result;

    public Task(Integer val1, Integer val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public TaskResult getResult() {
        return result;
    }

    public void setResult(TaskResult result) {
        this.result = result;
    }

    public Integer getVal1() {
        return val1;
    }

    public void setVal1(Integer val1) {
        this.val1 = val1;
    }

    public Integer getVal2() {
        return val2;
    }

    public void setVal2(Integer val2) {
        this.val2 = val2;
    }
    
    /**
     * проверяет имеет ли данная задач результат
     * @return 
     */
    public boolean hasResult() {
        return this.getResult() != null;
    }    
    
}
