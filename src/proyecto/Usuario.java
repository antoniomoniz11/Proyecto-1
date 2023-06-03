/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Antonio
 */
public class Usuario
{
    private int id;
    private String nickname;
    
    public Usuario(int id, String nickname){
        this.id = id;
        this.nickname = nickname;
    }
    
    public int getId() {return id;}
    public String getNickname() {return nickname;}    
}
