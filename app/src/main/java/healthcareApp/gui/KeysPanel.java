package healthcareApp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import healthcareApp.encryption.Encryption;

public class KeysPanel {
    JPanel mainPanel;
    JLabel primeOne;
    JTextField p;
    JLabel primeTwo;
    JTextField q;
    JLabel publicKey;
    JLabel privateKey;
    JLabel errorLabel;
    JButton sendButton;

    public KeysPanel() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
    
        // Create components
        primeOne = new JLabel("First Prime Number:");
        p = new JTextField(15);
        p.setToolTipText("Prime number");
        primeTwo = new JLabel("Second Prime Number:");
        q = new JTextField(15);
        q.setToolTipText("Prime number");
        publicKey = new JLabel("Public Key: ___");
        privateKey = new JLabel("Private Key: ___");
        errorLabel = new JLabel("");
        sendButton = new JButton("Generate:");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int pVal = Integer.parseInt(p.getText());
                    int qVal = Integer.parseInt(q.getText());
                    if (KeysPanel.isPrime(pVal) && KeysPanel.isPrime(qVal)) {
                        Encryption encryption = new Encryption(pVal, qVal);
                        publicKey.setText("Public Key: (" + encryption.getE() + ", " + encryption.getN() + ")");
                        privateKey.setText("Private Key: (" + encryption.calculatePrivateKey() + ", " + encryption.getN() + ")");
                        errorLabel.setText("");
                        mainPanel.repaint();
                    } else {
                        errorLabel.setText("Error: You must input two prime numbers");
                        privateKey.setText("Private Key: ___");
                        publicKey.setText("Public Key: ___");
                        mainPanel.repaint();
                    }
                } catch (NumberFormatException error) {
                    errorLabel.setText("Error: You must input two prime numbers");
                    privateKey.setText("Private Key: ___");
                    publicKey.setText("Public Key: ___");
                    mainPanel.repaint();
                }
            }
        });

        // Add p label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Align labels to the right
        mainPanel.add(primeOne, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align fields to the left
        mainPanel.add(p, gbc);

        // Add q label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(primeTwo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(q, gbc);

        // Add answer labels
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(publicKey, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(privateKey, gbc);

        // Add submit button and error label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(errorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(sendButton, gbc);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public static boolean isPrime(int num) {
        // Handle edge cases
        if (num <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        if (num == 2) {
            return true; // 2 is the only even prime number
        }
        if (num % 2 == 0) {
            return false; // Eliminate all other even numbers
        }

        // Check divisors from 3 up to the square root of the number
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true; // If no divisors are found, the number is prime
    }
}
