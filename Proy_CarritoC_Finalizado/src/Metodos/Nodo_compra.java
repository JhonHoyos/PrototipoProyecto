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
public class Nodo_compra implements Serializable{
    private static final long serialVersionUID = 1L;
    String Nom_usuario;
    String Nom_prod;
    int cantidad;
    String estado;
    String cod_grupo;
    int preciounit;
    int cont; 
    
    Nodo_compra sig;

    public Nodo_compra(String nombreC, String nombreP, int cant, String esta, String cod_g, int pu,int cont, Nodo_compra sig) {
        this.Nom_usuario = nombreC;
        this.Nom_prod = nombreP;
        this.cantidad=cant;
        this.estado = esta;
        this.cod_grupo = cod_g;
        this.preciounit=pu;
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
