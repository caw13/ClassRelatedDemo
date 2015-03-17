package threads.demo;

/**
 * Simple demo of creating a thread group and waiting for it to finish before
 * starting new threads
 *
 * @author Chad Williams
 */
public class Main {

   public void generateThreads() {
      try {
         for (int spawnRound = 0; spawnRound < 100; spawnRound++) {
            System.out.println("Starting spawn round " + spawnRound);
            ThreadGroup spawnRoundThreads = new ThreadGroup("SpawnRoundThreads" + spawnRound);
            spawnRoundThreads.setDaemon(true);
            for (int threadIndex = 0; threadIndex < 1000; threadIndex++) {
               SleepingThread countingThread = new SleepingThread(spawnRoundThreads, "SR" + spawnRound + "T" + threadIndex);
               countingThread.start();
            }
            while (spawnRoundThreads.activeCount() > 0) {
               System.out.println("Waiting on: " + spawnRoundThreads.activeCount() + " threads");
               Thread.currentThread().sleep(250);
            }
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      Main main = new Main();
      main.generateThreads();
   }
}
