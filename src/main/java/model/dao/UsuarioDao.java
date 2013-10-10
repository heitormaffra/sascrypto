/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection.Conexao;
import model.entities.Usuario;

/**
 *
 * @author heitormaffra
 */
public class UsuarioDao implements Serializable {

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario"
                + "(usuario"
                + ",senha)"
                + "VALUES"
                + "(?,?)";
        try {
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenhaUsuario());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario findUsuario(String nomeUsuario) throws Exception {
        Usuario usuario = new Usuario();
        
        String sql = "SELECT usuario, senha FROM usuario WHERE usuario = ?";
        PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
        ps.setString(1, nomeUsuario);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            usuario.setNomeUsuario(rs.getString("usuario"));
            usuario.setSenhaUsuario(rs.getString("senha"));
        }
        
        return usuario;
    }
}
