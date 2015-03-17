package networking.rdt10;

import java.net.DatagramPacket;

/**
 * Possible state machine state of an RDT 1.0 receiver
 * @author Chad Williams
 */
public interface RDT10ReceiverState {

    /**
     * Action that should be done on receipt of a packet
     * @param packet 
     */
    public void rdtReceive(DatagramPacket packet);
}
