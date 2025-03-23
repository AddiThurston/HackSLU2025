package healthcareApp.gui;

import healthcareApp.EmailSender;
import healthcareApp.encryption.Encryption;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EncryptionPanel {
    private JPanel mainPanel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JLabel recipientLabel;
    private JTextField recipientField;
    private JLabel messageLabel;
    private JTextArea messageArea;
    private JLabel errorLabel;
    private JButton sendButton;

    public EncryptionPanel() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
    
        // Create components
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(15);
        recipientLabel = new JLabel("Recipient:");
        recipientField = new JTextField(15);
        messageLabel = new JLabel("Message:");
        messageArea = new JTextArea(5, 15);
        sendButton = new JButton("Encrypt and Send");
        errorLabel = new JLabel("");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Encryption.getE() != 0 && Encryption.getN() != 0) {
                    String encryptedEmail = Encryption.encrypt(messageArea.getText());
                    if (EmailSender.send(usernameField.getText(), passwordField.getText(), recipientField.getText(), encryptedEmail)) {
                        errorLabel.setText("Email sent!");
                    } else {
                        errorLabel.setText("Incorrect input.");
                    }
                    
                    mainPanel.repaint();
                } else {
                    errorLabel.setText("Set the public key!");
                    mainPanel.repaint();
                }
            }
        });

        // Add username label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Align labels to the right
        mainPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align fields to the left
        mainPanel.add(usernameField, gbc);

        // Add password label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(passwordField, gbc);

        // Add recipient label and field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(recipientLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(recipientField, gbc);

        // Add message label and area
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        mainPanel.add(messageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JScrollPane(messageArea), gbc);

        // Add submit button
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(sendButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(errorLabel, gbc);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
