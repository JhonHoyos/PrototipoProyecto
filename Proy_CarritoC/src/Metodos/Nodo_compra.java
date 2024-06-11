/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author jhonh
 */
public class Nodo_compra {
    String Nom_usuario;
    String Nom_prod;
    int cont; 
    
    Nodo_compra sig;

    public Nodo_compra(String nombreC, String nombreP, int cont, Nodo_compra sig) {
        this.Nom_usuario = nombreC;
        this.Nom_prod = nombreP;
        this.cont = cont;
        this.sig = sig;
    }
    
    public Nodo_compra(){
        
    }

    public Nodo_compra getSig() {
        return sig;
    }

    public void setSig(Nodo_compra sig) {
        this.sig = sig;
    }
    
}
