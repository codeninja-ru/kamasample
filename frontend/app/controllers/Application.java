package controllers;

import com.sun.jmx.snmp.tasks.TaskServer;
import play.*;
import play.mvc.*;

import java.util.*;

import javax.inject.Inject;
import models.*;
import org.eclipse.jdt.core.dom.ThisExpression;
import services.TaskService;

public class Application extends Controller {
    
    @Inject
    protected static TaskService taskService;

    /**
     * show task list
     */
    public static void index() {
        
        List<Task> tasks = taskService.getTasks();
        render(tasks);
    }
    
    public static void add_task(int val1, int val2) {
        validation.required(val1);
        validation.required(val2);
        
        if (validation.hasErrors()) {
            render("Application/index.html");
        } else {
            
            Task task = new Task(val1, val2);
            taskService.runTask(task);
            
            index();
        }
        
        
    }

}