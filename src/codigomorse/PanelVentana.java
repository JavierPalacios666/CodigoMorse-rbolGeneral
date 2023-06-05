/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigomorse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class PanelVentana extends JPanel{

  public PanelVisualizador panel = null;
  public JTextArea morseDireccion = null;
  
  public PanelVentana(PanelVisualizador panel) {
    this.setLayout(new BorderLayout());
    this.panel = panel;
    this.panel.setBackground(Color.GREEN);
    
    JPanel panelNorte = new JPanel();
    
    JLabel texto = new JLabel("Ingrese sus caracteres");
    
    JTextField jTF = new JTextField(30);
    
    jTF.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        String cadena = jTF.getText();
        
        String nuevaCadena = "";
        
        for (int i = 0; i < cadena.length(); i++) {
          
          if(cadena.charAt(i) == ' '){
            
          }else{
            nuevaCadena = nuevaCadena + String.valueOf(cadena.charAt(i));
          }
          
        }
        
        //System.out.println(nuevaCadena);
        
        String morse = "";
        
        for (int i = 0; i < nuevaCadena.length(); i++) {
          
          panel.arbol.codigoMorse(String.valueOf(nuevaCadena.charAt(i)).toUpperCase());
          morse = morse+panel.arbol.cadenaMorse+" ";
          
        }
        
        String[] vector = morse.split(" ");
        
//        System.out.println(Arrays.toString(vector));
        panel.m = vector;
        panel.repaint();
        //panel.arbol.codigoMorse("");
        
      }
    });
    
    panelNorte.add(texto);
    panelNorte.add(jTF);
    
    this.add(panelNorte,BorderLayout.NORTH);
    this.add(this.panel,BorderLayout.CENTER);
    
    
    
  }
  
}
