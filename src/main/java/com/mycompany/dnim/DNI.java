package com.mycompany.dnim;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DNI extends JPanel implements Serializable {
    
    private JLabel a;
    private JTextField b;
    private final String dniChars="TRWAGMYFPDXBNJZSQVHLCKE"; 
    
    public DNI() {
        init();
    }
    
    public void init() {
        a = new JLabel("DNI: ");
        b = new JTextField(8);
        this.setVisible(true);
        this.add(a);
        this.add(b);
        b.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                b.setForeground(Color.BLACK);  
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!validar(b.getText())) {
                    b.setForeground(Color.red);  
                }
                else {
                    b.setForeground(Color.green);
                }
               
            }
        });
    }
    public boolean validar(String dni) {
        boolean retorno = false;
        if (dni.length() >= 2 && dni.length() <= 9){
            String numeros = dni.trim().replaceAll(" ", "").substring(0, dni.length() - 1);
            char ltrDNI = dni.charAt(dni.length() - 1);
            try {
                int valNumDni = Integer.parseInt(numeros) % 23;
                if (esNumero(numeros) && dniChars.charAt(valNumDni) == ltrDNI) {
                    retorno = true;
                }
            } catch(NumberFormatException nfe) {
                
            }
        }
        return retorno;
    }
    
    public static boolean esNumero(String str)  {  
        try  
        {  
          double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
          return false;  
        }  
        return true;  
    }
    
}
