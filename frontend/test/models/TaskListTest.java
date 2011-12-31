/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

/**
 *
 * @author vital
 */
public class TaskListTest extends UnitTest {
    
    @Test
    /**
     * тестируем чтение запись
     */
    public void testReadWrite() {
        TaskList taskList = new TaskList();
        
        Task task1 = new Task(1, 1);
        Task task2 = new Task(1, 2);
        Task task3 = new Task(1, 3);
        Task task4 = new Task(1, 4);

        
        int result = taskList.addTask(task1);
        assertEquals(result, 1);
        result = taskList.addTask(task2);
        assertEquals(result, 2);
        result = taskList.addTask(task3);
        assertEquals(result, 3);
        result = taskList.addTask(task4);
        assertEquals(result, 4);
        
        assertEquals(taskList.getTask(1), task1);
        assertEquals(taskList.getTask(2), task2);
        assertEquals(taskList.getTask(3), task3);
        assertEquals(taskList.getTask(4), task4);
        
    }
    
    @Test
    public void testSetResult() {
        TaskList taskList = new TaskList();
        
        TaskResult taskResult = new TaskResult(3);
        
        taskList.addTask(new Task(1, 2));
        taskList.addTask(new Task(1, 2));
        taskList.addTask(new Task(1, 2));
        
        taskList.setResult(2, taskResult);
        TaskResult r = taskList.getTask(2).getResult();
        assertEquals(r, taskResult);
        assertEquals(r.getValue(), 3);
    }
    
    @Test
    public void testCount() {
        TaskList taskList = new TaskList();
        
        assertEquals(taskList.getCount(), 0);
        
        taskList.addTask(new Task(1, 2));
        assertEquals(taskList.getCount(), 1);
        taskList.addTask(new Task(1, 2));
        taskList.addTask(new Task(1, 2));
        assertEquals(taskList.getCount(), 3);
        
        assertEquals(taskList.getCountCalculatedTasks(), 0);
        assertEquals(taskList.getCountUncalculatedTasks(), 3);
        
        taskList.setResult(2, new TaskResult(3));
        
        assertEquals(taskList.getCountCalculatedTasks(), 1);
        assertEquals(taskList.getCountUncalculatedTasks(), 2);
        
        taskList.setResult(1, new TaskResult(3));
        
        assertEquals(taskList.getCountCalculatedTasks(), 2);
        assertEquals(taskList.getCountUncalculatedTasks(), 1);

    }    
    

}
