/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidade.Pessoa;
import Entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    public void Salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,endereco,email,telefone,ativo,codigo_cadastro) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection con = ConectaBanco.getConexao();
            /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
            PreparedStatement stat = con.prepareStatement(sql);

            // stat.setInt(1, funcionario.getCodigo());
            stat.setString(1, usuario.getNome());
            stat.setString(2, usuario.getCpf());
            stat.setString(3, usuario.getEndereco());
            stat.setString(4, usuario.getEmail());
            stat.setString(5, usuario.getTelefone());
            stat.setBoolean(6, usuario.getAtivo());
            stat.setInt(7, usuario.getCodigoCadastro());

            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
        
         
 public ArrayList<Usuario> BuscarUsuario() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from usuario";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo autor */
            ArrayList<Usuario> usuarios = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. 
                Usuario usuario = new Usuario();

                /* Mapeando a tabela do banco para objeto */
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));            
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuario.setCodigoCadastro(rs.getInt("codigo_cadastro"));


                /* Inserindo o objeto  no ArrayList */
                usuarios.add(usuario);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return usuarios;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally
    }
 
  public List<Usuario> BuscarPorNome(String nome) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM usuario WHERE nome like ?";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, nome);

        // Recebe o resultado da consulta SQL
        ResultSet rs = stat.executeQuery();

        List<Usuario> lista = new ArrayList<>();

        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while (rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Usuario usuario = new Usuario();

            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            usuario.setCodigo(Integer.valueOf(rs.getString("codigo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setEndereco(rs.getString("endereco"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setAtivo(rs.getBoolean("ativo"));
            usuario.setCodigoCadastro(rs.getInt("codigo_contrato"));

            // Adiciona o registro na lista
            lista.add(usuario);
        }

        // Fecha a conexão com o BD
        rs.close();
        stat.close();

        // Retorna a lista de registros, gerados pela consulta
        return lista;
    }

}


