/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.General.client;
import static Metodos.General.prod;
import java.io.Serializable;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonh
 */
public class Lista_producto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public Nodo_prod cima;
    public Nodo_prod fin;
    private final String NombreFichero= "prod.dat";

    Lista_producto() {
        cima = null;
        fin = null;
    }
    
    public boolean lista_vacia() {
        LeerDeLFichero();
        return prod.cima == null;
    }
    
    
    //Metodo para guadar la clase usuario mediate el usu el cual es una instacia de la clase colaUsuarios :Es el objeto a serializar
    public void GuadarEnFichero() {
        try {
            GuadarEnArchvio.guardar(NombreFichero, prod);
        } catch (Exception e) {
            }
    }
//MEtodo para extraer los datos alamacenados en el archivo

    public void LeerDeLFichero() {
        try {
            prod = GuadarEnArchvio.Extraer(NombreFichero, Lista_producto.class);
            if (prod == null) {
                prod = new Lista_producto();
            }
        } catch (Exception e) {
        }
    }
    
    
    public void insertarproducto(Nodo_prod objet) {
       
        LeerDeLFichero();
        if (prod.cima == null) {
            prod.cima = objet;
        } else {
            prod.fin.sig=objet;
        }
        prod.fin = objet;
        prod.GuadarEnFichero();

    }
    
    
    public boolean buscarprod(String producto) {
        LeerDeLFichero();
        Nodo_prod aux = prod.cima;
        while (aux != null) {
            if (aux.Nom_producto.equals(producto)) {
                return true; 
            }
            aux = aux.sig;
        }
        return false; 
        
    }
    
    public int precioprod(String nombreP){
        LeerDeLFichero();
        Nodo_prod aux= cima;
        while(aux!=null){
            if(aux.Nom_producto.equals(nombreP)){
                return aux.Precio;
            }
            aux=aux.sig;
        }
        return -1;
    }
    
    
    public void busprodctos(JComboBox v) {
    LeerDeLFichero();
    Nodo_prod aux = cima;
    HashSet<String> nombresProductos = new HashSet<>();

    while (aux != null) {
        if (!nombresProductos.contains(aux.Nom_producto)) {
            nombresProductos.add(aux.Nom_producto);
            v.addItem(aux.Nom_producto);
        }
        aux = aux.sig;
    }
    }
    
    
    public void actualizarprod(String nombre_pr, int precio) {
        LeerDeLFichero();
        Nodo_prod aux = prod.cima;

        while (aux != null) {
            if (nombre_pr.equals(aux.Nom_producto) ) {
                aux.Precio = precio;
            }
            aux = aux.sig;
        }
        
        GuadarEnFichero();
    }
    
}    


