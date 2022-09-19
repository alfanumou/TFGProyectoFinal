/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.utilidades;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author vekto
 */
public class EntradaTecladoListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
        int key = ke.getKeyChar();

        boolean numeros = key >= 48 && key <= 57 || key==127;
        JTextField jtext=(JTextField) ke.getComponent();
        if (!numeros||jtext.getText().length()>=6) {
            ke.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
   
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
