package com.exercicio;
import java.time.LocalDate;

public class CodificadorAutoKey implements Codificador {
    private final String chaveInicial ="Code";
    private String mapaEspacos ="";

    @Override
    public String getNome() {
        return "Codificador Autokey";
    }

    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 8, 14);
    }

    @Override
    public int getNivelSeguranca() {
        return 3;
    }

    @Override
    public String codifica(String texto) {
        StringBuilder letras = new StringBuilder();
        StringBuilder mapa = new StringBuilder();        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                letras.append(Character.toUpperCase(c));
                mapa.append("L");
            } else {
                mapa.append(c);
            }
        }
        this.mapaEspacos = mapa.toString();
        String base = chaveInicial.toUpperCase().replaceAll("[^A-Z]", "");
        String chave = base + letras;
        StringBuilder cifradas = new StringBuilder(letras.length());
        
        for (int i = 0; i < letras.length(); i++) {
            int p = letras.charAt(i) - 'A';
            int k = chave.charAt(i) - 'A';
            int c = (p + k) % 26;
            cifradas.append((char) (c + 'A'));
        }
        return cifradas.toString();
    }

    @Override
    public String decodifica(String texto) {
        String letras = texto.toUpperCase().replaceAll("[^A-Z]", "");
        String base = chaveInicial.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder chave = new StringBuilder(base);
        StringBuilder decifradas = new StringBuilder(letras.length());
        
        for (int i = 0; i < letras.length(); i++) {
            int c = letras.charAt(i) - 'A';
            int k = chave.charAt(i) - 'A';
            int p = (c - k + 26) % 26;
            char letra = (char) (p + 'A');
            decifradas.append(letra);
            chave.append(letra);
        }
        StringBuilder reconstruido = new StringBuilder();
        int idLetra = 0;
        
        for (int i = 0; i < mapaEspacos.length(); i++) {
            char m = mapaEspacos.charAt(i);
            if (m == 'L') {
                char letra = decifradas.charAt(idLetra++);
                if (reconstruido.length() == 0) {
                    reconstruido.append(letra);
                } else {
                    reconstruido.append(Character.toLowerCase(letra));
                }
            } else {
                reconstruido.append(m);
            }
        }
        return reconstruido.toString();
    }
}
