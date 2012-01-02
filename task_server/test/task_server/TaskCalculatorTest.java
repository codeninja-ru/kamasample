/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task_server;

import models.Task;
import models.TaskResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vital
 */
public class TaskCalculatorTest {

    /**
     * тестируем правильно ли складывает два числа :)
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TaskCalculator instance = new TaskCalculator();
        
        TaskResult result = instance.run(new Task(2, 2));
        assertEquals(4, result.getValue());
        
        result = instance.run(new Task(1, 3));
        assertEquals(4, result.getValue());
        
        result = instance.run(new Task(10, 11));
        assertEquals(21, result.getValue());

    }
}
