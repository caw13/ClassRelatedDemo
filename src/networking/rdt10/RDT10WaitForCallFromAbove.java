package networking.rdt10;

/**
 * Waits to receive data passed from application layer to forward on to the receiver
 * @author Chad Williams
 */
public class RDT10WaitForCallFromAbove implements RDT10SenderState {

    /**
     * Receive data from upper layer of stack
     * @param data 
     */
    @Override
    public void rdtSend(byte[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
