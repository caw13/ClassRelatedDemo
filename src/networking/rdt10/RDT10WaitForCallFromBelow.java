package networking.rdt10;

/**
 * Waits to receive data passed from internet layer to forward on to the application layer
 * @author Chad Williams
 */
public class RDT10WaitForCallFromBelow implements RDT10ReceiverState {

    /**
     * Receive a packet from lower layer of stack
     * @param packet 
     */
    @Override
    public void rdtReceive(byte[] packet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
