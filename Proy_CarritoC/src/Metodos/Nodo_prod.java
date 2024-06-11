/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;
import java.awt.image.BufferedImage;

/**
 *
 * @author jhonh
 */
public class Nodo_prod {
    String Nom_producto;
    String Precio;
    byte Imagen[]; 
    
    Nodo_prod sig;

    public Nodo_prod(String Nom_producto, String Precio, byte[] Imagen, Nodo_prod sig) {
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
