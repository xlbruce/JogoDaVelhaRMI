package com.br.velha.server;

import com.br.velha.service.JogoController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author bruce
 */
public class Server {
    
    public static void main(String[] args) {
        final int PORT = Registry.REGISTRY_PORT;
        try {
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("JogoService", new JogoController());
            System.out.println("Serviço registrado na porta " + PORT );
        } catch (RemoteException ex) {
            System.err.println("Erro ao registrar o serviço");
        }
    }
    
}
