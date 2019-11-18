/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.model.dao;

import br.umc.loja.model.Produto;
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
 * @author 11152100531
 */
public class VendedorDAO {

    public VendedorDAO() throws ClassNotFoundException, SQLException {

    }

    //Inserir
    public void insert(Vendedor v) throws ClassNotFoundException, SQLException {
        Connection con = null;

        con = conectaDB.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into vendedor (nome, senha, eMail, foto, dataCadastro) values (?, ?, ?, 'nada.png', 'now()')");
        comando.setString(1, v.getNome());
        comando.setString(2, v.getSenha());
        comando.setString(3, v.geteMail());

        comando.execute();

        con.close();
    }

    //Deletar
    public static void delete(long id) throws SQLException {
        Connection con = null;
        try {
            con = conectaDB.getConexao();
            PreparedStatement comando = con.prepareStatement("delete from vendedor where id=(?)");
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

    //Alterar
    public static void altera(int id, String nome, String senha, String assinatura, String eMail) throws SQLException {
        Connection con = null;
        try {
            con = conectaDB.getConexao();
            PreparedStatement comando = con.prepareStatement("update vendedor set nome = ? , senha = ?, assinatura = ?, eMail = ?  where id=(?)");
            comando.setString(1, nome);
            comando.setString(2, senha);
            comando.setString(3, assinatura);
            comando.setString(4, eMail);
            comando.setInt(5, id);

            comando.execute();
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            con.close();
        }
    }

    //Descobrir quantos vendedores tem
    public int getNumber() throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor");

            resultado = comando.executeQuery();

            List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                listaVendedor.add(v);
            }

            return listaVendedor.size();

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    //Descobrir o numero de produtos de cada vendedor
    public int getNumberProdutos(int id) throws ClassNotFoundException, SQLException{
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where idVendedor = ? AND status = 0");
            comando.setInt(1, (int) id);
            
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                listaProdutos.add(p);
            }
            
            return listaProdutos.size();
            

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    //Descobrir o numero de produtos vendidos de cada vendedor
    public int getNumberProdutosVendidos(int id) throws ClassNotFoundException, SQLException{
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where idVendedor = ? AND status = 1");
            comando.setInt(1, (int) id);
            
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                listaProdutos.add(p);
            }           
            return listaProdutos.size();
            
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    //Descobrir o numero de produtos vendidos de cada vendedor
    public int getNumberProdutosComprados(int id) throws ClassNotFoundException, SQLException{
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where idComprador = ? AND status = 1");
            comando.setInt(1, (int) id);
            
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                listaProdutos.add(p);
            }           
            return listaProdutos.size();
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }

    //Listar todos
    public List<Vendedor> getAll() throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor ORDER BY id DESC");

            resultado = comando.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                v.setNome(resultado.getString("nome"));
                v.setSenha(resultado.getString("senha"));
                v.setFoto(resultado.getString("foto"));
                v.seteMail(resultado.getString("eMail"));
                v.setAssinatura(resultado.getString("assinatura"));
                v.setDataCadastro(resultado.getDate("dataCadastro"));
                listaVendedores.add(v);
            }

            return listaVendedores;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }

    //Descobrir vendedor pelo id
    public Vendedor getAllbyId(long id) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor where id = ? ORDER BY id DESC");
            comando.setInt(1, (int) id);

            resultado = comando.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                v.setNome(resultado.getString("nome"));
                v.setSenha(resultado.getString("senha"));
                v.setFoto(resultado.getString("foto"));
                v.seteMail(resultado.getString("eMail"));
                v.setAssinatura(resultado.getString("assinatura"));
                v.setDataCadastro(resultado.getDate("dataCadastro"));
                listaVendedores.add(v);
                return v;
            }

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
        return new Vendedor("bob",null,null);
    }
    
    //Descobrir vendedor pelo nome
    public int getAllbyNome(String nome) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;

        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor where nome = ? ORDER BY id DESC");
            comando.setString(1, nome);

            resultado = comando.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                v.setNome(resultado.getString("nome"));
                v.setSenha(resultado.getString("senha"));
                v.setFoto(resultado.getString("foto"));
                v.seteMail(resultado.getString("eMail"));
                v.setAssinatura(resultado.getString("assinatura"));
                v.setDataCadastro(resultado.getDate("dataCadastro"));
                
                return (int) v.getId();
            }

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
        return 0;
    }

    //Validar login
    public Boolean validarLogin(String nome, String senha) throws SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor where nome = ? AND senha = ? ORDER BY id DESC");
            comando.setString(1, nome);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                listaVendedores.add(v);
            }
            if (listaVendedores.size() == 0) {
                return false;
            } else {
                return true;
            }

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    //Validar senha
    public Boolean validarSenha(int id, String senha) throws SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor where id = ? AND senha = ? ");
            comando.setInt(1, id);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                listaVendedores.add(v);
            }
            if (listaVendedores.size() == 0) {
                return false;
            } else {
                return true;
            }

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    //Descobrir id vendedor pelo nome
    public int decobrirId(String nome, String senha) throws SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select id from vendedor where nome = ?");
            comando.setString(1, nome);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                int id = (resultado.getInt("id"));
                return id;
            }
            
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
        return 100;
    }
    
     //Consultar por nome
    public List<Vendedor> Consultar(Vendedor ve) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from vendedor WHERE nome ilike ? ORDER BY nome;");
            comando.setString(1,"%"+ ve.getNome() +"%");
            
            resultado = comando.executeQuery();

            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            while (resultado.next()) {
                Vendedor v = new Vendedor(null, null, null);
                v.setId(resultado.getInt("id"));
                v.setNome(resultado.getString("nome"));
                v.setSenha(resultado.getString("senha"));
                v.setFoto(resultado.getString("foto"));
                v.seteMail(resultado.getString("eMail"));
                v.setAssinatura(resultado.getString("assinatura"));
                listaVendedores.add(v);
            }

            return listaVendedores;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
}
