/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Leonardo
 */
public class DAOUsuario {
    private Connection conn;
    
    public DAOUsuario(){
        DAO d = new DAO();
        conn = d.conectar();
        
        //conn = new DAO.conectar();
    }
    public void inserir(Usuario usuario){
        try{
            String sql = "insert into usuario(nome,cpf,email,telefone) values"
                + "(?,?,?,?);";
        
        PreparedStatement st = conn.prepareStatement(sql);
        
        st.setString(1, usuario.getNome());
        st.setString(2, usuario.getCpf());
        st.setString(3, usuario.getEmail());
        st.setString(4, usuario.getTelefone());
        
        st.execute();
        st.close();
    } catch(SQLException ex){
        throw new RuntimeException(ex);
        }
    
    }
    public void atualizar(Usuario usuario){
       try{
        String sql = "Update usuario set nome=?, cpf=?, email=?, telefone=? where id=?;";
       
        PreparedStatement st = conn.prepareStatement(sql);
         
        st.setString(1, usuario.getNome());
        st.setString(2, usuario.getCpf());
        st.setString(3, usuario.getEmail());
        st.setString(4, usuario.getTelefone());
        st.setInt(5,usuario.getId());
        
        st.execute();
        st.close();
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public void deletar(Usuario usuario){
       try{
        String sql = "delete from usuario where id=?;";
       
        PreparedStatement st = conn.prepareStatement(sql);
        
        st.setInt(1,usuario.getId());
        
        st.execute();
        st.close();
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }       
    }
    public List<Usuario> listarUsuario(){
        try{ 
            String sql = "select * from usuario;";
        
            PreparedStatement st = conn.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
       
            List<Usuario> lista = new ArrayList<Usuario>();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                
                lista.add(u);
            }
            return lista;
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        } 
    }
}