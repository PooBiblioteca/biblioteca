package Entidade;

import DAO.FuncionarioDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Teste {

    public static void main(String[] args) throws ParseException {

        Funcionario f = new Funcionario();

       SimpleDateFormat   formato = new SimpleDateFormat("dd/MM/yyyy");
        
            String dataini = ("12/12/2010");
            Date dataf = formato.parse(dataini);
            
         //f.setCodigo(1);
        f.setNome("Mtas");
        f.setCpf("120.489.956-83");
        f.setEndereco("afdadfads");
        f.setEmail("matsagui");
        f.setTelefone("(38) 3744-1721");
        f.setSenhaacesso("matheus");
        f.setCodigoContrato(12);
        java.sql.Date Data = new java.sql.Date(dataf.getTime());
        f.setFimContrato(Data);

        FuncionarioDAO func = new FuncionarioDAO();
        func.Salvar(f);
    }
}

/* ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
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
        
    }*/
