/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.model.dao;

import br.umc.loja.model.Mensagem;
import br.umc.loja.model.Vendedor;
import br.umc.loja.model.conectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class MensagemDAO {
    public MensagemDAO() throws ClassNotFoundException, SQLException {

    }
    
    //Inserir
    public void insert(Mensagem m) throws ClassNotFoundException, SQLException {
        Connection con = null;

        con = conectaDB.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into mensagens (status, destinatario, remetente, assunto, conteudo, data) values (0, ?, ?, ?, ? , 'now()')");
        comando.setInt(1, m.getDestinatatio());
        comando.setInt(2, m.getRemetente());
        comando.setString(3, m.getAssunto());
        comando.setString(4, m.getConteudo());

        comando.execute();

        con.close();
    }
    
    //Deletar
    public void delete(long id) throws SQLException {
        Connection con = null;
        try {
            con = conectaDB.getConexao();
            PreparedStatement comando = con.prepareStatement("delete from mensagens where id=(?)");
            comando.setInt(1, (int) id);
            comando.execute();
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            con.close();    
        }
    }
    
    //Listar todos
    public List<Mensagem> getAll(int idUsuario) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select mensagens.*, vendedor.* from mensagens  INNER JOIN vendedor ON(vendedor.id = mensagens.remetente) where destinatario = ?");
            comando.setInt(1, (int) idUsuario);
            
            resultado = comando.executeQuery();

            List<Mensagem> listaMensagens = new ArrayList<Mensagem>();
            while (resultado.next()) {
                Mensagem m = new Mensagem(0,0, null, null);
                m.setId(resultado.getInt("id"));
                m.setStatus(resultado.getInt("status"));
                m.setDestinatatio(resultado.getInt("destinatario"));
                m.setRemetente(resultado.getInt("remetente"));
                m.setAssunto(resultado.getString("assunto"));
                m.setConteudo(resultado.getString("conteudo"));
                m.setData(resultado.getDate("data"));
                m.getRem().setFoto(resultado.getString("foto"));
                listaMensagens.add(m);
            }

            return listaMensagens;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
}
