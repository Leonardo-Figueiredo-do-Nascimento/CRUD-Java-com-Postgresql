/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import DAO.DAOUsuario;
import Model.Usuario;
/**
 *
 * @author Leonardo
 */
public class Main {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
        Usuario meuUser = new Usuario();
        meuUser.setId(1);
        meuUser.setNome("Leandro");
        meuUser.setCpf("98748548532");
        meuUser.setEmail("algumacoisa@");
        meuUser.setTelefone("37813314");
       
        DAOUsuario du = new DAOUsuario();
           du.deletar(meuUser);
        
        }
    }
}
