/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;


/**
 *
 * @author heitormaffra
 */

public class Usuario implements Serializable {
    
    private String nomeUsuario;
    private String senhaUsuario;

    public Usuario() {
    }

    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
}
