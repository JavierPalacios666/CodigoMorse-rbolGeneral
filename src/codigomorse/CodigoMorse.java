/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigomorse;

import arbol.binario.ArbolBinario;
import javax.swing.JFrame;
/**
 *
 * @author Javier Alberto Palacios López
 */
public class CodigoMorse {

  /**
   * @param args the command line arguments
   */
  
  public static void main(String[] args) {
    // TODO code application logic here
    
    ArbolBinario arbol = new ArbolBinario(6);
    arbol.coord();
    //arbol.preOrden(arbol.raiz);
   
    PanelVisualizador panel = new PanelVisualizador(arbol); 
    PanelVentana pV = new PanelVentana(panel);
    
    JFrame ventana = new JFrame("Morse");
    ventana.setSize(500, 500);
    ventana.add(pV);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setVisible(true);
    
  //arbol.codigoMorse("");
    
    //System.out.println(arbol.raiz.hijoDerecho.hijoIzquierdo.hijoDerecho.hijoIzquierdo.caracter);
    
  }
  
}
