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
        String encoded = null;
        for (char c : str.toCharArray())
            encoded = " " + PALAVRAS.getPalavra(c);
        return encoded;
    }

    public String decodifica(String str) {
        String encoded = null;
        return encoded;
    }

}

enum PALAVRAS {

    AMOR('a',"Amor"), BELEZA('b',"Beleza"), CORACAO('c',"Coracao"), DOCE('d',"Doce"),ESPERANCA('e',"Esperanca"),
    FELICIDADE('f',"Felicidade"), GENTE('g',"Gente"), HARMONIA('h',"Harmonia"), IMAGINACAO('i',"Imaginacao"), 
    JUVENTUDE('j',"Juventude"), KARINHO('k',"Karinho"), LIBERDADE('l',"Liberdade"), MAGIA('m',"Magia"),
    NATUREZA('n',"Natureza"), OTIMISMO('o',"Otimismo"), PAZ('p',"Paz"), QUERIDO('q',"Querido"), 
    SOLIDARIEDADE('s',"Solidariedade"), TRANQUILIDADE('t',"Tranquilidade"), UNIAO('u',"Uniao"), WORLD('w',"World"),
    XUXA('x',"Xuxa"), YES('y', "Yes"), ZELO('z',"Zelo");

    private final String palavra;
    private final char letra;

    PALAVRAS(char c, String s){
    this.letra = c;
    this.palavra = s;
    }

    public char getLetra(String s){
        return letra;
    }

    public static String getPalavra(char c) {
        return palavra;
    }
}