package healthcareApp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AppGUI implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String ENCRYPT = "Send Encrypted Message";
    final static String DECRYPT = "Decrypt Received Message";
    final static String KEYS = "Generate Public and Private Keys";
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel mainPanel = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { ENCRYPT, DECRYPT, KEYS};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        mainPanel.add(cb);
    
        
        // Create the card panels
        JPanel card1 = new EncryptionPanel().getPanel();

        JPanel card2 = new DecryptionPanel().getPanel();

        JPanel card3 = new KeysPanel().getPanel();
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, ENCRYPT);
        cards.add(card2, DECRYPT);
        cards.add(card3, KEYS);
         
        pane.add(mainPanel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Encrypted Email");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        AppGUI demo = new AppGUI();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}