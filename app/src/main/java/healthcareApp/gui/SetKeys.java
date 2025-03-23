package healthcareApp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import healthcareApp.encryption.Encryption;

public class SetKeys {
    private JPanel mainPanel;
    private JLabel publicLabel;
    private JTextField publicField;
    private JLabel privateLabel;
    private JTextField privateField;
    private JLabel modLabel;
    private JTextField modField;
    private JLabel publicKey;
    private JLabel privateKey;
    private JLabel errorLabel;
    private JButton sendButton;

    public SetKeys() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
    
        // Create components
        publicLabel = new JLabel("Set Public Key (e):");
        publicField = new JTextField(10);
        privateLabel = new JLabel("Set Private Key (d):");
        privateField = new JTextField(10);
        modLabel = new JLabel("Set Modulus (n):");
        modField = new JTextField(10);
        publicKey = new JLabel("Public Key: (" + Encryption.getE() + ", " + Encryption.getN() + ")");
        privateKey = new JLabel("Private Key: (" + Encryption.getD() + ", " + Encryption.getN() + ")");
        errorLabel = new JLabel("");
        sendButton = new JButton("Set");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (publicField.getText() != null) {
                        Encryption.setE(Integer.parseInt(publicField.getText()));
                        publicKey.setText("Public Key: (" + Encryption.getE() + ", " + Encryption.getN() + ")");
                        privateKey.setText("Private Key: (" + Encryption.getD() + ", " + Encryption.getN() + ")");
                        mainPanel.repaint();
                    }
                } catch (NumberFormatException error) {
                    
                }

                try {
                    if (privateField.getText() != null) {
                        Encryption.setD(Integer.parseInt(privateField.getText()));
                        publicKey.setText("Public Key: (" + Encryption.getE() + ", " + Encryption.getN() + ")");
                        privateKey.setText("Private Key: (" + Encryption.getD() + ", " + Encryption.getN() + ")");
                        mainPanel.repaint();
                    }
                } catch (NumberFormatException error) {
                    
                }

                try {
                    if (modField.getText() != null) {
                        Encryption.setN(Integer.parseInt(modField.getText()));
                        publicKey.setText("Public Key: (" + Encryption.getE() + ", " + Encryption.getN() + ")");
                        privateKey.setText("Private Key: (" + Encryption.getD() + ", " + Encryption.getN() + ")");
                        mainPanel.repaint();
                    }
                } catch (NumberFormatException error) {
                    
                }
            }
        });

        // Add e label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Align labels to the right
        mainPanel.add(publicLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align fields to the left
        mainPanel.add(publicField, gbc);

        // Add d label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(privateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(privateField, gbc);

        // Add n label and field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(modLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(modField, gbc);

        // Add answer labels
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(publicKey, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(privateKey, gbc);

        // Add submit button and error label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(errorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(sendButton, gbc);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
