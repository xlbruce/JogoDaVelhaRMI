package test;

import com.br.velha.service.JogoControllerLocal;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruce
 */
public class Test {
    
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 1099;
        try {
            Registry registry = LocateRegistry.getRegistry(HOST, PORT);
            JogoControllerLocal lookup = (JogoControllerLocal) registry.lookup("JogoService");
            System.out.println(lookup.getTabuleiro().getPos(1, 1));
        } catch (RemoteException ex) {
            System.err.println("Erro ao registrar o serviço");
            System.err.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.err.println("NotBoundException");
            System.err.println(ex.getMessage());
        }
    }
    
}
