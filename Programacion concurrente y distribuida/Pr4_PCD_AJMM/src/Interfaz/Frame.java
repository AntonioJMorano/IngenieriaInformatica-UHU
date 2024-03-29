/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.*;
import java.awt.Color;

/**
 *
 * @author usuario
 */
public class Frame extends java.awt.Frame {

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        
        
        Frame f = new Frame();
        CanvasPila c = new CanvasPila(7);
        
        f.setBackground(Color.cyan);
        f.setTitle("Practica 4 - PCD");  
        f.setSize(500,600);
        f.add(c);
        f.setResizable(false);     
        f.setVisible(true);
        
        PilaLenta pl = new PilaLenta(7,c);
        
        
        Productor p1 = new Productor(pl);
        Productor p2 = new Productor(pl);      
        Productor p3 = new Productor(pl);     
        Productor p4 = new Productor(pl);  
        Thread c1 = new Thread(new Consumidor(pl));
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c1.start();        
        
        c1.join();
        
        p1.interrupt();
        p2.interrupt();
        p3.interrupt();
        p4.interrupt();
        
        p1.join();
        p2.join();
        p3.join();
        p4.join();
        
        
        
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
