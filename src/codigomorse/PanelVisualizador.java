/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigomorse;

import arbol.binario.ArbolBinario;
import arbol.binario.Nodo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Javier Alberto Palacios López
 */
public class PanelVisualizador extends JPanel {

  public ArbolBinario arbol = null;
  public String[] m = null;

  public PanelVisualizador(ArbolBinario arbol) {

    this.arbol = arbol;

  }

  @Override
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    g.translate(this.getWidth() / 2, this.getHeight() / 2);
    //this.arbol.coord();
    this.arbol.preOrden(this.arbol.raiz, g);

    g.setColor(Color.BLACK);

    Font fuente = new Font("Arial", Font.ITALIC, 20);
    g.setFont(fuente);

    if (m != null) {
      int x = 400;
      int y = -300;

      for (int i = 0; i < m.length; i++) {

        g.setColor(Color.CYAN);
        g.drawRect(x, y - 10, 40, 10);
        g.setColor(Color.BLACK);
        g.drawString(m[i], x, y);

        String cad = m[i];
        
        Nodo r = this.arbol.raiz;
        if(cad.charAt(0) == '.'){
          r = r.hijoIzquierdo;
        }else{
          r = r.hijoDerecho;
        }
        
        g.setColor(Color.red);
        BasicStroke grosor = new BasicStroke(2.6f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(grosor);
        for (int j = 1; j < cad.length(); j++) {
          
          g.drawOval(r.x-15, r.y-25,40, 40);
          
          if(cad.charAt(j) == '.'){
            //System.out.println("punto");
            r = r.hijoIzquierdo;
          }else if(cad.charAt(j) == '-'){
            //System.out.println("linea");
            r = r.hijoDerecho;
          }
          
        }
        
        g.setColor(Color.CYAN);
        g.drawOval(r.x-15, r.y-25,40, 40);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(i), r.x-15, r.y-25);
        

        y = y + 20;

      }
    }

    //g.drawString(m, 300, -300);
  }

}
