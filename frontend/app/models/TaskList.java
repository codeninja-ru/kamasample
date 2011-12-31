package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Список всех задач переданных на выполнение
 * 
 * в реальной жижни тут должна быть база данных,
 * но мне было влом заморачиваться
 * 
 * @author vital
 */
public class TaskList {
    
    /**
     * список наших задач
     */
    protected List<Task> taskList;

    private TaskList() {
        this.taskList = new ArrayList<Task>();
    }
    
    //public static TaskList

    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Добавляет задау в хранилище
     * @param task задача
     * @return идентификатор задачи
     */
    public int addTask(Task task) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * присваем задаче результат
     * @param taskId идетификатор задачи
     * @param result результат
     */
    public void setResult(int taskId, TaskResult result) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 
     * @param TaskId
     * @return 
     */
    public Task getTask(int TaskId) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * количество задач
     * @return 
     */
    public int getCount() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * количество задач без TaskResult
     * @return 
     */
    public int getCountUncalculatedTasks() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * количество посчитанных задач
     * @return 
     */
    public int getCountCalculatedTasks() {
        throw new UnsupportedOperationException();
    }
    
    
}
