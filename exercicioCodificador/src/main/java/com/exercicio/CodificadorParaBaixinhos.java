package com.exercicio;
import java.time.LocalDate;
    
public class CodificadorParaBaixinhos implements Codificador{

  public String getNome() {
        return "Codificador Para Baixinhos";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 8, 16);
    }

    public int getNivelSeguranca(){
        return 666;
    }

    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();
        for (char c : str.toLowerCase().toCharArray()) {
            if (PALAVRAS.buscarPorLetra(c) != null) {
                encoded.append("|").append(PALAVRAS.buscarPorLetra(c).getPalavra());
            } else {
                encoded.append("| ").append(c);
            }
        }
        return encoded.toString();
    }

    public String decodifica(String str) {
        StringBuilder decoded = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '|') {
                if (buffer.length() > 0) {
                    decoded.append(processaBloco(buffer.toString()));
                    buffer.setLength(0);
                }
            } else {
                buffer.append(c);
        }
    }
        if (buffer.length() > 0) {
            decoded.append(processaBloco(buffer.toString()));
        }
    return decoded.toString();
    }
    
    private String processaBloco(String bloco) {
        if (bloco.isEmpty()) return "";
        PALAVRAS p = PALAVRAS.buscarPorPalavra(bloco);
        if (p != null) {
            return String.valueOf(p.getLetra());
        } else {
            return bloco; 
        }
    }
}

enum PALAVRAS {

    AMOR('a',"Amor"), BELEZA('b',"Beleza"), CORACAO('c',"Coracao"), DOCE('d',"Doce"),ESPERANCA('e',"Esperanca"),
    FELICIDADE('f',"Felicidade"), GENTE('g',"Gente"), HARMONIA('h',"Harmonia"), IMAGINACAO('i',"Imaginacao"), 
    JUVENTUDE('j',"Juventude"), KARINHO('k',"Karinho"), LIBERDADE('l',"Liberdade"), MAGIA('m',"Magia"),
    NATUREZA('n',"Natureza"), OTIMISMO('o',"Otimismo"), PAZ('p',"Paz"), QUERIDO('q',"Querido"), RESPEITO('r',"Respeito"),
    SOLIDARIEDADE('s',"Solidariedade"), TRANQUILIDADE('t',"Tranquilidade"), UNIAO('u',"Uniao"), VITORIA('v',"Vitoria"),WORLD('w',"World"),
    XUXA('x',"Xuxa"), YES('y', "Yes"), ZELO('z',"Zelo");

    private char letra;
    private String palavra;

    PALAVRAS(char c, String s){
    this.letra = c;
    this.palavra = s;
    }

    public static PALAVRAS buscarPorLetra(char c) {
        for (PALAVRAS p : PALAVRAS.values()) {
            if (p.letra == c) {
                return p;
            }
        }
        return null;
    }

    public static PALAVRAS buscarPorPalavra(String s) {
        for (PALAVRAS p : PALAVRAS.values()) {
            if (p.palavra.equals(s)) {
                return p;
            }
        }
        return null;
    }

    public char getLetra(){
        return letra;
    }

    public String getPalavra() {
        return palavra;
    }
}