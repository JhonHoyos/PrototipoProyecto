/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.Serializable;

/**
 *
 * @author jhonh
 */
public class Nodo_cliente implements Serializable{
    
    String Nom_usuario;
    String Correo;
    String Contraseña; 
    
    Nodo_cliente sig;

    public Nodo_cliente(String nombre, String correo, String contra, Nodo_cliente sig) {
        this.Nom_usuario = nombre;
        this.Correo = correo;
        this.Contraseña = contra;
        this.sig = sig;
    }
    
    public Nodo_cliente(){
        
    }

    public Nodo_cliente getSig() {
        return sig;
    }

    public void setSig(Nodo_cliente sig) {
        this.sig = sig;
    }
    
}
