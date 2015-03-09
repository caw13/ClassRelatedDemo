package networking.rdt10;

/**
 * Implementation of Kurose and Ross RDT 1.0 sender
 *
 * @author Chad Williams
 */
public class RDT10Sender {

    /** Current state machine state of this sender */
    private RDT10SenderState currentState = new RDT10WaitForCallFromAbove();

    public RDT10Sender() {

    }

    /**
     * Receive data and pass it to the current state
     * @param data 
     */
    public void rdtSend(byte[] data) {
        currentState.rdtSend(data);
    }
}
