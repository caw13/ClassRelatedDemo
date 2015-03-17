package networking.rdt10;

/**
 * Simple demonstration of RDT 1.0
 *
 * @author Chad Williams
 */
public class Main {

    public static void main(String[] args) {
        try {
            String data = "Dear Mr. Vernon, we accept the fact that we had to sacrifice a whole Saturday in detention for whatever it was we did wrong. But we think you're crazy to make an essay telling you who we think we are. You see us as you want to see us - in the simplest terms, in the most convenient definitions. But what we found out is that each one of us is a brain...and an athlete...and a basket case...a princess...and a criminal.  Does that answer your question? Sincerely yours, the Breakfast Club.";

            // Start receiver
            RDT10Receiver receiverThread = new RDT10Receiver("Receiver", 49000);
            receiverThread.start();

            // Create sender
            byte[] targetAdddress = {127, 0, 0, 1};
            RDT10Sender sender = new RDT10Sender();
            sender.startSender(targetAdddress, 49000);

            // Send the data
            sender.rdtSend(data.getBytes());
            
            receiverThread.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
