package com.br.velha.service;

import com.br.velha.model.EstadoDoJogo;
import com.br.velha.model.Tabuleiro;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author bruce
 */
public interface JogoControllerLocal extends Remote {

    EstadoDoJogo joga(int x, int y) throws RemoteException ;

    Tabuleiro getTabuleiro() throws RemoteException;

    void novoJogo() throws RemoteException;
    
}
