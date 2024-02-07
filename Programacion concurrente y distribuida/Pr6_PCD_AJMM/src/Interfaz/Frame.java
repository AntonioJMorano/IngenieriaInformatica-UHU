/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.*;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author anton
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
        CanvasTaller ct = new CanvasTaller();
        
        f.setBackground(Color.cyan);
        f.setTitle("Practica 6 - PCD");
        f.setSize(500,600);
        f.add(ct);
        f.setResizable(false);
        f.setVisible(true);
        
        Semaphore general = new Semaphore (0);
        Semaphore[]propios = new Semaphore[4];
        for(int i = 0 ; i < 4 ;i++)
        {
            propios[i] = new Semaphore(1);
        }
        
        
        Thread[] robotsA = new Thread[4];
        RobotG rG = new RobotG(general,propios,ct);  
         rG.start();
               
        for(int i = 0 ; i < 4 ; i++)
        {
            robotsA[i] = new RobotA(propios[i],general , ct);
            robotsA[i].start();
            
        }    
       
        
        for(int i = 0 ; i < 4 ; i++)
        {            
            robotsA[i].join();
        }        
        
        
        rG.detener();
        
        sleep(1000);
        System.exit(0);
        
              
        
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}