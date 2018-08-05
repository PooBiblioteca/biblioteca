package DAO;

import Entidade.Criptografar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entidade.Funcionario;
import java.sql.Date;
import java.sql.PreparedStatement;

public class FuncionarioDAO {

    public void Salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(nome,cpf,endereco,email,telefone,senha,contrato,fim_contrato) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection con = ConectaBanco.getConexao();
            /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
            PreparedStatement stat = con.prepareStatement(sql);

           // stat.setInt(1, funcionario.getCodigo());
            stat.setString(1, funcionario.getNome());
            stat.setString(2, funcionario.getCpf());
            stat.setString(3, funcionario.getEndereco());
            stat.setString(4, funcionario.getEmail());
            stat.setString(5, funcionario.getTelefone());
            stat.setString(6, Criptografar.encriptografar(funcionario.getSenhaacesso()));
            stat.setInt(7, funcionario.getCodigoContrato());
            stat.setDate(8, (Date) funcionario.getFimContrato());

            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public boolean CheckLogin(String email, String senha) throws SQLException {

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = null;
        ResultSet rs = null;
        boolean check = false;

        try {

            stat = con.prepareStatement("select * from funcionario where email = ? and senha = ?");

            stat.setString(1, email);
            stat.setString(2, senha);

            rs = stat.executeQuery();
            if (rs.next()) {

                check = true;
            }

            //Retornando o ArrayList com todos objetos
        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally

        return check;
    }

    public ArrayList<Funcionario> BuscarFuncionario() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from funcionario";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo autor */
            ArrayList<Funcionario> funcionarios = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. 
                Funcionario funcionario = new Funcionario();

                /* Mapeando a tabela do banco para objeto */
               // funcionario.setCodigo(rs.getInt("codigo"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSenhaacesso(rs.getString("senha"));
                funcionario.setCodigoContrato(rs.getInt("codigocontrato"));
                funcionario.setFimContrato(rs.getDate("fimcontrato"));


                /* Inserindo o objeto  no ArrayList */
                funcionarios.add(funcionario);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return funcionarios;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally
    }

}
