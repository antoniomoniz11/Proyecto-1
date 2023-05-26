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
    private int[] amigos;
    
    public Usuario(int id, String nickname){
        this.id = id;
        this.nickname = nickname;
        this.amigos = new int[0];
    }
    
    public int getId() {return id;}
    public String getNickname() {return nickname;}    
    
    public void agregarAmigo(int idAmigo) {
        int[] nuevosAmigos = new int[amigos.length + 1];
        System.arraycopy(amigos, 0, nuevosAmigos, 0, amigos.length);
        nuevosAmigos[amigos.length] = idAmigo;
        amigos = nuevosAmigos;
    }
}