package DAO;

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
        String sql = "INSERT INTO funcionario(nome,cpf,endereco,email,telefone,senha,codigocontrato,fimcontrato) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection con = ConectaBanco.getConexao();
            /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
            PreparedStatement stat = con.prepareStatement(sql);
          
            stat.setString(1, funcionario.getNome());
            stat.setLong(2, funcionario.getCpf());
            stat.setString(3, funcionario.getEndereco());
            stat.setString(4, funcionario.getEmail());
            stat.setInt(5, funcionario.getTelefone());
            stat.setString(6, funcionario.getSenhaacesso());
            stat.setInt(7, funcionario.getCodigoContrato());
            stat.setDate(8, (Date) funcionario.getFimContrato());

            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

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
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getLong("cpf"));
                 funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                 funcionario.setTelefone(rs.getInt("telefone"));
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
