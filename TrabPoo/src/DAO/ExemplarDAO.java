package DAO;

import Entidade.Exemplar;
import Entidade.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExemplarDAO {

    public void Salvar(Exemplar exemplar) throws SQLException {

        String sql = "INSERT INTO exemplar(id_livro, edicao, tombo, disponivel, num_exemplar) VALUES( ?, ?, ?, ?, ?)";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        // Prepara conexão p/ receber o comando SQL

        // Seta os valores p/ o stmt, substituindo os "?"        
        // stat.setInt(1, exemplar.getCodigo());
        stat.setInt(1, exemplar.getLivro().getCodigo());
        stat.setShort(2, exemplar.getEdicao());
        stat.setInt(3, exemplar.getTombo());
        stat.setBoolean(4, exemplar.getDisponivel());
        stat.setInt(5, exemplar.getNumExemplar());

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
            sql = "select ex.codigo as exemplarcod, id_livro,edicao, tombo, disponivel, num_exemplar, livro.codigo as livrocod,livro.titulo as titulo from exemplar ex inner join livro livro on livro.codigo = ex.id_livro";

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
                exemplar.setCodigo(rs.getInt("exemplarcod"));
                exemplar.setEdicao(rs.getShort("edicao"));
                exemplar.setTombo(rs.getInt("tombo"));
                exemplar.setDisponivel(rs.getBoolean("disponivel"));
                exemplar.setNumExemplar(rs.getInt("num_exemplar"));

                Livro livro = new Livro();
                livro.setCodigo(rs.getInt("livrocod"));
                livro.setTitulo(rs.getString("titulo"));

                exemplar.setLivro(livro);

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

    public List<Exemplar> BuscarPorTitulo(String titulo) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "select ex.codigo as exemplarcod, id_livro,edicao, tombo, "
                + "disponivel, num_exemplar, livro.codigo as livrocod, "
                + "livro.titulo as titulo "
                + "from exemplar ex "
                + "inner join livro livro on livro.codigo = ex.id_livro AND upper(titulo) like ?";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, "%" + titulo.toUpperCase() + "%");

        // Recebe o resultado da consulta SQL
        ResultSet rs = stat.executeQuery();

        List<Exemplar> lista = new ArrayList<>();

        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while (rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Exemplar ex = new Exemplar();

            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            ex.setCodigo(rs.getInt("exemplarcod"));
            ex.setEdicao(rs.getShort("edicao"));
            ex.setTombo(rs.getInt("tombo"));
            ex.setDisponivel(rs.getBoolean("disponivel"));
            ex.setNumExemplar(rs.getInt("num_exemplar"));

            Livro livro = new Livro();
            livro.setCodigo(rs.getInt("livrocod"));
            livro.setTitulo(rs.getString("titulo"));

            ex.setLivro(livro);

            // Adiciona o registro na lista
            lista.add(ex);
        }

        // Fecha a conexão com o BD
        rs.close();
        stat.close();

        // Retorna a lista de registros, gerados pela consulta
        return lista;
    }
    
    public void alteraDisponibilidade(Exemplar l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE exemplar set disponivel=?"
                + "WHERE codigo=?";
        // stmt recebe o comando SQL
       Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"  
        stat.setBoolean(1, l.getDisponivel());
        // Usa o ID como parâmetro de comparação no SQL
        stat.setInt(2, l.getCodigo());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stat.execute();
        stat.close();
    }

}
