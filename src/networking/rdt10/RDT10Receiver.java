package networking.rdt10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Implementation of Kurose and Ross RDT 1.0 receiver
 *
 * @author Chad Williams
 */
public class RDT10Receiver extends Thread {

    /**
     * Current state machine state of this receiver
     */
    private RDT10ReceiverState currentState = new RDT10WaitForCallFromBelow(this);

    private DatagramSocket socket = null;

    private final int port;

    final int PACKET_SIZE = 256;

    public RDT10Receiver(String name, int port) {
        super(name);
        this.port = port;
    }

    public void startReceiver() throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void shutdown() {
        if (socket != null) {
            socket.close();
        }
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    /**
     * Receive packet and act on it
     *
     * @param packet
     */
    public void rdtReceive(DatagramPacket packet) {
        currentState.rdtReceive(packet);
    }

    @Override
    public void run() {
        try {
            startReceiver();
            while (true) {
                byte[] buf = new byte[PACKET_SIZE];

                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                // figure out response
                rdtReceive(packet);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
           shutdown(); 
        }
        System.out.println("DONE");
    }
}
