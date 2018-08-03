package Entidade;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
        Exemplar zero =  new Exemplar();
        zero.setNumExemplar(0);
        zero.setDisponivel(false);
        exemplares.add(zero);
        Exemplar um =  new Exemplar();
        um.setNumExemplar(1);
        um.setDisponivel(false);
        exemplares.add(um);
        Exemplar dois =  new Exemplar();
        dois.setNumExemplar(2);
        dois.setDisponivel(true);
        exemplares.add(dois);
        
        Livro livro1 = new Livro();
        int i = livro1.obterDisponivel();
        livro1.setExemplares(exemplares);
        System.out.println(livro1.obterDisponivel());
        
    }
    
}
