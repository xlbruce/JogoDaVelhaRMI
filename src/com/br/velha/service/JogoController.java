package com.br.velha.service;

import com.br.velha.model.EstadoDoJogo;
import com.br.velha.model.Tabuleiro;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author bruce
 */
public class JogoController extends UnicastRemoteObject
        implements JogoControllerLocal {

    private Tabuleiro tabuleiro;

    public JogoController() throws RemoteException {
        tabuleiro = new Tabuleiro();
    }

    @Override
    public EstadoDoJogo joga(int x, int y) throws RemoteException {
        EstadoDoJogo estado = tabuleiro.getEstado();
        if (tabuleiro.jogaHumano(x, y)) {
            estado = tabuleiro.getEstado();
            if (estado.equals(EstadoDoJogo.CONTINUA)) {
                tabuleiro.jogaMaquina();
                estado = tabuleiro.getEstado();
            }
        }
        return estado;
    }

    @Override
    public Tabuleiro getTabuleiro() throws RemoteException {
        return tabuleiro;
    }

    @Override
    public void novoJogo() throws RemoteException {
        tabuleiro = new Tabuleiro();
    }

}
