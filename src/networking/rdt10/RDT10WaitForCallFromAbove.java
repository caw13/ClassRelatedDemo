package networking.rdt10;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * Waits to receive data passed from application layer to forward on to the
 * receiver
 *
 * @author Chad Williams
 */
public class RDT10WaitForCallFromAbove implements RDT10SenderState {

   private final RDT10Sender sender;

   public RDT10WaitForCallFromAbove(RDT10Sender sender) {
      this.sender = sender;
   }

   /**
    * Receive data from upper layer of stack
    *
    * @param data
    */
   @Override
   public void rdtSend(byte[] data) throws SocketException, IOException {
      // For simplicity using a stream to read off packet size chunks
      ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
      while (byteStream.available() > 0) {
         byte[] packetData = new byte[sender.PACKET_SIZE];
         int bytesRead = byteStream.read(packetData);
         if (bytesRead < packetData.length) {
            packetData = Arrays.copyOf(packetData, bytesRead);
         }
         System.out.println("### Sender sending packet: '" + new String(packetData) + "'");
         DatagramPacket packet = new DatagramPacket(packetData, packetData.length, sender.getInternetAddress(), sender.getReceiverPortNumber());
         sender.getSocket().send(packet);
      }
      System.out.println("### Sender done sending");
   }
}
