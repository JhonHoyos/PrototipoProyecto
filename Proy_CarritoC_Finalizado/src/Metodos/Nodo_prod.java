/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author jhonh
 */
public class Nodo_prod implements Serializable{
    private static final long serialVersionUID = 1L;
    String Nom_producto;
    int Precio;
    byte Imagen[]; 
    
    Nodo_prod sig;

    public Nodo_prod(String Nom_producto, int Precio, byte[] Imagen, Nodo_prod sig) {
        this.Nom_producto = Nom_producto;
        this.Precio = Precio;
        this.Imagen = Imagen;
        this.sig = sig;
    }
    
    public Nodo_prod(){
        
    }

    public Nodo_prod getSig() {
        return sig;
    }

    public void setSig(Nodo_prod sig) {
        this.sig = sig;
    }
}
