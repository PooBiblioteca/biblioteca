package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidade.Emprestimo;
import Entidade.Exemplar;
import Entidade.Funcionario;
import Entidade.Usuario;
import java.sql.Date;

/**
 *
 * @author paulojp
 */
public class EmprestimoDAO {

    public void Salvar(Emprestimo emprestimo) throws SQLException {

        String sql = "INSERT INTO emprestimo(codigo, id_usuario, id_exemplar, id_funcionario, observacao, data_retirada, data_devolucao) VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        // Prepara conexão p/ receber o comando SQL

        // Seta os valores p/ o stmt, substituindo os "?"        
        stat.setInt(1, emprestimo.getCodigo());
        stat.setInt(2, emprestimo.getUsuario().getCodigo());
        stat.setInt(3, emprestimo.getExemplar().getCodigo());
        stat.setInt(4, emprestimo.getFuncionario().getCodigo());
        stat.setString(5, emprestimo.getObservacao());
        stat.setDate(6, (Date) emprestimo.getDataretirada());
        stat.setDate(7, (Date) emprestimo.getDataDevolucao());

        // O stmt executa o comando SQL no BD, e fecha a conexão
        stat.execute();
        stat.close();

    }

    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Emprestimo> getLista(String id) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM emprestimo WHERE codigo like ?";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, id);

        // Recebe o resultado da consulta SQL
        ResultSet rs = stat.executeQuery();

        List<Emprestimo> lista = new ArrayList<>();

        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while (rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo emprestimo = new Emprestimo();

     
            emprestimo.setCodigo(Integer.valueOf(rs.getString("codigo")));            
            Usuario usario = new Usuario();
            usario.setCodigo(rs.getInt("id_usuario"));
            Exemplar exemplar = new Exemplar();
            exemplar.setCodigo(rs.getInt("id_exemplar"));
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(rs.getInt("id_funcionario"));
            emprestimo.setObservacao(rs.getString("observacao"));
            emprestimo.setDataretirada(rs.getDate("data_retirada"));
            emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));

            // Adiciona o registro na lista
            lista.add(emprestimo);
        }

        // Fecha a conexão com o BD
        rs.close();
        stat.close();

        // Retorna a lista de registros, gerados pela consulta
        return lista;
    }

    public ArrayList<Emprestimo> BuscarIntervaloData() throws SQLException {

        String sql = "SELECT * FROM emprestimo WHERE data_retirada>=? and data_devolucao<=?";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
       

        // Recebe o resultado da consulta SQL
        ResultSet rs = stat.executeQuery();

        ArrayList<Emprestimo> lista = new ArrayList<>();

        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while (rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo emprestimo = new Emprestimo();

            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            emprestimo.setCodigo(Integer.valueOf(rs.getString("codigo")));            
            Usuario usario = new Usuario();
            usario.setCodigo(rs.getInt("id_usuario"));
            Exemplar exemplar = new Exemplar();
            exemplar.setCodigo(rs.getInt("id_exemplar"));
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(rs.getInt("id_funcionario"));
            emprestimo.setObservacao(rs.getString("observacao"));
            emprestimo.setDataretirada(rs.getDate("data_retirada"));
            emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));

            // Adiciona o registro na lista
            lista.add(emprestimo);
        }

        // Fecha a conexão com o BD
        rs.close();
        stat.close();

        // Retorna a lista de registros, gerados pela consulta
        return lista;

    }

    // DELETE - Apaga registros
    public void Remover(int id) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM emprestimo WHERE codigo=?";
        // stmt recebe o comando SQL
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);

        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stat.setInt(1, id);

        // Executa o codigo SQL, e fecha
        stat.execute();
        stat.close();

    }
    /* <-EMPRESTIMO---- */
}
