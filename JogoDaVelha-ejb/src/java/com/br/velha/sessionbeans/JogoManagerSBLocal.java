/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.velha.sessionbeans;

import com.br.velha.model.EstadoDoJogo;
import com.br.velha.model.Tabuleiro;
import com.br.velha.service.JogoControllerLocal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.ejb.Local;

/**
 *
 * @author bruce
 */
@Local
public interface JogoManagerSBLocal {
    
    public EstadoDoJogo joga(int x, int y);

    public Tabuleiro getTabuleiro();

    public void novoJogo();
}
