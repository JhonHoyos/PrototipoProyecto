/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.General.compra;
import static Metodos.General.prod;
import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhonh
 */
public class Lista_compra implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Nodo_compra cima;
    public Nodo_compra fin;
    private final String NombreFichero= "compra.dat";

    Lista_compra() {
        cima = null;
        fin = null;
    }
    
    public boolean lista_vacia() {
        LeerDeLFichero();
        return compra.cima == null;
    }
    
    
    //Metodo para guadar la clase usuario mediate el usu el cual es una instacia de la clase colaUsuarios :Es el objeto a serializar
    public void GuadarEnFichero() {
        try {
            GuadarEnArchvio.guardar(NombreFichero, compra);
        } catch (Exception e) {
            }
    }
//MEtodo para extraer los datos alamacenados en el archivo

    public void LeerDeLFichero() {
        try {
            compra = GuadarEnArchvio.Extraer(NombreFichero, Lista_compra.class);
            if (compra == null) {
                compra = new Lista_compra();
            }
        } catch (Exception e) {
        }
    }
    
    
    public void insertarCompra(Nodo_compra objet) {
        LeerDeLFichero();
        Nodo_compra aux = compra.cima;
        boolean encontrado = false;

        while (aux != null) {
            if (aux.Nom_prod.equals(objet.Nom_prod) && aux.Nom_usuario.equals(objet.Nom_usuario) && "En carrito".equals(aux.estado)) {
                aux.cantidad += objet.cantidad;
                encontrado = true;
                break;
            }
            aux = aux.sig;
        }

        if (!encontrado) {
            if (compra.cima == null) {
                compra.cima = objet;
            } else {
                compra.fin.sig = objet;
            }
            compra.fin = objet;
        }
        
        compra.GuadarEnFichero();
    }
    
    public void mostrar_carrito(DefaultTableModel tab, String estado, String nom_client){
        LeerDeLFichero();
        Nodo_compra aux=compra.cima;
        while(aux!= null){
            if(estado.equals(aux.estado) && aux.Nom_usuario.equals(nom_client)){
                int importe=aux.cantidad*prod.precioprod(aux.Nom_prod);
                tab.addRow(new Object[]{
                    aux.Nom_usuario,
                    aux.Nom_prod,
                    aux.cantidad,
                    prod.precioprod(aux.Nom_prod),
                    importe
                });
            }
            aux=aux.sig;
        }
    }
    
    public int mostrar_total (String nom_client){
        int total=0;
        LeerDeLFichero();
        Nodo_compra aux=compra.cima;
        while(aux!= null){
            if("En carrito".equals(aux.estado) && aux.Nom_usuario.equals(nom_client)){
                int importe=aux.cantidad*prod.precioprod(aux.Nom_prod);
                total+=importe;
            }
            aux=aux.sig;
        }
        return total+10000;
    }
    
    
    
    public void eliminarCompraPorNombre(String nombreProd) {
        LeerDeLFichero();
        Nodo_compra actual = compra.cima;
        Nodo_compra anterior = null;

        while (actual != null) {
            if (actual.Nom_prod.equals(nombreProd)) {
                if (anterior == null) {
                    compra.cima = actual.sig;
                } else {
                    anterior.sig = actual.sig;
                }

                if (actual.sig == null) {
                    compra.fin = anterior;
                }

                GuadarEnFichero();
                return;
            }
            anterior = actual;
            actual = actual.sig;
        }
    }
    
    
    public void cambiarEstadoCompra(String nom_client) {
        LeerDeLFichero();
        Nodo_compra aux = compra.cima;

        while (aux != null) {
            if ("En carrito".equals(aux.estado) && aux.Nom_usuario.equals(nom_client)) {
                aux.estado = "Comprado";
            }
            aux = aux.sig;
        }
        
        GuadarEnFichero();
    }
    
    
    
    
    public void mostrar_historial(DefaultTableModel tab, String nom_client){
        LeerDeLFichero();
        Nodo_compra aux=compra.cima;
        while(aux!= null){
            if("Comprado".equals(aux.estado) && aux.Nom_usuario.equals(nom_client)){
                int importe=aux.cantidad*prod.precioprod(aux.Nom_prod);
                tab.addRow(new Object[]{
                    
                    aux.Nom_prod,
                    aux.cantidad,
                    prod.precioprod(aux.Nom_prod),
                    importe
                });
            }
            aux=aux.sig;
        }
    }
    
    
}
