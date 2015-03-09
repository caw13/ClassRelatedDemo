package networking.rdt10;

/**
 * Possible state machine state of an RDT 1.0 receiver
 * @author Chad Williams
 */
public interface RDT10ReceiverState {

    /**
     * Action that should be done on receipt of a packet
     * @param packet 
     */
    public void rdtReceive(byte[] packet);
}
