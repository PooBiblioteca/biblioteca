package DAO;

import Entidade.Exemplar;
import Entidade.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExemplarDAO {

    public void Salvar(Exemplar exemplar) throws SQLException {

        String sql = "INSERT INTO exemplar(codigo, id_livro, edicao, tombo, disponivel, num_exemplar) VALUES(?, ?, ?, ?, ?, ?)";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        // Prepara conexão p/ receber o comando SQL

        // Seta os valores p/ o stmt, substituindo os "?"        
        stat.setInt(1, exemplar.getCodigo());
        stat.setInt(2, exemplar.getLivro().getCodigo());
        stat.setShort(3, exemplar.getEdicao());
        stat.setInt(4, exemplar.getTombo());
        stat.setBoolean(5, exemplar.getDisponivel());
        stat.setInt(6, exemplar.getNumExemplar());

        // O stmt executa o comando SQL no BD, e fecha a conexão
        stat.execute();
        stat.close();

    }

    public ArrayList<Exemplar> BuscarExemplar() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from exemplar";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo autor */
            ArrayList<Exemplar> exemplares = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. 
                Exemplar exemplar = new Exemplar();

                /* Mapeando a tabela do banco para objeto */
                exemplar.setCodigo(rs.getInt("codigo"));
                Livro livro = new Livro();
                livro.setCodigo(rs.getInt("id_livro"));
                exemplar.setEdicao(rs.getShort("edicao"));
                exemplar.setTombo(rs.getInt("tombo"));
                exemplar.setDisponivel(rs.getBoolean("disponivel"));
                exemplar.setNumExemplar(rs.getInt("num_exemplar"));


                /* Inserindo o objeto  no ArrayList */
                exemplares.add(exemplar);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return exemplares;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally
    }

}
