package com.br.velha.model;

/**
 *
 * @author bruce
 */
public class Tabuleiro {

    private int[][] matriz;
    private static final int LIVRE = 0;
    private static final int HUMANO = 1;
    private static final int MAQUINA = 2;
    private int espacosDisponiveis;
    private EstadoDoJogo estado;

    public Tabuleiro() {
        matriz = new int[3][3];
        espacosDisponiveis = 9;
        estado = EstadoDoJogo.CONTINUA;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public static int getHUMANO() {
        return HUMANO;
    }

    public static int getMAQUINA() {
        return MAQUINA;
    }

    public int getEspacosDisponiveis() {
        return espacosDisponiveis;
    }

    public EstadoDoJogo getEstado() {  
        if (humanoVenceu()) {
            return EstadoDoJogo.HUMANO;
        }
        
        if (maquinaVenceu()) {
            return EstadoDoJogo.MAQUINA;
        }
        
        if (espacosDisponiveis == 0) {
            return EstadoDoJogo.EMPATE;
        }

        return EstadoDoJogo.CONTINUA;
    }
    
    public int getPos(int x, int y) {
        return matriz[x][y];
    }

    private boolean humanoVenceu() {
        //Verifica nas linhas
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == HUMANO) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
            count = 0;
        }

        //Verifica nas colunas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[j][i] == HUMANO) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
            count = 0;
        }

        //Verifica na coluna principal
        for (int i = 0; i < 3; i++) {
            if (matriz[i][i] == HUMANO) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        /*
         00 01 02
         10 11 12
         20 21 22
         */

        //Verifica na coluna secundária
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (matriz[i][Math.abs(-2 + i)] == HUMANO) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

    private boolean maquinaVenceu() {
        //Verifica nas linhas
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == MAQUINA) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
            count = 0;
        }

        //Verifica nas colunas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[j][i] == MAQUINA) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
            count = 0;
        }

        //Verifica na coluna principal
        for (int i = 0; i < 3; i++) {
            if (matriz[i][i] == MAQUINA) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        /*
         00 01 02
         10 11 12
         20 21 22
         */

        //Verifica na coluna secundária
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (matriz[i][Math.abs(-2 + i)] == MAQUINA) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

    public boolean jogaHumano(int x, int y) {
        x--;
        y--;
        if (matriz[x][y] == LIVRE) {
            matriz[x][y] = HUMANO;
            espacosDisponiveis--;
            return true;
        }
        return false;
    }

    public boolean jogaMaquina() {
        if (espacosDisponiveis > 0) {
            while (true) {
                int x = (int) (Math.random() * 3);
                int y = (int) (Math.random() * 3);
                if (matriz[x][y] == LIVRE) {
                    matriz[x][y] = MAQUINA;
                    espacosDisponiveis--;
                    return true;
                }
            }
        }
        return false;
    }

}
