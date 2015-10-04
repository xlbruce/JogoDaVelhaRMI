package com.br.velha.sessionbeans;

import com.br.velha.model.EstadoDoJogo;
import com.br.velha.model.Tabuleiro;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.ejb.Stateless;

/**
 *
 * @author bruce
 */
@Stateless
public class JogoControllerSB 
        implements JogoControllerSBLocal {

    private Tabuleiro tabuleiro;

    public JogoControllerSB() throws RemoteException {
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
    public EstadoDoJogo getEstado() {
        return tabuleiro.getEstado();
    }

    @Override
    public void novoJogo() {
        tabuleiro = new Tabuleiro();
    }

}
