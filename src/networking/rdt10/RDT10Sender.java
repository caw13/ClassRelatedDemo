package networking.rdt10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Implementation of Kurose and Ross RDT 1.0 sender
 *
 * @author Chad Williams
 */
public class RDT10Sender extends Thread {

    /**
     * Current state machine state of this sender
     */
    private RDT10SenderState currentState = new RDT10WaitForCallFromAbove(this);

    private int receiverPortNumber = 0;
    private DatagramSocket socket = null;
    private InetAddress internetAddress = null;
    final int PACKET_SIZE = 256;

    public RDT10Sender() {

    }

    void setCurrentState(RDT10SenderState newState) {
        this.currentState = newState;
    }

    DatagramSocket getSocket() {
        return socket;
    }

    int getReceiverPortNumber() {
        return receiverPortNumber;
    }

    InetAddress getInternetAddress() {
        return internetAddress;
    }

    public void startSender(byte[] targetAddress, int receiverPortNumber) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        internetAddress = InetAddress.getByAddress(targetAddress);
        this.receiverPortNumber = receiverPortNumber;
    }

    public void shutdown() {
        if (socket != null) {
            socket.close();
        }
    }

    /**
     * Receive data and pass it to the current state
     *
     * @param data
     */
    public void rdtSend(byte[] data) throws SocketException, IOException {
        currentState.rdtSend(data);
    }
}
