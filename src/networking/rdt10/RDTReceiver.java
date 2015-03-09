package networking.rdt10;

/**
 * Implementation of Kurose and Ross RDT 1.0 receiver
 * @author Chad Williams
 */
public class RDTReceiver {
    
    /** Current state machine state of this receiver */
    private RDT10ReceiverState currentState = new RDT10WaitForCallFromBelow();
    
    public RDTReceiver() {
    }
    
    /**
     * Receive packet and act on it
     * @param packet 
     */
    public void rdtReceive(byte[] packet) {
        currentState.rdtReceive(packet);
    }
}
