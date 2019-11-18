package br.umc.loja.model.dao;

import br.umc.loja.model.Produto;
import br.umc.loja.model.conectaDB;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;   

/**
 *
 * @author odair
 */
public class ProdutoDAO {

    private static List<Produto> produtos = new ArrayList<>();
    
    
    public ProdutoDAO() throws ClassNotFoundException, SQLException {

    }

    public void insert(Produto p) throws ClassNotFoundException, SQLException {       
        Connection con = null;

        con = conectaDB.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produtos (status,nome, marca, foto, descri, preco, idVendedor, dataCriacao) values (0, ?, ?, ?, ?, ?, ?, 'now()')");
        comando.setString(1, p.getNome());
        comando.setString(2, p.getMarca());
        comando.setString(3, p.getFoto());
        comando.setString(4, p.getDescri());
        comando.setDouble(5, p.getPreco());
        comando.setInt(6, p.getIdVendedor());

        comando.execute();

        con.close();
    }

    public static void delete(long id) throws SQLException {
        Connection con = null;
        try {
            con = conectaDB.getConexao();
            PreparedStatement comando = con.prepareStatement("delete from produtos where id=(?)");
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
    
    public static void altera(long id, String nome, String marca, String foto, String descri, Double preco) throws SQLException {
        Connection con = null;
        try {
            con = conectaDB.getConexao();
            PreparedStatement comando = con.prepareStatement("update produtos set nome = ? , marca = ?, foto = ?, descri = ?, preco = ?  where id=(?)");
            comando.setString(1, nome);
            comando.setString(2, marca);
            comando.setString(3, foto);
            comando.setString(4, descri);
            comando.setDouble(5, preco);
            comando.setInt(6, (int) id);
            
            comando.execute();
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            con.close();    
        }
    }
    
    public static void compra(long id, long idComprador) throws SQLException {
        Connection con = null;
        try {
            con = conectaDB.getConexao();
            PreparedStatement comando = con.prepareStatement("update produtos set status = 1, idComprador = ?, dataCompra = 'now()'  where id=(?)");
            comando.setInt(1, (int) idComprador);
            comando.setInt(2, (int) id);
            
            comando.execute();
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            con.close();    
        }
    }

    public int getNumber() throws ClassNotFoundException, SQLException{
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where status = 0");

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
    
    public int getNumberVendidos() throws ClassNotFoundException, SQLException{
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where status = 1");

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
    
    public List<Produto> getAll() throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where status = 0 ORDER BY id DESC");

            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setMarca(resultado.getString("marca"));
                p.setFoto(resultado.getString("foto"));
                p.setDescri(resultado.getString("descri"));
                p.setPreco(resultado.getDouble("preco"));
                p.setIdVendedor(resultado.getInt("idVendedor"));
                listaProdutos.add(p);
            }
            if (listaProdutos.size() == 0) {
                insert(new Produto("Processador Ryzen 1600x", "AMD", "2", "Uma espécie de microchip especializado", 100.00, 1));
                insert(new Produto("placa de video gtx 1080", "nvidia", "5", "É o componente do hardware do computador responsável por administrar e controlar as funções de exibição de vídeo na tela.", 500.00, 1));
                insert(new Produto("ssd 250gb", "sandisk", "3", "É é uma nova tecnologia de armazenamento considerada a evolução do disco rígido", 200.50, 1));
                insert(new Produto("pendrive", "kingston", "4", "É um dispositivo de memória constituído por memória flash", 150.00, 1));
                insert(new Produto("mouse", "microsoft", "1", "Periférico de entrada usado para movimentar o cursor pela tela", 50.00, 1));
            }
            
            return listaProdutos;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    public List<Produto> getAllMy(int id) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where status = 0 AND idVendedor = ? ORDER BY id DESC");
            comando.setInt(1, id);
            
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setMarca(resultado.getString("marca"));
                p.setFoto(resultado.getString("foto"));
                p.setDescri(resultado.getString("descri"));
                p.setPreco(resultado.getDouble("preco"));
                p.setIdVendedor(resultado.getInt("idVendedor"));
                listaProdutos.add(p);
            }
            if (listaProdutos.size() == 0) {
                insert(new Produto("Processador Ryzen 1600x", "AMD", "2", "Uma espécie de microchip especializado", 100.00, 1));
                insert(new Produto("placa de video gtx 1080", "nvidia", "5", "É o componente do hardware do computador responsável por administrar e controlar as funções de exibição de vídeo na tela.", 500.00, 1));
                insert(new Produto("ssd 250gb", "sandisk", "3", "É é uma nova tecnologia de armazenamento considerada a evolução do disco rígido", 200.50, 1));
                insert(new Produto("pendrive", "kingston", "4", "É um dispositivo de memória constituído por memória flash", 150.00, 1));
                insert(new Produto("mouse", "microsoft", "1", "Periférico de entrada usado para movimentar o cursor pela tela", 50.00, 1));
            }
            
            return listaProdutos;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    public List<Produto> getAllOthers(int id) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where status = 0 AND idVendedor <> ? ORDER BY id DESC");
            comando.setInt(1, id);
            
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setMarca(resultado.getString("marca"));
                p.setFoto(resultado.getString("foto"));
                p.setDescri(resultado.getString("descri"));
                p.setPreco(resultado.getDouble("preco"));
                p.setIdVendedor(resultado.getInt("idVendedor"));
                listaProdutos.add(p);
            }
            if (listaProdutos.size() == 0) {
                insert(new Produto("Processador Ryzen 1600x", "AMD", "2", "Uma espécie de microchip especializado", 100.00, 1));
                insert(new Produto("placa de video gtx 1080", "nvidia", "5", "É o componente do hardware do computador responsável por administrar e controlar as funções de exibição de vídeo na tela.", 500.00, 1));
                insert(new Produto("ssd 250gb", "sandisk", "3", "É é uma nova tecnologia de armazenamento considerada a evolução do disco rígido", 200.50, 1));
                insert(new Produto("pendrive", "kingston", "4", "É um dispositivo de memória constituído por memória flash", 150.00, 1));
                insert(new Produto("mouse", "microsoft", "1", "Periférico de entrada usado para movimentar o cursor pela tela", 50.00, 1));
            }
            
            return listaProdutos;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
    public List<Produto> getAllbyId(long id) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
            PreparedStatement comando = conexao.prepareStatement("select * from produtos where id = ? ORDER BY id DESC");
            comando.setInt(1, (int) id);
            
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setMarca(resultado.getString("marca"));
                p.setFoto(resultado.getString("foto"));
                p.setDescri(resultado.getString("descri"));
                p.setPreco(resultado.getDouble("preco"));
                p.setIdVendedor(resultado.getInt("idVendedor"));
                p.setDataCriacao(resultado.getDate("dataCriacao"));
                listaProdutos.add(p);
            }
            if (listaProdutos.size() == 0) {
                insert(new Produto("Processador Ryzen 1600x", "AMD", "2", "Uma espécie de microchip especializado", 100.00, 1));
                insert(new Produto("placa de video gtx 1080", "nvidia", "5", "É o componente do hardware do computador responsável por administrar e controlar as funções de exibição de vídeo na tela.", 500.00, 1));
                insert(new Produto("ssd 250gb", "sandisk", "3", "É é uma nova tecnologia de armazenamento considerada a evolução do disco rígido", 200.50, 1));
                insert(new Produto("pendrive", "kingston", "4", "É um dispositivo de memória constituído por memória flash", 150.00, 1));
                insert(new Produto("mouse", "microsoft", "1", "Periférico de entrada usado para movimentar o cursor pela tela", 50.00, 1));
            }
            
            return listaProdutos;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
     public List<Produto> Consultar(Produto p) throws ClassNotFoundException, SQLException {
        ResultSet resultado = null;
        Statement stmt = null;
        Connection conexao = null;
        try {
            conexao = conectaDB.getConexao();
            stmt = conexao.createStatement();
           PreparedStatement comando = conexao.prepareStatement("select * from produtos WHERE nome ilike ? AND marca ilike ? AND status = 0 ORDER BY id DESC;");
            comando.setString(1,"%"+ p.getNome() +"%");
            comando.setString(2, "%"+ p.getMarca() +"%");
            resultado = comando.executeQuery();

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultado.next()) {
                Produto pr = new Produto();
                pr.setId(resultado.getInt("id"));
                pr.setNome(resultado.getString("nome"));
                pr.setMarca(resultado.getString("marca"));
                pr.setFoto(resultado.getString("foto"));
                pr.setDescri(resultado.getString("descri"));
                pr.setIdVendedor(resultado.getInt("idVendedor"));
                pr.setPreco(resultado.getDouble("preco"));
                listaProdutos.add(pr);
            }
            
            return listaProdutos;

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
            conexao.close();
        }
    }
    
}
