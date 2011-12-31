package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Список всех задач переданных на выполнение
 * 
 * в реальной жижни тут должна быть база данных,
 * но мне было влом заморачиваться
 * 
 * Singletone
 * 
 * @author vital
 */
public class TaskList {
    
    /**
     * список наших задач
     */
    protected List<Task> taskList;
    
    private static TaskList instance;
    
    public static TaskList getInstance() {
        if (instance == null) {
            instance = new TaskList();
        }
        
        return instance;
    }

    public TaskList() {
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
        this.taskList.add(task);
        return this.taskList.size() - 1;
    }
    
    /**
     * присваем задаче результат
     * @param taskId идетификатор задачи
     * @param result результат
     */
    public void setResult(int taskId, TaskResult result) {
        Task task = this.taskList.get(taskId);
        task.setResult(result);
    }
    
    /**
     * 
     * @param taskId
     * @return 
     */
    public Task getTask(int taskId) {
        return this.taskList.get(taskId);
    }
    
    /**
     * количество задач
     * @return 
     */
    public int getCount() {
        return this.taskList.size();
    }
    
    /**
     * количество задач без TaskResult
     * @return 
     */
    public int getCountUncalculatedTasks() {
        
        int count = 0;
        
        for (Task task : this.getTaskList()) {
            if (task.getResult() == null) count++;
        }
        
        return count;
    }
    
    /**
     * количество посчитанных задач
     * @return 
     */
    public int getCountCalculatedTasks() {
        int count = 0;
        
        for (Task task : this.getTaskList()) {
            if (task.getResult() instanceof TaskResult) count++;
        }
        
        return count;
    }
    
    
}
