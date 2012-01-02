package task_server;

/**
 *
 * @author vital
 */
public class TaskServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
        Thread worker1 = new TaskWorker();
        Thread worker2 = new TaskWorker();
        
        worker1.start();
        worker2.start();
    }
}
