package healthcareApp.gui;

import healthcareApp.EmailSender;
import healthcareApp.encryption.Encryption;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DecryptionPanel {
    private JPanel mainPanel;
    private JLabel messageLabel;
    private JTextArea messageArea;
    private JButton decryptButton;
    private JLabel errorLabel;
    private JLabel trueMessage;

    public DecryptionPanel() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
    
        // Create components
        messageLabel = new JLabel("Encrypted Message:");
        messageArea = new JTextArea(5, 15);
        decryptButton = new JButton("Decrypt");
        errorLabel = new JLabel("");
        trueMessage = new JLabel("");
        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Encryption.getD() != 0 && Encryption.getN() != 0) {
                    String decryptedEmail = Encryption.decrypt(messageArea.getText());
                    trueMessage.setText(decryptedEmail);
                    errorLabel.setText("Email decrypted!");
                    mainPanel.repaint();
                } else {
                    errorLabel.setText("Set the private key!");
                    mainPanel.repaint();
                }
            }
        });

        // Add message label and area
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        mainPanel.add(messageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JScrollPane(messageArea), gbc);

        // Add submit button and error label
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(decryptButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(errorLabel, gbc);

        // Add decrypted label
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(trueMessage, gbc);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
