package networking.rdt10;

import java.io.IOException;
import java.net.SocketException;

/**
 * Possible state machine state of an RDT 1.0 sender
 *
 * @author Chad Williams
 */
public interface RDT10SenderState {

   /**
    * Action that should be done on receipt of application data
    *
    * @param data
    */
   public void rdtSend(byte[] data) throws SocketException, IOException;
}
