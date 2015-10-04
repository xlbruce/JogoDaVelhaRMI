package com.br.velha.sessionbeans;

import com.br.velha.model.EstadoDoJogo;
import com.br.velha.model.Tabuleiro;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.ejb.Local;

/**
 *
 * @author bruce
 */
@Local
public interface JogoControllerSBLocal {

    EstadoDoJogo joga(int x, int y) throws RemoteException ;

    Tabuleiro getTabuleiro() throws RemoteException;

    EstadoDoJogo getEstado();

    void novoJogo();
    
}
