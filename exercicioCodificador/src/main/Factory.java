package com.exercicio;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static final List<Codificador> codificadores = new ArrayList<>();

    static {
        // Adicione todas as implementações de Codificador aqui
        codificadores.add(new CodificadorSimples());
        // Exemplo: codificadores.add(new CodificadorAvancado());
    }

    public static Codificador getCodificadorPorNivel(int nivelSeguranca) {
        Codificador maisProximo = null;
        int menorDiferenca = Integer.MAX_VALUE;

        for (Codificador codificador : codificadores) {
            int diferenca = Math.abs(codificador.getNivelSeguranca() - nivelSeguranca);
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                maisProximo = codificador;
            }
        }

                return maisProximo;
            }
        }