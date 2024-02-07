/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author anton
 */
public class CanvasAFND extends Canvas {

    AutomataND automata;
    String cadena;
    
    public CanvasAFND()
    {
        this.automata = new AutomataND();
        cadena = null;
    }
    
    @Override
    public void paint(Graphics g)            
    {
       
        Image img = createImage(getWidth(),getHeight());
        Graphics gF = img.getGraphics();
        
        Font f1 = new Font("Arial",Font.BOLD,12);
        Font f2 = new Font("Arial",Font.BOLD,20);
        gF.setFont(f1);               
        
        int x=40;
        int y=40;  
       
        //Informa estado inicial y simbolos
        gF.setColor(Color.red);
         gF.setFont(f2);
        gF.drawString("Estado inicial",20,200);
        
        gF.setColor(Color.BLACK);
         gF.setFont(f1);
         gF.drawString(""+automata.getEstadosIni(), 20, 225);
        
        int px = 20;
        for(int i = 0 ; i <automata.getSimbolos().size() ; i++)
        {
         gF.setColor(Color.red);
         gF.setFont(f2);
         gF.drawString("Simbolos",20,250); 
         
         gF.setColor(Color.BLACK);
         gF.setFont(f1);
         gF.drawString("" + automata.getSimbolos().get(i),px,270); 
         px+=25;
        }
        
        //Informa transiciones existentes
        int px2= 320;
       for(int i = 0 ; i < automata.getTransiciones().size() ; i++)
       {
           gF.setColor(Color.red);
         gF.setFont(f2);
         gF.drawString("Transiciones", 20, 300);
         gF.setColor(Color.BLACK);
         gF.setFont(f1);
        gF.drawString(""+automata.getTransiciones(), 20, 320);
       }
        
        //Dibujo circulos para cada estado o estado final 
        for(String e : automata.getEstados())
        {
             if(automata.getEstadosF().contains(e))
            {
               gF.setColor(Color.red);
               gF.fillOval(x, y, 35, 35); 
            }     
            gF.setColor(Color.BLACK);   
            gF.fillOval(x,y,30,30);             
                        
            gF.drawString(""+e, x, y+40);
            
            x+=50;
            y+=50;
        }      
        gF.setFont(f2);
        gF.drawString("Cadena a ejecutar -> " + cadena, 150, 40);
        
        g.drawImage(img, 0, 0, null);
       
      
    }
    
    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
    public void actualiza(AutomataND a , String c)
    {
        this.automata = a;
        this.cadena = c ;
        System.out.println("Estados:"+a.getEstados());
        System.out.println("Estados Finales:"+a.getEstadosF());
        System.out.println("Estado inicial:"+a.getEstadosIni());
        System.out.println("Transiciones:"+a.getTransiciones());
        System.out.println("Simbolos:"+a.getSimbolos());
        repaint();
        
    }
}
