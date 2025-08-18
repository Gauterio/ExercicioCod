package com.exercicio;

public class App {
    public static void main(String[] args) throws Exception {
        //Codificador cod = new CodificadorSimples();
        Codificador cod = new CodificadorParaBaixinhos();

        System.out.println("Codificador: "+cod.getNome());
        System.out.println("Versao: "+cod.getDataCriacao());
        System.out.println("Nivel de segurança: "+cod.getNivelSeguranca());
        
        String texto = "Este e o string a ser codificado";
        String codificado = cod.codifica(texto);
        String decodificado = cod.decodifica(codificado);

        System.out.println("Texto original: "+texto);
        System.out.println("Texto codificado: "+codificado);
        System.out.println("Texto decodificado: "+decodificado);

        System.out.println("Codificador: "+cod1.getNome());
        System.out.println("Versao: "+cod1.getDataCriacao());
        System.out.println("Nivel de segurança: "+cod1.getNivelSeguranca());

        String codificado1 = cod1.codifica(texto);
        String decodificado1 = cod1.decodifica(codificado1);

        System.out.println("Texto original: "+texto);
        System.out.println("Texto codificado: "+codificado1);
        System.out.println("Texto decodificado: "+decodificado1);

    }