package threads.demo;

/**
 * Simple thread that sleeps a random amount of time
 * @author Chad Williams
 */
public class SleepingThread extends Thread{
    private final String threadName;
    
    public SleepingThread(ThreadGroup group, String threadName){
        super(group,threadName);
        this.threadName = threadName;
    }
    
    @Override
    public void run() {
        try{
        for (int i=0;i<10;i++){
            //System.out.println(threadName+": "+i);
            sleep((long)(Math.random()*1000));
        }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
