package networking.rdt10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * Waits to receive data passed from internet layer to forward on to the
 * application layer
 *
 * @author Chad Williams
 */
public class RDT10WaitForCallFromBelow implements RDT10ReceiverState {

    private final RDT10Receiver receiver;

    public RDT10WaitForCallFromBelow(RDT10Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Receive a packet from lower layer of stack
     *
     * @param packet
     */
    @Override
    public void rdtReceive(DatagramPacket packet) {
        byte[] packetData = Arrays.copyOf(packet.getData(), packet.getLength());
        System.out.println("@@@ Receiver delivered packet with: '" + new String(packetData) + "'");
    }

}
