package com.br.velha.sessionbeans;

import com.br.velha.service.JogoControllerLocal;
import com.br.velha.model.EstadoDoJogo;
import com.br.velha.model.Tabuleiro;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.ejb.Stateless;

/**
 *
 * @author bruce
 */
@Stateless
public class JogoManagerSB implements JogoManagerSBLocal {
    
    private JogoControllerLocal jogo;
    
    public JogoManagerSB() {
        try {
            final int PORT = Registry.REGISTRY_PORT;
            final String HOST = "localhost";
            Registry registry = LocateRegistry.getRegistry(HOST, PORT);
            jogo = (JogoControllerLocal) registry.lookup("JogoService");
        } catch (RemoteException ex) {
            System.err.println("Remote exception");
            System.err.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.err.println("NotBoundException");
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public EstadoDoJogo joga(int x, int y) {
        try {
            return jogo.joga(x, y);
        } catch (RemoteException ex) {
            System.err.println("Erro ao jogar");
            return null;
        }
    }

    @Override
    public Tabuleiro getTabuleiro() {
        try {
            return jogo.getTabuleiro();
        } catch (RemoteException ex) {
            System.err.println("Erro ao retornar o tabuleiro");
            return null;
        }
    }

    @Override
    public void novoJogo() {
        try {
            jogo.novoJogo();
        } catch (RemoteException ex) {
            System.err.println("Erro ao iniciar um novo jogo");
        }
    }
    
}
