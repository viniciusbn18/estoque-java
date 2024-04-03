/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CGFEGF
 */
public class ModelUsuario {
    
    
    private int usuId;
    private String usuNome;
    private String usuLogin;  //Variáveis de Instância
    private String usuSenha;

    /**
     * @return the usuId
     * 
     * Métodos gets e sets que irão manipular as variáveis de instância
     */
    public int getUsuId() {
        return usuId;
    }

    /**
     * @param usuId the usuId to set
     */
    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    /**
     * @return the usuNome
     */
    public String getUsuNome() {
        return usuNome;
    }

    /**
     * @param usuNome the usuNome to set
     */
    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    /**
     * @return the usuLogin
     */
    public String getUsuLogin() {
        return usuLogin;
    }

    /**
     * @param usuLogin the usuLogin to set
     */
    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    /**
     * @return the usuSenha
     */
    public String getUsuSenha() {
        return usuSenha;
    }

    /**
     * @param usuSenha the usuSenha to set
     */
    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }
        
    
}
