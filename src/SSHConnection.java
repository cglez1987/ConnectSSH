/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CARLOGON
 */
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SSHConnection {

    SSHConnector sshConnector = new SSHConnector();

    public String executeSSH(String host, String username, String password, String command) {
        String result = "Error";
        try {
            sshConnector.connect(username, password, host, 22);
            result = sshConnector.executeCommand(command);
            sshConnector.disconnect();
        } catch (JSchException ex) {
            Logger.getLogger(SSHConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SSHConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SSHConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
