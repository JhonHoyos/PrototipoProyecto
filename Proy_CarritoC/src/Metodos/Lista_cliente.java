/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;
import static Metodos.General.client;
import java.io.Serializable;
import javax.swing.JOptionPane;


/**
 *
 * @author jhonh
 */
public class Lista_cliente implements Serializable{
    public Nodo_cliente cima;
    public Nodo_cliente fin;
    private final String NombreFichero= "cliente.dat";
    public static String nombre_usuario;

    Lista_cliente() {
        cima = null;
        fin = null;
    }

    
            
    public boolean lista_vacia() {
        LeerDeLFichero();
        return client.cima == null;
    }
    
    //Metodo para guadar la clase usuario mediate el usu el cual es una instacia de la clase colaUsuarios :Es el objeto a serializar
    public void GuadarEnFichero() {
        try {
            GuadarEnArchvio.guardar(NombreFichero, client);
        } catch (Exception e) {
            String mensaje = "Lo siento, no se pudo guardar la información en el archivo. Por favor, verifica que tengas permisos suficientes para acceder al archivo y vuelve a intentarlo.";
            JOptionPane.showMessageDialog(null, mensaje, "Error al guardar información", JOptionPane.ERROR_MESSAGE);
        }
    }
//MEtodo para extraer los datos alamacenados en el archivo

    public void LeerDeLFichero() {
        try {
            client = GuadarEnArchvio.Extraer(NombreFichero, Lista_cliente.class);
            if (client == null) {
                client = new Lista_cliente();
            }
        } catch (Exception e) {
            String mensaje = "Lo siento, no se pudieron cargar los datos del archivo. Por favor, verifica que el archivo existe y que tengas permisos suficientes para acceder a él.";
            JOptionPane.showMessageDialog(null, mensaje, "Error al cargar información", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    
    public void addfinal(Nodo_cliente objet) {
        if (lista_vacia()) {
            client.cima = objet;
        } else {
            if (fin == null) {
                client.cima.setSig(objet);
            } else {
                client.fin.setSig(objet);
            }
        }
        client.fin = objet;
        GuadarEnFichero();
    }
    
    public void addprincipio(Nodo_cliente objet) {

        objet.setSig(client.cima);
        client.cima=objet;
        GuadarEnFichero();
       
    }
    
     public boolean existeusuario(String usu) {
        LeerDeLFichero();
        Nodo_cliente aux = client.cima;
        while (aux != null) {
            if (aux.Nom_usuario.equals(usu)) {
                return true; 
            }
            aux = aux.sig;
        }
        return false; 
        
    }
    
    
     public boolean verificarContraseña(String usu, String contraseña) {
        LeerDeLFichero();
        Nodo_cliente aux = client.cima;
        while (aux != null) {
            if (aux.Nom_usuario.equals(usu) && aux.Contraseña.equals(contraseña)) {
                JOptionPane.showMessageDialog(null, "Sesión inicida con éxito: " + usu);
                nombre_usuario=aux.Nom_usuario;
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }
     
     
    
     
    
}
